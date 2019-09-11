package myhotpotato;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController {
	@FXML
	TextArea currentPlayersList;
	@FXML
	TextField potatoHolder;
	@FXML
	Button startButton;
	@FXML
	TextArea playersOut;
	@FXML
	Button playAgainButton;
	@FXML
	Button quitButton;
	@FXML
	Text winnerText;
	
	static Stage endStage;
	
	public String currentPlayer;
	public String listener;
	public int index;
	public boolean gameActive = true;
	public boolean gameRunning = true;
	public boolean clear = false;
	public boolean gameWon = false;
	public boolean potatoSwapActive = false;
	public String winner;

	Queue<String> playerQueue = new Queue<String>();
	Stack<String> playersOutStack = new Stack<String>();

	public void startGame() throws InterruptedException {
		gameActive = true;
		int randInt = (int)(Math.random() * (10 - 2)) + 2;
		System.out.println(randInt);
		
		if(!playerQueue.isOnePlayer()) {
			gameActive = false;
			potatoSwapActive = true;
			System.out.println("Start Game");
			
			//Play Music
		
			potatoHolder.setText(playerQueue.peek());
			playerQueue.takeFirst();
			setPlayers();
			startButton.setDisable(true);
			quitButton.setDisable(true);
			playAgainButton.setDisable(true);
			//Create a new Thread
			new Thread (new Runnable() {
				
				public void run() {
					try {
						for(int i=0; i<=randInt; i++) {
							Thread.sleep(1000);
							potatoSwapper();
							if(i == randInt) {
								playerOut();
								System.out.println("Finished");
							}
						}
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}).start();
		}
		
	}

	public void potatoSwapper() {
		if(potatoSwapActive) {
			playerQueue.enqueue(potatoHolder.getText());
			potatoHolder.setText(playerQueue.getValue(0));
			playerQueue.dequeue();
			
			setPlayers();
		}
	}

	
	public void playerOut() throws InterruptedException {
		playersOutStack.push(potatoHolder.getText());
		playersOut.setText(potatoHolder.getText() + "\n" + playersOut.getText());
		potatoHolder.setText("");
		startButton.setDisable(false);
		playAgainButton.setDisable(false);
		quitButton.setDisable(false);
		
		if(playerQueue.isOnePlayer() == true && potatoHolder.getText() !="") {
			winner = playerQueue.getValue(0);
			System.out.println("Game over");
			winnerText.setText("The winner is " + winner);
			startButton.setDisable(false);
			playAgainButton.setDisable(false);
			quitButton.setDisable(false);
		}
	}

	public void getQueue(Queue<String> queue) {
		playerQueue = queue;
		setPlayers();
	}

	public void quitGame() {
		PlayerDataController.gameStage.close();
		MainHotPotatoController.playerDataStage.close();
		playerQueue.clear();
		playersOutStack.clear();
	}

	public void playAgain() {
		System.out.println("Play again");
		PlayerDataController.gameStage.close();
		playerQueue.clear();
		playersOutStack.clear();
		gameActive = false;
		clear = false;
	}

	public void setPlayers() {
		currentPlayersList.setText("");
		int index = playerQueue.getSize();
		for (int i = 0; i < index; i++) {
			String player = playerQueue.getValue(i);
			currentPlayersList.setText(currentPlayersList.getText() + player + "\n");
		}
	}
}
