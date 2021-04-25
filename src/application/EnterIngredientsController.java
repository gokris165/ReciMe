package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EnterIngredientsController 
{
	@FXML TextField ingredients;
	
	/*
	 * This method changes the scene to the main menu
	 */
	public void sceneChangeToMainMenu(ActionEvent event) throws IOException
	{
		StackPane mainMenuPane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/MainMenu.fxml"));
		Scene mainMenuScene = new Scene(mainMenuPane,1080,630);
		
		//This line is to get the Stage information from the event
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(mainMenuScene);
		window.show();
	}
	
	public void sceneChangetoSearchResults (ActionEvent event) throws IOException
	{
		//This line is to get the Stage information from the event
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/fxml/SearchResults.fxml"));
		SearchResultsController resultsController = loader.getController();
		
		//get user ingredients input and convert to array
		String ingredientInput = ingredients.getText();
		String[] ingredientsOutput = ingredientInput.split(",");
		
		resultsController.search(ingredientsOutput);
		
		StackPane resultsPane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/SearchResults.fxml"));
		Scene resultsScene = new Scene(resultsPane,1080,630);
		
		window.setScene(resultsScene);
		window.show();
		
	}
}
