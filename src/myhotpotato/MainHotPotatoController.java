package myhotpotato;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainHotPotatoController {
	

	static Stage instructionStage;
	static Stage playerDataStage;
	static Stage playStage;
	static Stage gameStage;
	
	
	public void openPlayerData() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerData.fxml"));
			BorderPane playerDataWindow = (BorderPane)loader.load();
			Scene playerDataScene = new Scene(playerDataWindow,500,500);
			playerDataScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			playerDataStage = new Stage();
			playerDataStage.setScene(playerDataScene);
			playerDataStage.setResizable(false);
			playerDataStage.showAndWait();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openPlayScreen() {
		try {
			BorderPane playWindow = (BorderPane)FXMLLoader.load(getClass().getResource("PlayScreen.fxml"));
			Scene playScene = new Scene(playWindow,500,500);
			playScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			playStage = new Stage();
			playStage.setScene(playScene);
			playStage.setResizable(false);
			playStage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void quitGame(){
		Platform.exit();
	}
	
	
	public void openInstructions() {
		try {
			BorderPane instructionsWindow = (BorderPane)FXMLLoader.load(getClass().getResource("Instructions.fxml"));
			Scene instructionsScene = new Scene(instructionsWindow,400,400);
			instructionsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			instructionStage = new Stage();
			instructionStage.setScene(instructionsScene);
			instructionStage.setResizable(false);
			instructionStage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void closeInstructions() {
		instructionStage.close();
	}
}
