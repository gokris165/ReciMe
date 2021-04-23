package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("../view/fxml/LoginPage.fxml"));
			Scene scene = new Scene(root,1080,630);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
