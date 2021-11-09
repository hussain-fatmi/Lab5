package view;

import model.SoccerBall;
import model.SoccerGame;
import model.players.GamePlayer;
import model.players.PlayerCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * GamePanel is the panel to display the game
 */
public class GamePanel extends JPanel {

	/**
	 * The font of text displayed
	 */
	private final Font uiFont;

	/**
	 * The SoccerGame to display
	 */
	private SoccerGame game;

	/**
	 * Instantiates a new Panel
	 */
	public GamePanel() {
		super(null);
		super.setBackground(new Color(112, 176, 49));
		uiFont = new Font("UI", Font.BOLD, 15);
		setupSoccerGame();
		setupRepaint();
	}

	/**
	 * Creates a new SoccerGame
	 */
	public void setupSoccerGame() {
		game = new SoccerGame();
	}

	/**
	 * Repaints the panel
	 */
	private void setupRepaint() {
		java.util.Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}

	/**
	 * Gets the game being displayed
	 * @return the game being displayed
	 */
	public SoccerGame getGame() {
		return game;
	}

	/**
	 * Paints component in the panel
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintPausedText(g);
		paintGate(g);
		paintPenaltyLine(g);
		paintGoal(g);
		paintTimer(g);
		paintPlayers(g);
		paintBall(g);
		paintStatistics(g);
	}

	/**
	 * Paints pause text on the panel
	 * @param g - the panel to draw on
	 */
	private void paintPausedText(Graphics g) {
		if (getGame().isPaused()) {
			g.setColor(Color.red);
			g.setFont(uiFont);
			g.drawString("Paused", 270, 300);
		}
	}

	/**
	 * Paints the goal gate on the panel
	 * @param g - the panel to draw on
	 */
	private void paintGate(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(200, 10, 200, 50);
		g.setColor(Color.black);
		g.setFont(uiFont);
		g.drawString("Gate", 280, 40);
	}

	private void paintPenaltyLine(Graphics g) {
		g.setColor(Color.darkGray);
		g.drawLine(0, 200, 600, 200);
	}

	private void paintTimer(Graphics g) {
		g.setColor(Color.black);
		g.setFont(uiFont);
		g.drawString("Time: " + getGame().getTimeRemaining(), 20, 25);
	}

	private void paintGoal(Graphics g) {
		g.setColor(Color.black);
		g.setFont(uiFont);
		g.drawString("Goal: " + game.getGoal(), 20, 50);
	}

	private void paintPlayers(Graphics g) {
		PlayerCollection gamePlayers = game.getGamePlayers();
		for (GamePlayer player : gamePlayers) {
			g.setColor(player.getPlayerColor());
			g.drawOval(player.getPlayerPosition().x, player.getPlayerPosition().y, 30, 30);
			g.fillPolygon(new int[]{
					player.getPlayerPosition().x, player.getPlayerPosition().x + 15, player.getPlayerPosition().x + 30
			}, new int[]{
					player.getPlayerPosition().y + 30, player.getPlayerPosition().y + 70, player.getPlayerPosition().y + 30
			}, 3);
			g.setColor(Color.black);
			g.setFont(uiFont);
			g.drawString(player.getPlayerName(), player.getPlayerPosition().x - (int) (1.8 * player.getPlayerName().length()), player.getPlayerPosition().y + 85);
		}
	}

	private void paintBall(Graphics g) {
		SoccerBall soccerBall = SoccerBall.getSoccerBall();
		g.setColor(soccerBall.getColor());
		g.fillOval(soccerBall.getPosition().x, soccerBall.getPosition().y, 20, 20);
	}

	private void paintStatistics(Graphics g) {
		if (getGame().isOver()) {
			g.setColor(Color.red);
			g.setFont(uiFont);
			g.drawString("Game Over!", 250, 250);
			PlayerCollection gamePlayers = game.getGamePlayers();
			gamePlayers.sort();
			int y = 300;
			for (GamePlayer player : gamePlayers) {
				g.drawString(player.toString(), 200, y);
				y = y + 30;
			}
		}
	}
}
