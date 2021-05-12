package model.classes;

import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/*
 * This class will write to the database. 
 */
@SuppressWarnings("unchecked")
public class DbWriter extends DbConnectionAbs
{	
	/*
	 * This method will write the new userdata into a JSON file. 
	 * The method first reads the existing userdata, copies it,
	 * appends the new user data, and then finally overwrites the JSON file.
	 */
	public static void writeUserData(String username, String password, String fileLocation) 
	{
		JSONArray jsArray = DbReader.readArray(fileLocation);
		JSONObject newUser = wrapUserInfo(username, password);
		jsArray.add(newUser);

		//Re-write to JSON file
		writeArrayToFile(jsArray, fileLocation);
	}
	
	
	// This method writes a JSONArray to a data file.
	private static void writeArrayToFile(JSONArray jsArray, String fileLocation)
	{
		try(FileWriter fw = new FileWriter(fileLocation))
		{	
			fw.write(jsArray.toJSONString());
			fw.flush();
			fw.close();
		}
		catch(Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	
	// This method writes the recommended recipes into a data file.
	public static void writeRecommendations(ArrayList<JSONObject> rec)
	{
		JSONArray jsArray = convertToJSONArray(rec);
		writeArrayToFile(jsArray, "src/model/data/recommendations.json");
	}
	
	
	// This method converts an ArrayList to a JSONArray.
	private static JSONArray convertToJSONArray(ArrayList<JSONObject> list)
	{
		JSONArray arr = new JSONArray();
		for(int i = 0; i < list.size(); i++)
		{
			JSONObject obj = list.get(i);
			arr.add(obj);
		}
		return arr;
	}

	
	// Wraps user info in a JSONObject.
	public static JSONObject wrapUserInfo(String username, String password)
	{
		JSONObject newUser = new JSONObject();
		newUser.put("username", username);
		newUser.put("password", password);
		return newUser;
	}
}
