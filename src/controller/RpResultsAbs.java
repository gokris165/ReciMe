package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public abstract class RpResultsAbs extends ControllerAbs
{	
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
		Button b = (Button)event.getTarget();						// The button that was clicked by the user.
		
		HashMap<Button, JSONObject> map = getRecipeMapper();		
		JSONObject recipe = map.get(b);								// The recipe mapped to the corresponding button.
		
		// Get the relevant recipe information from the JSONObject
		String recipeTitle = getRecipeTitle(recipe);
		String recipeIngredients = getRecipeIngredients(recipe);
		String recipeInstructions = getRecipeInstructions(recipe);
		
		// Setting up the recipe page
		setRecipeText(recipeTitle, recipeIngredients, recipeInstructions);
		initializeRecipePage();
		
		// Switching to the recipe page
		getRecipePage();
	}
	
	
	// Loads the FXML file of the corresponding page.
	protected abstract void loadFXML() throws IOException;
	
	
	// This method maps the recipes to the buttons and links them through a HashMap.
	protected static void mapRecipeToButton(ArrayList<JSONObject> list, Button[] buttons, HashMap<Button, JSONObject> map)
	{
		for(int i = 0; i < list.size(); i++)
		{
			buttons[i].setText((String) list.get(i).get("title"));
			map.put(buttons[i], list.get(i));
		}
	}
	
	
	protected abstract HashMap<Button, JSONObject> getRecipeMapper();
	
	
	// This method converts the ingredients array from the JSON Object into a String.
	protected String getRecipeIngredients(JSONObject recipe)
	{
		ArrayList<String> ingredientsList = model.classes.DbReader.convertIngredients((JSONArray)recipe.get("ingredients"));
		return String.join(", ", ingredientsList);
	}
	
	
	protected String getRecipeTitle(JSONObject recipe)
	{
		return (String)recipe.get("title");
	}
	
	
	protected String getRecipeInstructions(JSONObject recipe)
	{
		return (String)recipe.get("instructions");
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
