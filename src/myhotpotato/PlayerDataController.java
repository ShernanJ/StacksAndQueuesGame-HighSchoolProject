package myhotpotato;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PlayerDataController {
	@FXML TextField inputField;
	@FXML TextArea playerList;
	
	static Stage gameStage;
	public boolean contains = false;
	
	Queue<String> playerQueue = new Queue<String>();
	
	//addPlayer method, when addPlayer method is called, gets the text in inputField
	public void addPlayer() {
		String player;
		contains = false;
		if(!"".equals(inputField.getText())) {
			player = inputField.getText();
			if(inputField.getText().contains(player) && playerList.getText().contains(player)) {
				System.out.println("Contains " + player);
				inputField.clear();
				contains = true;
			}
			else if(contains == false) {
					playerQueue.enqueue(player);
					System.out.println("Player Added");
					playerList.setText(playerList.getText() + player + "\n" );
					inputField.clear();
			}
		}
	}
	
	//When enter is pressed in the textField.
	public void enterKey(ActionEvent ae) {
		addPlayer();
	}
	
	
	public void removePlayer() {
		String removed;
		removed = playerQueue.peek();
		playerList.setText(playerList.getText().replace(removed + "\n", ""));
		removed = playerQueue.takeFirst();
	
		if(playerQueue.isEmpty()) {
			playerList.clear();
		}
	}
	
	public void openPlayScreen() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayScreen.fxml"));
			BorderPane gameWindow = (BorderPane)loader.load();
			Scene gameScene = new Scene(gameWindow,500,500);
			gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			GameController gamePage = loader.getController();
			gamePage.getQueue(playerQueue);
			
//			MainHotPotatoController.playerDataStage.close();
			playerList.clear();
			gameStage = new Stage();
			gameStage.setScene(gameScene);
			gameStage.setResizable(false);
			gameStage.showAndWait();
			
		if(gamePage.clear) {
			playerQueue.clear();
		}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void quitGame(){
		MainHotPotatoController.playerDataStage.close();
		Platform.exit();
	}
	
	
}
