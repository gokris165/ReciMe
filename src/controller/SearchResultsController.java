package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class SearchResultsController extends RpResultsAbs
{
	@FXML Button result1, result2, result3, result4, result5, result6, result7, result8, result9;
	private HashMap<Button, JSONObject> recipeMapper = new HashMap<>();
	private ArrayList<String> matches;
	
	
	public void search(String[] ingredients) throws IOException
	{
		this.matches = model.classes.DbReader.findRecipeMatches(ingredients);
		fillMatches();
	}
	
	
	// This method sets up the search results page.
	public void fillMatches() throws IOException
	{
		ArrayList<JSONObject> recipeMatches = model.classes.DbReader.getMatches(matches);
		Button[] buttons = getButtons();
		mapRecipeToButton(recipeMatches, buttons, recipeMapper);
		loadFXML();
		writeRecommendationsToFile(recipeMatches);
	}
	
	
	// This method will save the search results as recommendations.
	private void writeRecommendationsToFile(ArrayList<JSONObject> recipes)
	{
		model.classes.DbWriter.writeRecommendations(recipes);
	}
	
	
	// Loads the FXML file of the Search Results Page.
	protected void loadFXML() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/fxml/SearchResults.fxml"));
		loader.load();
	}
	
	
	private Button[] getButtons()
	{
		return new Button[] {result1, result2, result3, result4, 
				result5, result6, result7, result8, result9};
	}
	
	
	protected HashMap<Button, JSONObject> getRecipeMapper()
	{
		return recipeMapper;
	}
}
