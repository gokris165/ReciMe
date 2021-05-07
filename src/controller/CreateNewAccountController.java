package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateNewAccountController
{
	@FXML private Label errorLabel;
	@FXML private TextField userID;
	@FXML private TextField passID;
	private String username = "";
	private String password = "";
	
	
	/*
	 * When this method is called, the pop-up window is closed and we return to the login page.
	 */
	public void cancelButton(ActionEvent event) throws IOException
	{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	
	
	//This method will record the username entered in the text field.
	public void getUsername()
	{
		username = userID.getText();
	}
	
	
	//This method will record the username entered in the text field.
	public void getPassword()
	{
		password = passID.getText();
	}
	
	
	//This method will display a label saying that the username/password are too short
	public void displayErrorLabel()
	{
		errorLabel.setOpacity(1);
	}
	
	
	public void hideErrorLabel()
	{
		errorLabel.setOpacity(0);
	}
	
	
	// check if username and password are greater than 0 characters
	public boolean isLegal()
	{
		getUsername();
		getPassword();
		
		if(username.length() < 1 || password.length() < 1)
		{
			displayErrorLabel();
			return false;
		}
		hideErrorLabel();
		return true;
	}
	
	// This method will call another method from the Model package to create a new account.
	public void createButton(ActionEvent event)
	{
		if(!isLegal())
			return;
		
		model.classes.DbWriter.writeUserData(username, password, "src/model/data/userdata.json");
		
		// Close pop-up window 
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setTitle("SUCCESS!");
		window.close();
	}
}
