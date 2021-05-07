package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public abstract class ControllerAbs 
{
	public Stage primaryStage = application.Main.window;
	
	
	/*
	 * This method changes the scene to the login page.
	 */
	public void getLoginPage() throws IOException
	{
		StackPane loginPagePane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/LoginPage.fxml"));
		Scene loginPageScene = new Scene(loginPagePane,1080,630);
		
		primaryStage.setScene(loginPageScene);
		primaryStage.show();
	}
	
	
	/*
	 * This method changes the scene to the tutorials page.
	 */
	public void getTutorialPage() throws IOException
	{
		StackPane TutorialsPane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/Tutorial.fxml"));
		Scene tutorialScene = new Scene(TutorialsPane,1080,630);
		
		primaryStage.setScene(tutorialScene);
		primaryStage.show();
	}
	
	
	/*
	 * This method changes the scene to the Enter Ingredients page.
	 */
	public void getEnterIngredientsPage() throws IOException
	{
		StackPane IngredientsPane = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/EnterIngredients.fxml"));
		Scene IngredientsScene = new Scene(IngredientsPane,1080,630);
		
		primaryStage.setScene(IngredientsScene);
		primaryStage.show();
	}
	
	
	/*
	 * This method closes the program.
	 */
	public void closeApplication()
	{
		primaryStage.close();
	}
}
