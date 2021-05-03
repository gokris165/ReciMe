package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EnterIngredientsController extends MainMenuController 
{
	@FXML TextField ingredients;
	
	
	public void sceneChangetoSearchResults (ActionEvent event) throws IOException
	{
		//This line is to get the Stage information from the event
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
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
