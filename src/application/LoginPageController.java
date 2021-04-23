package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginPageController 
{
	
	/*
	 * When this method is called, the scene changes to the main menu.
	 * 
	 * First we get the view of the main menu and pass that to the scene object. 
	 * Then we need to get the stage information and pass the scene to the stage object.
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
	
	
	/*
	 * This method closes the program.
	 */
	public void exitButton(ActionEvent event)
	{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	
}
