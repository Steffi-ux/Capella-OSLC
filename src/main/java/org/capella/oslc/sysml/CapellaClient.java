package org.capella.oslc.sysml;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.apache.jena.atlas.logging.Log;
import org.oasis.oslcop.sysml.Connector;
import org.oasis.oslcop.sysml.Element;
import org.oasis.oslcop.sysml.Generalization;
import org.oasis.oslcop.sysml.PortUsage;
import org.oasis.oslcop.sysml.Relationship;
import org.oasis.oslcop.sysml.SysmlClass;
import org.oasis.oslcop.sysml.SysmlPackage;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * Class responsible for fetching and deserializing the resources from the CapellaServer
 * in case of collections, the elements can be serialized to more specific types than what is the type managed by the QueryCapability
 * e.g. QueryCapability for Element can contain types including SysmlClass, SysmlPackage, Connector ... as all of these classes are derived from the Element.
 * This is thanks to the functionality of generic methods deserializeJsonArrayByType and deserializeJsonObjectByType.
 * If such behavior is undesired, it can be changed and these collections can be simply deserialized like the types that have no sub-types Capabilities implemented:
 * 		deserializeCollection(jsonObject,ConcreteType.class);
 * to be strictly of type ConcreteType.
 */
public class CapellaClient {

	/**
	 * Fetches available projects from the CapellaServer
	 * and constructs ServiceProviderInfos from them
	 * @return List of ServiceProviderInfo
	 */
	public static List<ServiceProviderInfo> getProjects() {
		List<ServiceProviderInfo> projects = new ArrayList<ServiceProviderInfo>();
		projects.add(new ServiceProviderInfo("Project1","id1"));
		projects.add(new ServiceProviderInfo("Project2","id2"));
		projects.add(new ServiceProviderInfo("Project3","id3"));
		projects.add(new ServiceProviderInfo("Project4","id4"));
		System.out.println(projects);
		return projects;
	}

	/**
	 * Fetches element from the CapellaServer and deserializes it according to its type
	 * @param projectId project to fetch the element from
	 * @param id identifier of the element to be fetched
	 * @return the obtained element
	 */
	public static Element getElementById(String projectId, String id) {
		String urlString = UrlHelper.getApiResourceByIdPathUrl(projectId, id);
		JsonObject jsonObject = sendGetRequest(urlString);
		List<Class<? extends Element>> possibleTypes = Arrays.asList(SysmlPackage.class, SysmlClass.class,
		Connector.class, Generalization.class, PortUsage.class, Relationship.class, Element.class);
		return deserializeJsonObjectByType(jsonObject, possibleTypes);
        
		
	}

	/**
	 * method for querying project elements
	 * found elements are serialized to the most specific type found
	 * @param projectId project to fetch the elements from
	 * @param page page number
	 * @param limit how many elements should be contained in a page
	 * @param where search terms for the selection dialog
	 * @param prefix search terms for the selection dialog
	 * @return found resources of type Element (including sub-types of Element)
	 */
	public static List<Element> getProjectElements(String projectId, int page, int limit, String where, String prefix) {
		String urlString = getCollectionUrl(UrlHelper.API_URL_ELEMENTS_PATH, projectId, page, limit + 1, where, prefix);
		JsonObject jsonObject = sendGetRequest(urlString);
		return desrializeElements(jsonObject);
	}
	
	/**
	 * method for selecting project elements using selection dialog
	 * found elements are serialized to the most specific type found
	 * @param projectId project to fetch the elements from
	 * @param terms search terms for the selection dialog
	 * @return found resources of type Element (including sub-types of Element)
	 */
	public static List<Element> selectProjectElements(String projectId, String terms) {
		String urlString = UrlHelper.getApiSelectionPathUrl(UrlHelper.API_URL_ELEMENTS_PATH, projectId, terms);
		JsonObject jsonObject = sendGetRequest(urlString);
		return desrializeElements(jsonObject);
	}
	
	/**
	 * method for querying SysmlClass
	 * @param projectId project to fetch the elements from
	 * @param page page number
	 * @param limit how many elements should be contained in a page
	 * @param where search terms for the selection dialog
	 * @param prefix search terms for the selection dialog
	 * @return found resources of type SysmlClass
	 */
	public static List<SysmlClass> getProjectSysmlClasses(String projectId, int page, int limit, String where,
			String prefix) {
		String urlString = getCollectionUrl(UrlHelper.API_URL_SYSML_CLASSES_PATH, projectId, page, limit + 1, where, prefix);
		return deserializeCollection(sendGetRequest(urlString),SysmlClass.class);
	}
	
	/**
	 * method for selecting project SysmlClasses using selection dialog
	 * found elements are serialized to the most specific type found
	 * @param projectId project to fetch the elements from
	 * @param terms search terms for the selection dialog
	 * @return found resources of type SysmlClass
	 */
	public static List<SysmlClass> selectProjectSysmlClasses(String projectId, String terms) {
		String urlString = UrlHelper.getApiSelectionPathUrl(UrlHelper.API_URL_SYSML_CLASSES_PATH, projectId, terms);
		return deserializeCollection(sendGetRequest(urlString),SysmlClass.class);
	}

	/**
	 * method for querying project Relationships
	 * found elements are serialized to the most specific type found
	 * @param projectId project to fetch the elements from
	 * @param page page number
	 * @param limit how many elements should be contained in a page
	 * @param where oslc.where query to filter the resources
	 * @param prefix prefix for the oslc.where query
	 * @return found resources of type Relationship (including sub-types of Relationship)
	 */
	public static List<Relationship> getProjectRelationships(String projectId, int page, int limit, String where,
			String prefix) {
		String urlString = getCollectionUrl(UrlHelper.API_URL_RELATIONSHIP_PATH, projectId, page, limit + 1, where, prefix);
		JsonObject jsonObject = sendGetRequest(urlString);
		List<Class<? extends Relationship>> possibleTypes = Arrays.asList(Generalization.class, Relationship.class);
		return deserializeJsonArrayByType(jsonObject, possibleTypes);
	}

	/**
	 * method for selecting project Relationships using selection dialog
	 * found elements are serialized to the most specific type found
	 * @param projectId project to fetch the elements from
	 * @param terms search terms for the selection dialog
	 * @return found resources of type Relationship (including sub-types of Relationship)
	 */
	public static List<Relationship> selectProjectRelationships(String projectId, String terms) {
		String urlString = UrlHelper.getApiSelectionPathUrl(UrlHelper.API_URL_RELATIONSHIP_PATH, projectId, terms);
		JsonObject jsonObject = sendGetRequest(urlString);
		List<Class<? extends Relationship>> possibleTypes = Arrays.asList(Generalization.class, Relationship.class);
		return deserializeJsonArrayByType(jsonObject, possibleTypes);
	}

	/**
	 * method for querying Generalizations
	 * @param projectId project to fetch the elements from
	 * @param page page number
	 * @param limit how many elements should be contained in a page
	 * @param where oslc.where query to filter the resources
	 * @param prefix prefix for the oslc.where query
	 * @return found resources of type Generalization
	 */
	public static List<Generalization> getProjectGeneralizations(String projectId, int page, int limit, String where,
			String prefix) {
		String urlString = getCollectionUrl(UrlHelper.API_URL_GENERALIZATION_PATH, projectId, page, limit + 1, where, prefix);
		return deserializeCollection(sendGetRequest(urlString),Generalization.class);
	}

	/**
	 * method for selecting project Generalizations using selection dialog
	 * found elements are serialized to the most specific type found
	 * @param projectId project to fetch the elements from
	 * @param terms search terms for the selection dialog
	 * @return found resources of type Generalization
	 */
	public static List<Generalization> selectProjectGeneralizations(String projectId, String terms) {
		String urlString = UrlHelper.getApiSelectionPathUrl(UrlHelper.API_URL_GENERALIZATION_PATH, projectId, terms);
		return deserializeCollection(sendGetRequest(urlString),Generalization.class);
	}

	/**
	 * method for querying SysmlPackages
	 * @param projectId project to fetch the elements from
	 * @param page page number
	 * @param limit how many elements should be contained in a page
	 * @param where oslc.where query to filter the resources
	 * @param prefix prefix for the oslc.where query
	 * @return found resources of type SysmlPackage
	 */
	public static List<SysmlPackage> getSysmlPackages(String projectId, int page, int limit, String where,
			String prefix) {
		String urlString = getCollectionUrl(UrlHelper.API_URL_SYSML_PACKAGES_PATH, projectId, page, limit + 1, where, prefix);
		return deserializeCollection(sendGetRequest(urlString),SysmlPackage.class);
	}

	/**
	 * method for selecting project SysmlPackages using selection dialog
	 * found elements are serialized to the most specific type found
	 * @param projectId project to fetch the elements from
	 * @param terms search terms for the selection dialog
	 * @return found resources of type SysmlPackage
	 */
	public static List<SysmlPackage> selectSysmlPackages(String projectId, String terms) {
		String urlString = UrlHelper.getApiSelectionPathUrl(UrlHelper.API_URL_SYSML_PACKAGES_PATH, projectId, terms);
		return deserializeCollection(sendGetRequest(urlString),SysmlPackage.class);
	}

	/**
	 * method for querying PortUsages
	 * @param projectId project to fetch the elements from
	 * @param page page number
	 * @param limit how many elements should be contained in a page
	 * @param where oslc.where query to filter the resources
	 * @param prefix prefix for the oslc.where query
	 * @return found resources of type PortUsage
	 */
	public static List<PortUsage> getPortUsages(String projectId, int page, int limit, String where, String prefix) {
		String urlString = getCollectionUrl(UrlHelper.API_URL_PORT_USAGES_PATH, projectId, page, limit + 1, where, prefix);
		return deserializeCollection(sendGetRequest(urlString),PortUsage.class);
	}

	/**
	 * method for selecting project PortUsages using selection dialog
	 * found elements are serialized to the most specific type found
	 * @param projectId project to fetch the elements from
	 * @param terms search terms for the selection dialog
	 * @return found resources of type PortUsage
	 */
	public static List<PortUsage> selectPortUsages(String projectId, String terms) {
		String urlString = UrlHelper.getApiSelectionPathUrl(UrlHelper.API_URL_PORT_USAGES_PATH, projectId, terms);
		return deserializeCollection(sendGetRequest(urlString),PortUsage.class);
	}

	/**
	 * method for querying Connectors
	 * @param projectId project to fetch the elements from
	 * @param page page number
	 * @param limit how many elements should be contained in a page
	 * @param where oslc.where query to filter the resources
	 * @param prefix prefix for the oslc.where query
	 * @return found resources of type Connector
	 */
	public static List<Connector> getConnectors(String projectId, int page, int limit, String where, String prefix) {
		String urlString = getCollectionUrl(UrlHelper.API_URL_CONNECTOR_PATH, projectId, page, limit + 1, where, prefix);
		return deserializeCollection(sendGetRequest(urlString),Connector.class);
	}

	/**
	 * method for selecting project Connectors using selection dialog
	 * found elements are serialized to the most specific type found
	 * @param projectId project to fetch the elements from
	 * @param terms search terms for the selection dialog
	 * @return found resources of type Connector
	 */
	public static List<Connector> selectConnectors(String projectId, String terms) {
		String urlString = UrlHelper.getApiSelectionPathUrl(UrlHelper.API_URL_CONNECTOR_PATH, projectId, terms);
		JsonObject jsonObject = sendGetRequest(urlString);
		return deserializeCollection(jsonObject,Connector.class);
	}

	/**
	 * sends a get request to the provided URL 
	 * and returns JsonObject if the request is successful
	 * @param urlString URL of the endpoint to perform the request on
	 * @return JsonObject response
	 * @throws WebApplicationException if the server responds with status code other than OK
	 */
	private static JsonObject sendGetRequest(String urlString) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int status = con.getResponseCode();
			if (status != 200) {
				Log.error(CapellaClient.class, "Unable to fetch elements from capella server. Response status code: " + status);
				throw new WebApplicationException("Unable to fetch elements from capella server.", status);
			}
			return JsonParser.parseReader(new InputStreamReader(con.getInputStream())).getAsJsonObject();
		} catch (IOException e) {
			Log.error(CapellaClient.class, e.getMessage());
			throw new WebApplicationException(e.getMessage(), 500);
		}
	}
	
	/**
	 * deserialization of a single element to the best suitable type from given possible types
	 * the possibleTypes need to be sorted from the most specific to super-types 
	 * (the most specific type is the first element of the array)
	 * @param <T> generic resulting type of the object
	 * @param jsonObject json object to be deserialized
	 * @param possibleTypes possibleTypes Types extending T sorted from the most specific to super-types
	 * @return deserialized object to its most specific type of possibleTypes 
	 * @throws WebApplicationException if the obtained json does not have the expected structure
	 */
	private static <T> T deserializeJsonObjectByType(JsonObject jsonObject, List<Class<? extends T>> possibleTypes) {
		Gson gson = new Gson();
		java.lang.reflect.Type stringListType = new TypeToken<ArrayList<String>>() {
		}.getType();
		List<String> elementTypes = gson.fromJson(jsonObject.get("type"), stringListType);
		if (elementTypes == null) {
			Log.error(CapellaClient.class, "Unable to parse elements from capella server json response: " + jsonObject.toString());
			throw new WebApplicationException("Unable to parse elements from capella server json response.",
					Status.INTERNAL_SERVER_ERROR);
		}
		for (Class<? extends T> type : possibleTypes) {
			if (elementTypes.contains(type.getSimpleName())) {
				return gson.fromJson(jsonObject, type);
			}
		}
		Log.error(CapellaClient.class, "Unable to parse elements from capella server json response: " + jsonObject.toString());
		throw new WebApplicationException("Unable to parse elements from capella server json response.",
				Status.INTERNAL_SERVER_ERROR);
	}

	/**
	 * deserialization of elements in a collection to given types
	 * this enables the results to be returned as the most specific sub-types 
	 * the possibleTypes need to be sorted from the most specific to super-types 
	 * in order to deserialize to correct type
	 * (the most specific type is the first element of the array)
	 * @param <T> Type of the elements in the resulting array
	 * @param jsonCollectionObject
	 * @param possibleTypes Types extending T sorted from the most specific to super-types
	 * @return list of deserialized elements
	 * @throws WebApplicationException if the obtained json does not have the expected structure
	 */
	private static <T> List<T> deserializeJsonArrayByType(JsonObject jsonCollectionObject,
			List<Class<? extends T>> possibleTypes) {
		List<T> result = new ArrayList<T>();
		JsonArray jsonArray = jsonCollectionObject.getAsJsonArray("elements");
		if (jsonArray == null) {
			Log.error(CapellaClient.class, "Unable to parse elements from capella server json response: " + jsonCollectionObject.toString());
			throw new WebApplicationException("Unable to parse elements from capella server json response.",
					Status.INTERNAL_SERVER_ERROR);
		}
		jsonArray.get(0);
		for (JsonElement element : jsonArray) {
			result.add(deserializeJsonObjectByType(element.getAsJsonObject(), possibleTypes));
		}
		return result;
	}

	/**
	 * method for deserializing collection of elements 
	 * @param jsonObject object containing the elements
	 * @return List of type Element (including more specific type)
	 */
	private static List<Element> desrializeElements(JsonObject jsonObject){
		List<Class<? extends Element>> possibleTypes = Arrays.asList(SysmlPackage.class, SysmlClass.class,
				Connector.class, Generalization.class, PortUsage.class, Relationship.class, Element.class);
		return deserializeJsonArrayByType(jsonObject, possibleTypes);
	}

	/**
	 * deserializes collection to the exact given type
	 * @param <T> generic type of the resulting objects
	 * @param jsonObject object containing the elements
	 * @param elementType type of the resulting objects
	 * @return List of elements of type T (exactly T)
	 */
	private static <T> List<T> deserializeCollection(JsonObject jsonObject, Class<T> elementType){
		java.lang.reflect.Type listType = TypeToken.getParameterized(ArrayList.class, elementType).getType();
		Gson gson = new Gson();
		return gson.fromJson(jsonObject.get("elements"), listType);
	}

	/**
	 * gets the URL string from UrlHelper with transformed oslc.where query to AQL expression
	 * if the oslc.where query is provided
	 * @param elementPath path of the servlet containing the elements 
	 * @param projectName project to fetch the elements from
	 * @param page page number
	 * @param limit how many elements should be contained in a page
	 * @param where oslc.where query to filter the resources
	 * @param prefix prefix for the oslc.where query
	 * @return constructed URL string for the CapellaServer endpoint 
	 * with transformed AQL query if the query is provided 
	 */
	private static String getCollectionUrl(String elementPath, String projectName, int page, int limit, String where,
			String prefix) {
		if (where == null) {
			return UrlHelper.getApiCollectionUrl(elementPath, projectName, page, limit, null);
		}
		String aqlExpression = WhereQueryAqlTransformer.parseQueryToAqlExpression(where, prefix);
		return UrlHelper.getApiCollectionUrl(elementPath, projectName, page, limit, aqlExpression);
 	}

}
