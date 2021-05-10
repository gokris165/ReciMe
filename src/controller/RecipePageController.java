package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RecipePageController extends ControllerAbs
{
	@FXML private Label title;
	@FXML private Label ingredients;
	@FXML private Label instructions;
	
	public static String titleText = "";
	public static String ingredientsText = "";
	public static String instructionsText = "";
		
	@FXML
	public void initialize()
	{
		title.setText(titleText);
		ingredients.setText(ingredientsText);
		instructions.setText(instructionsText);
	}
}
