package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainMenuController 
{
	/*
	 * This method changes the scene to the login page.
	 */
	public void sceneChangeToLoginPage(ActionEvent event) throws IOException
	{
		StackPane loginPagePane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/LoginPage.fxml"));
		Scene loginPageScene = new Scene(loginPagePane,1080,630);
		
		//This line is to get the Stage information from the event
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(loginPageScene);
		window.show();
	}
	
	
	/*
	 * This method changes the scene to the tutorials page.
	 */
	public void sceneChangeToTutorials(ActionEvent event) throws IOException
	{
		StackPane TutorialsPane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/Tutorial.fxml"));
		Scene tutorialScene = new Scene(TutorialsPane,1080,630);
		
		//This line is to get the Stage information from the event
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(tutorialScene);
		window.show();
	}
	
	
	/*
	 * This method changes the scene to the Enter Ingredients page.
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
	 * This method closes the program.
	 */
	public void exitButton(ActionEvent event)
	{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
}
