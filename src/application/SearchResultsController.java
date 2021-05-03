package application;

import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class SearchResultsController 
{
	@FXML Button result1, result2, result3, result4, result5, result6, result7, result8, result9;
	private ArrayList<String> matches;
	

	public void sceneChangeToLogIn(ActionEvent event) throws IOException
	{
		StackPane loginPane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/LoginPage.fxml"));
		Scene loginScene = new Scene(loginPane,1080,630);
		
		//This line is to get the Stage information from the event
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(loginScene);
		window.show();
	}
	
	public void sceneChangeToTutorial(ActionEvent event) throws IOException
	{
		StackPane tutorialPane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/Tutorial.fxml"));
		Scene tutorialScene = new Scene(tutorialPane,1080,630);
		
		//This line is to get the Stage information from the event
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tutorialScene);
		window.show();
	}

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
