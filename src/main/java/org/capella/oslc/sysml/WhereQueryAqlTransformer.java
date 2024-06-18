package org.capella.oslc.sysml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.apache.jena.atlas.logging.Log;
import org.eclipse.lyo.core.query.ComparisonTerm;
import org.eclipse.lyo.core.query.InTerm;
import org.eclipse.lyo.core.query.ParseException;
import org.eclipse.lyo.core.query.QueryUtils;
import org.eclipse.lyo.core.query.SimpleTerm;
import org.eclipse.lyo.core.query.Value;
import org.eclipse.lyo.core.query.WhereClause;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.oasis.oslcop.sysml.SysmlDomainConstants;

public class WhereQueryAqlTransformer {

    private static Map<String,String> map = new HashMap<String,String>();
    static 
    {
    	map.put(OslcConstants.DCTERMS_NAMESPACE_PREFIX, OslcConstants.DCTERMS_NAMESPACE);
    	map.put(SysmlDomainConstants.SYSML_NAMSPACE_PREFIX, SysmlDomainConstants.SYSML_NAMSPACE);
    }
	
    /**
     * Transforms simple oslc.where query to Acceleo Query Language logical expression
     * @param where oslc.where query to be parsed
     * @param prefix oslc.prefix to be parsed
     * @return aql expression
	 * @throws WebApplicationException if query can not be parsed or contains any unsupported terms
     */
	public static String parseQueryToAqlExpression(String where, String prefix) {
		try {
			Map<String,String> prefixes = QueryUtils.parsePrefixes(prefix);
			prefixes.putAll(map);
			WhereClause wc = QueryUtils.parseWhere(where, prefixes);
			List<SimpleTerm> terms = wc.children();
			String aqlQuery = "e | ".concat(transformTermToAql(terms.get(0)));
			for(int i=1; i< terms.size(); i++) {
				aqlQuery = aqlQuery
					.concat(" and ")
					.concat(transformTermToAql(terms.get(i)));
			}
			return aqlQuery;
		} catch (ParseException e) {
			Log.error(WhereQueryAqlTransformer.class, "Could not parse query '" + where + "'.");
			throw new WebApplicationException(e, Status.BAD_REQUEST);
		}
	}
	
	/**
	 * Transforms single term to aql expression
	 * @param term oslc.where term to be transformed
	 * @return aql expression corresponding to the term
	 * @throws WebApplicationException if term type is not supported
	 */
	private static String transformTermToAql(SimpleTerm term) {
		switch(term.type()) {
		case COMPARISON:
		    ComparisonTerm comparisonTerm = (ComparisonTerm)term;
		    return transformComparisonTermToAql(comparisonTerm);
		case IN_TERM:
		    InTerm inTerm = (InTerm) term;
		    return transformInTermToAql(inTerm);
		default:
			Log.error(WhereQueryAqlTransformer.class, "Unsupported oslc.where query.");
	        throw new WebApplicationException(new UnsupportedOperationException("Unsupported oslc.where query."),Status.BAD_REQUEST);                
		}
	}
	
	/**
	 * Transforms single in term to aql disjunctions wrapped in parentheses
	 * @param inTerm oslc.where term to be transformed
	 * @return aql expression corresponding to the term
	 */
	private static String transformInTermToAql(InTerm inTerm) {
		String aqlTerm = "( ";
		String transformedTermBase = "e."
				.concat(transformPropertyNameToAql(inTerm.property().local))
				.concat(" = ");
		
		List<Value> values = inTerm.values();
		aqlTerm = aqlTerm
			.concat(transformedTermBase)
			.concat(transformPropertyValueToAql(values.get(0)));
		for(int i=1; i< values.size(); i++) {
			aqlTerm = aqlTerm
				.concat(" or ")
				.concat(transformedTermBase)
				.concat(transformPropertyValueToAql(values.get(i)));
		}
		return aqlTerm.concat(" )");
	}

	/**
	 * Transforms single comparison term to aql expression
	 * equals and not equals is supported
	 * @param inTerm oslc.where term to be transformed
	 * @return aql expression corresponding to the term
	 * @throws WebApplicationException if term operator is not supported
	 */
	private static String transformComparisonTermToAql(ComparisonTerm comparisonTerm) {
	    String operator;
		switch (comparisonTerm.operator()) {
	        case EQUALS:
	            operator = " = ";
	            break;
	        case NOT_EQUALS:
	            operator = " <> ";
	            break;
	        default:
				Log.error(WhereQueryAqlTransformer.class, "Unsupported oslc.where query.");
	            throw new WebApplicationException(new UnsupportedOperationException("Unsupported oslc.where query."),Status.BAD_REQUEST);                
	    }
		return "e."
				.concat(transformPropertyNameToAql(comparisonTerm.property().local))
				.concat(operator)
				.concat(transformPropertyValueToAql(comparisonTerm.operand()));
	}
	
	/**
	 * Transforms property string value to aql string enclosed with single quotes
	 * @param inTerm oslc.where term to be transformed
	 * @return aql expression corresponding to the term
	 * @throws WebApplicationException if value is not a string
	 */
	private static String transformPropertyValueToAql(Value value) {
		switch(value.type()) {
	    	case STRING:
	    		return "'"+value.toString().substring(1,value.toString().length() -1)+"'";
	    	case URI_REF:
	    		return getIdFromUriRef(value.toString());
	        default:
				Log.error(WhereQueryAqlTransformer.class, "Unsupported oslc.where query.");
	            throw new WebApplicationException(new UnsupportedOperationException("Unsupported oslc.where query."),Status.BAD_REQUEST);                
		}
	}
	
	/**
	 * helper method to get the id from uri ref
	 * as the owner translates to the eContainer().id equality check
	 * @param uriRef uri reference of the owner element 
	 * @return id of the referenced element or empty string if the uri ref is not of known form
	 */
	private static String getIdFromUriRef(String uriRef) {
		int index = uriRef.toString().indexOf("elements/");
		if(index == -1) {
			Log.warn(WhereQueryAqlTransformer.class, "Unsupported oslc.where uri ref value: '" + uriRef + "'.");
			return ""; 
		}
		return "'" + uriRef.substring(index + 9, uriRef.length() -1) + "'";
	}
	
	/**
	 * Transforms known name to corresponding Capella property name
	 * @param propertyName sysml model property name 
	 * @return corresponding property name in Capella model
	 * @throws WebApplicationException if name does not match the defined names ("name","owner","identifier")
	 */
	private static String transformPropertyNameToAql(String propertyName) {
		switch(propertyName){
        case "name":
        	return "name";
        case "owner":
        	return "eContainer().id";
        case "identifier":
        	return "id";
        default:
			Log.error(WhereQueryAqlTransformer.class, "Unsupported oslc.where query.");
            throw new WebApplicationException(new UnsupportedOperationException("Unsupported oslc.where query."),Status.BAD_REQUEST);                
		}
	}
	
}
