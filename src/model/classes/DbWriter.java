package model.classes;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/*
 * This class will write to the database. 
 * The only reason we need to write to the database is when a new user account is created.
 * This class will add the new user account data to the userdata file.
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
	
	
	// Wraps user info in a JSONObject
	public static JSONObject wrapUserInfo(String username, String password)
	{
		JSONObject newUser = new JSONObject();
		newUser.put("username", username);
		newUser.put("password", password);
		return newUser;
	}
}
