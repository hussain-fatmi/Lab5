package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GameListener monitors keystrokes during the soccer game
 *
 */
public class GameListener implements KeyListener {

	/**
	 * The current panel on which the game is displayed
	 */
	private final GamePanel gamePanel;

	/**
	 * Initializes the GameListener
	 * @param panel - the current GamePanel
	 */
	public GameListener(GamePanel panel) {
		gamePanel = panel;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Monitors keys pressed in order to move the GamePlayer controlled by the user
	 * Moves player up, down, left and right depending on which arrow key is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		if (!soccerGame.isPaused() && !soccerGame.isOver()) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					soccerGame.getActivePlayer().moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					soccerGame.getActivePlayer().moveRight();
					break;
				case KeyEvent.VK_UP:
					soccerGame.getActivePlayer().moveUp();
					break;
				case KeyEvent.VK_DOWN:
					soccerGame.getActivePlayer().moveDown();
					break;
				case KeyEvent.VK_SPACE:
					if (soccerGame.getActivePlayer().isPlayerHasBall()) {
						soccerGame.getActivePlayer().shootBall();
					}
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
