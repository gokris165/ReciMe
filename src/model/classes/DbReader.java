package model.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings("unchecked")
public class DbReader extends DbConnectionAbs	
{
	static JSONParser parser = new JSONParser();
	/*
	 * This method reads a JSONArray object and returns its contents in
	 * the form of a JSONArray object. 
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
	 * This method will see if 2 user account JSONObjects are equal.
	 */
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
		
		JSONObject j = (JSONObject) getParser("../model/classes/recipes_raw_nosource_fn.json");
		int counter = 0;
		
		Iterator<Object> keys = (Iterator<Object>) j.keySet();
		
		while(keys.hasNext()) {
			if(counter == 8)
				break;
			Object key = keys.next();
			JSONObject recipe = (JSONObject) j.get(key);
			String[] recipeIngredients = (String[]) recipe.get("ingredients");
			String rIngredients = String.join(null, recipeIngredients);
			
			for(String s : ingredients) {
				if(rIngredients.contains(s)) {
					counter++;
					matches.add((String) key);
					break;
				}
			}
			
		}
		
		System.out.println(matches.toString());
		
		return matches;
	}


}
