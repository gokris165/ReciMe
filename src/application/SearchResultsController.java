package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SearchResultsController 
{
	@FXML TextField ingredients;
	private ArrayList<String> matches;
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

	public void search(String[] ingredients)
	{
		this.matches = model.classes.DbReader.findRecipeMatches(ingredients);
		
		fillMatches();
	}
	
	public void fillMatches()
	{
		
	}
}
