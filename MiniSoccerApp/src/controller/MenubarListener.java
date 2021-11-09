package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MenubarListener monitors the menu bar to control the game
 */
public class MenubarListener implements ActionListener {

	/**
	 * The current panel on which the game is displayed
	 */
	private final GamePanel gamePanel;

	/**
	 * Initializes the MenubarListener
	 * @param panel - the current GamePanel
	 */
	public MenubarListener(GamePanel panel) {
		gamePanel = panel;
	}

	/**
	 * This class controls the game and panel
	 * Gives the user the option to play a new game and exit the current game
	 * The user can pause the game while it is running
	 * The user can resume the game while it is paused
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		switch (e.getActionCommand()) {
			case "NEW":
				gamePanel.setupSoccerGame();
				break;
			case "EXIT":
				System.exit(0);
				break;
			case "PAUSE":
				if (!soccerGame.isPaused() && !soccerGame.isOver()) {
					soccerGame.setPaused(true);
				} else if (soccerGame.isPaused()) {
					System.out.println("game is already on pause!");
				} else if (soccerGame.isOver()) {
					System.out.println("game is over, please start a new game.");
				}
				break;
			case "RESUME":
				if (soccerGame.isPaused() && !soccerGame.isOver()) {
					soccerGame.setPaused(false);
				} else if (!soccerGame.isPaused()) {
					System.out.println("game is already running!");
				} else if (soccerGame.isOver()) {
					System.out.println("game is over, please start a new game.");
				}
				break;
			default:
				throw new RuntimeException("Invalid action command " + e.getActionCommand());
		}
	}
}
