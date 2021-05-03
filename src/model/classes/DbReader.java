package model.classes;

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
}
