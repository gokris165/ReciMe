package model.classes;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class DbConnectionAbs 
{
	/**
	 * This method will parse the given file and return a JSONParser as an Object 
	 * containing the reference to the file. The parser Object can then be used to 
	 * read an existing JSON file.
	 * 
	 * @param location : location of the JSON file
	 * @return parseObject : parse object pointing to the JSON file.
	 */
	static Object getParser(String location)
	{
		JSONParser parser = new JSONParser();
		Object parseObject = null;
		
		try 
		{
			parseObject = (Object)parser.parse(new FileReader(location));
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		
		return parseObject;
	}
}
