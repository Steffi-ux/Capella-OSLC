package data;

import org.oasis.oslcop.sysml.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Testdata {
	 public static Element deserializeJsonObjectByType(JsonObject jsonObject, Class<?> possibleType) {
	        String id = jsonObject.get("id").getAsString();
	        String name = jsonObject.get("name").getAsString();
	        String type = jsonObject.get("type").getAsString();
	        return new Element();
	    }

	    // Methode zum Abrufen eines Elements anhand seiner ID
	    public static Element getElementById(String projectId, String id) {
	        String json = "["
	                + "{\"projectId\": \"1\", \"elements\": ["
	                + "  {\"id\": \"e1\", \"name\": \"Element 1\", \"type\": \"Type A\"},"
	                + "  {\"id\": \"e2\", \"name\": \"Element 2\", \"type\": \"Type B\"}]},"
	                + "{\"projectId\": \"2\", \"elements\": ["
	                + "  {\"id\": \"e3\", \"name\": \"Element 3\", \"type\": \"Type A\"},"
	                + "  {\"id\": \"e4\", \"name\": \"Element 4\", \"type\": \"Type B\"}]}]";

	        JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();

	        for (JsonElement projectElement : jsonArray) {
	            JsonObject projectObject = projectElement.getAsJsonObject();
	            if (projectObject.get("projectId").getAsString().equals(projectId)) {
	                JsonArray elements = projectObject.get("elements").getAsJsonArray();
	                for (JsonElement element : elements) {
	                    JsonObject elementObject = element.getAsJsonObject();
	                    if (elementObject.get("id").getAsString().equals(id)) {
	                        return deserializeJsonObjectByType(elementObject, Element.class);
	                    }
	                }
	            }
	        }

	        return null; // Falls das Element nicht gefunden wird
	    
	}

}
