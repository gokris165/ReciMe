package controller;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class SearchResultsController extends ControllerAbs
{
	@FXML Button result1, result2, result3, result4, result5, result6, result7, result8, result9;
	private ArrayList<String> matches;
	

	public void search(String[] ingredients) throws IOException
	{
		this.matches = model.classes.DbReader.findRecipeMatches(ingredients);
		
		fillMatches();
	}
	
	
	public void fillMatches() throws IOException
	{
		ArrayList<JSONObject> recipeMatches = model.classes.DbReader.getMatches(matches);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/fxml/SearchResults.fxml"));
		
		Button[] buttons = new Button[] {result1, result2, result3, result4, 
				result5, result6, result7, result8, result9};
		
		for(int i = 0; i < recipeMatches.size(); i++) {
			buttons[i].setText((String) recipeMatches.get(i).get("title"));
		}
		
		for (Button b : buttons) {
			System.out.println(b.getText());
		}
		
		loader.load();
	}
}
