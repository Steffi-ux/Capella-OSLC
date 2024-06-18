package org.capella.oslc.sysml;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.jena.atlas.logging.Log;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;

/**
 * Class holding constants and utility methods for constructing CapellaServer URL strings
 */
public class UrlHelper {
	public static final String API_URL_BASE = "http://localhost:3333";
	public static final String API_URL_PROJECTS_PATH = "/projects";
	public static final String API_URL_ELEMENTS_PATH = "/element";
	public static final String API_URL_SYSML_CLASSES_PATH = "/sysmlclass";
	public static final String API_URL_RELATIONSHIP_PATH = "/relationship";
	public static final String API_URL_GENERALIZATION_PATH = "/generalization";
	public static final String API_URL_SYSML_PACKAGES_PATH = "/sysmlpackage";
	public static final String API_URL_RESOURCES_PATH = "/resources";
	public static final String API_URL_PORT_USAGES_PATH = "/portusage";
	public static final String API_URL_CONNECTOR_PATH = "/connector";

	/**
	 * provides URL string for getting element by id
	 * @param projectName name of the project that contains the element
	 * @param elementId id of the element
	 * @return string to construct the URL for fetching the resource from
	 */
	public static String getApiResourceByIdPathUrl(String projectName, String elementId) {
		String linkBaseUrl = getEncodedLinkBaseUrl(projectName);
		return API_URL_BASE + API_URL_RESOURCES_PATH + "?projectName=" + projectName + "&elementId=" + elementId
				+ "&linkBaseUrl=" + linkBaseUrl;
	}

	/**
	 * constructs encoded URL string, that CapellaServer can use to construct links to referenced resources
	 * @param projectName name of the project that contains the element
	 * @return string to construct the URL for fetching the resource from
	 */
	public static String getEncodedLinkBaseUrl(String projectName) {
		String url = OSLC4JUtils.getPublicURI().toString() + "/services/projects/" + projectName + "/elements/";
		return encodeUrlText(url);
	}

	/**
	 * constructs URL string for selection dialog
	 * @param elementPath path of the servlet containing the elements 
	 * can be selected from the constants that this class holds like API_URL_ELEMENTS_PATH
	 * @param projectName name of the project to search in
	 * @param searchTerm fulltext search term
	 * @return string to construct the URL for fulltext search
	 */
	public static String getApiSelectionPathUrl(String elementPath, String projectName, String searchTerm) {
		String linkBaseUrl = getEncodedLinkBaseUrl(projectName);
		String encodedSearchText = encodeUrlText(searchTerm);
		return API_URL_BASE + elementPath + "?projectName=" + projectName + "&fullTextSearch=" + encodedSearchText
				+ "&linkBaseUrl=" + linkBaseUrl;
	}

	/**
	 * constructs URL string for querying resources 
	 * @param elementPath path of the servlet containing the elements 
	 * can be selected from the constants that this class holds like API_URL_ELEMENTS_PATH
	 * @param projectName name of the project to search in
	 * @param page page number
	 * @param limit how many elements should be contained in a page
	 * @param aqlExpression expression to filter the resources
	 * @return
	 */
	public static String getApiCollectionUrl(String elementPath, String projectName, int page, int limit, String aqlExpression) {
		String linkBaseUrl = getEncodedLinkBaseUrl(projectName);
		String url = API_URL_BASE + elementPath + "?projectName=" + projectName + "&page=" + page + "&limit=" + limit
				+ "&linkBaseUrl=" + linkBaseUrl;
		if (aqlExpression == null) {
			return url;
		}
		String encodedAqlExpression = encodeUrlText(aqlExpression);
		return url + "&aqlExpr=" + encodedAqlExpression;
	}

	/**
	 * encodes the string to be URL safe
	 * @param text string to be encoded
	 * @return encoded string
	 */
	private static String encodeUrlText(String text) {
		try {
			return URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			Log.warn(UrlHelper.class, e.getMessage());
			return URLEncoder.encode(text);
		}
	}

}
