package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RecipePageController extends MainMenuController
{
	
	private String recipeID;
	
	@FXML Text ingredients;
	@FXML Text instructions;
	@FXML Button showRecipeButton;
	@FXML Button backPageButton;
	@FXML Label ingredientsLabel;
	@FXML Label instructionsLabel;
	
	
	/*
	 * This method returns the user to the enter ingredients page.
	 */
	public void sceneChangeToEnterIngredients(ActionEvent event) throws IOException
	{
		StackPane IngredientsPane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/EnterIngredients.fxml"));
		Scene IngredientsScene = new Scene(IngredientsPane,1080,630);
		
		//This line is to get the Stage information from the event
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(IngredientsScene);
		window.show();
	}
	
	
	/*
	 * This method shows the list of ingredients and instructions on how to make
	 * the dish that the user selects when a button is clicked.
	 */
	public void showRecipe(ActionEvent event) throws IOException
	{
		showRecipeButton.setVisible(false);		//Setting button visibility to false disables the button
		
	//	ingredients.setText(/*Put here the ingredients necessary in a vbox(?) on the right side of the cutting board*/);
	//	instructions.setText(/*Put here the instructions on the left side of the cutting board*/);
		ingredientsLabel.setOpacity(1);
		instructionsLabel.setOpacity(1);
	}
	
	
}
