package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class SearchResultsController extends ControllerAbs
{
	@FXML Button result1, result2, result3, result4, result5, result6, result7, result8, result9;
	private ArrayList<String> matches;
	private HashMap<Button, JSONObject> recipeMapper = new HashMap<>();
	
	
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
		
		for(int i = 0; i < recipeMatches.size(); i++) 
		{
			buttons[i].setText((String) recipeMatches.get(i).get("title"));
			recipeMapper.put(buttons[i], recipeMatches.get(i));
		}
		loader.load();
	}
	
	
	// This method changes the scene to the recipe page.
	public void getRecipePage() throws IOException
	{
		StackPane recipePagePane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/RecipePage.fxml"));
		Scene recipePageScene = new Scene(recipePagePane,1080,630);
		
		primaryStage.setScene(recipePageScene);
		primaryStage.show();
	}
	
	
	/*
	 * This method creates the recipe page for the corresponding user
	 * selected recipe.
	 * 
	 * HOW:
	 * The recipe buttons that the user can click each have their recipes mapped
	 * to them with a HashMap. This method first extracts the recipe from its button,
	 * then extracts the relevant recipe information required (title, ingredients, instructions)
	 * and sets it to be displayed on its recipe page, then initializes the recipe page 
	 * and switches scenes to the new recipe page. 
	 */
	public void createRecipePage(Event event) throws IOException
	{
		Button b = (Button)event.getTarget();								// The button that was clicked by the user.
		JSONObject recipe = recipeMapper.get(b);							// The recipe mapped to the corresponding button.
		
		// Get the relevant recipe information from the JSONObject
		String recipeTitle = (String)recipe.get("title");
		ArrayList<String> ingredientsList = model.classes.DbReader.convertIngredients((JSONArray)recipe.get("ingredients"));
		String recipeIngredients = String.join(", ", ingredientsList);
		String recipeInstructions = (String)recipe.get("instructions");
		
		// Setting up the recipe page
		setRecipeText(recipeTitle, recipeIngredients, recipeInstructions);
		initializeRecipePage();
		
		// Switching to the recipe page
		getRecipePage();
	}
	
	
	// This method sets the title, ingredients, and instructions of the recipe on its page.
	public void setRecipeText(String title, String ingredients, String instructions)
	{
		RecipePageController.titleText = title;
		RecipePageController.ingredientsText = ingredients;
		RecipePageController.instructionsText = instructions;
	}
	
	
	// This method initializes the recipe page with all the recipe information to be displayed.
	@SuppressWarnings("unused")
	public void initializeRecipePage() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/fxml/RecipePage.fxml"));
		Parent root = (Parent)loader.load();
		RecipePageController rpControl = loader.getController();
		rpControl.initialize();
	}
}
