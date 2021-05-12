package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class MainMenuController extends RpResultsAbs
{
	@FXML Button rec1, rec2, rec3, rec4, rec5, rec6, rec7, rec8, rec9;
	private HashMap<Button, JSONObject> recipeMapper = new HashMap<>();

	
	// This method sets up the main menu page.
	public void initialize() throws IOException
	{
		ArrayList<JSONObject> list = readRecommendationsFromFile("src/model/data/recommendations.json");
		Button[] buttons = getButtons();
		mapRecipeToButton(list, buttons, recipeMapper);
	}
	
	
	// This method returns an ArrayList full of recommended recipes.
	private ArrayList<JSONObject> readRecommendationsFromFile(String fileLocation)
	{
		return model.classes.DbReader.readRecommendations(fileLocation);
	}
	
	
	// This method loads the FXML file for the main menu page.
	protected void loadFXML() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/fxml/MainMenu.fxml"));
		loader.load();
	}
	
	
	private Button[] getButtons()
	{
		return new Button[] {rec1, rec2, rec3, rec4, rec5, rec6, rec7, rec8, rec9};
	}
	
	
	protected HashMap<Button, JSONObject> getRecipeMapper()
	{
		return recipeMapper;
	}
}
