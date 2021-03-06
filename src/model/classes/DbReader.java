package model.classes;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
public class DbReader extends DbConnectionAbs
{
	/*
	 * This method reads a JSONArray object and returns its contents in
	 * the form of a JSONArray object. 
	 * 
	 * This is used to read all of the existing user accounts, and then 
	 * we can append the new user account data and use the modified
	 * JSONArray to overwrite the user account data file.
	 * 
	 * Almost all of our data is being stored as a JSONArray object
	 */
	public static JSONArray readArray(String fileLocation)
	{
		JSONArray jsArray = (JSONArray)getParser(fileLocation);
		JSONArray newArray = new JSONArray();
		
		//Iterate over the JSONArray
		Iterator<JSONObject> iter = jsArray.iterator();
		while(iter.hasNext())
		{
			JSONObject temp = iter.next();
			newArray.add(temp);
		}
		return newArray;
	}
	
	
	/*
	 * This method will search for a specific JSONObject from a JSONArray.
	 * The method will return null if the target is not present in the JSONArray.
	 * 
	 * This is used to check if the user input username and password are in the database.
	 */
	public static JSONObject findEntry(JSONObject target, JSONArray array)
	{
		Iterator<JSONObject> iter = array.iterator();
		while(iter.hasNext())
		{
			JSONObject temp = iter.next();
			if(isEqualAccount(target, temp))
				return temp;
		}
		return null;
	}
	
	
	/*
	 * This method converts a JSONArray of string objects into an ArrayList<String>
	 */
	public static ArrayList<String> convertIngredients(JSONArray j)
	{
		if(j == null)
			return new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < j.size(); i++) 
		{
		    list.add((String) j.get(i).toString());
		}
		return list;
	}
	
	
	// This method will see if 2 user account JSONObjects are equal.
	public static boolean isEqualAccount(JSONObject first, JSONObject second)
	{
		String firstUser = (String) first.get("username");
		String secondUser = (String) second.get("username");
		String firstPass = (String) first.get("password");
		String secondPass = (String) second.get("password");
		return ( (firstUser.equals(secondUser)) && (firstPass.equals(secondPass)));
	}
	
	
	/*
	 * This method will search for and return all recipes that match a set of ingredients
	 */
	public static ArrayList<String> findRecipeMatches(String[] ingredients)
	{
		ArrayList<String> matches = new ArrayList<String>();
		
		JSONObject j = (JSONObject) getParser("src/model/data/recipes_raw_nosource_fn.json");
		int counter = 0;
		
		Iterator<String> keys = j.keySet().iterator() ;
		
		while(keys.hasNext()) {
			if(counter == 9)
				break;
			String key = keys.next();
			JSONObject recipe = (JSONObject) j.get(key);
			ArrayList<String> recipeIngredients = convertIngredients((JSONArray) recipe.get("ingredients"));
			String rIngredients = String.join(", ", recipeIngredients);

			if(isMatch(rIngredients, ingredients)) {
				counter++;
				matches.add((String) key);
			}
		}
		return matches;
	}
	
	
	public static boolean isMatch(String ingredients, String[] search) 
	{
		boolean match = true;
		for (String s : search) {
			if(!ingredients.contains(s)) {
				match = false;
				break;
			}
				
		}
		return match;
	}
	
	
	public static ArrayList<JSONObject> getMatches(ArrayList<String> matchIds)
	{
		ArrayList<JSONObject> result = new ArrayList<JSONObject>();
		JSONObject j = (JSONObject) getParser("src/model/data/recipes_raw_nosource_fn.json");
		for (String i : matchIds) 
		{
			result.add((JSONObject) j.get(i));
		}
		return result;
	}
	
	
	// This methods reads the recommendations file and returns an ArrayList<JSONObject> 
	// containing all the recommended recipes.
	public static ArrayList<JSONObject> readRecommendations(String fileLocation)
	{
		JSONArray jsArray = readArray(fileLocation);
		ArrayList<JSONObject> list = new ArrayList<>();
		for(int i = 0; i < jsArray.size(); i++)
		{
			JSONObject obj = (JSONObject)jsArray.get(i);
			list.add(obj);
		}
		return list;
	}
}
