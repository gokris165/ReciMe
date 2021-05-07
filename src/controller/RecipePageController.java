package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class RecipePageController// extends MainMenuController
{
	private String recipeID;
	
	@FXML Text ingredients;
	@FXML Text instructions;
	@FXML Button showRecipeButton;
	@FXML Button backPageButton;
	@FXML Label ingredientsLabel;
	@FXML Label instructionsLabel;
	
		
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
