package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class EnterIngredientsController extends ControllerAbs 
{
	@FXML TextField ingredients;
	
	
	public void sceneChangetoSearchResults (ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/fxml/SearchResults.fxml"));
		Parent root = loader.load();
		SearchResultsController resultsController = loader.getController();
		
		//get user ingredients input and convert to array
		String ingredientInput = ingredients.getText();
		String[] ingredientsOutput = null;
		
		if(ingredientInput.contains(","))
			ingredientsOutput = ingredientInput.split(",");
		else {
			ingredientsOutput = new String[]{ingredientInput};
		}
		
		ingredients.getScene().setRoot(root);	
		resultsController.search(ingredientsOutput);	
	}
}
