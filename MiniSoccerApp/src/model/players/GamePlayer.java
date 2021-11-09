package model.players;

import java.awt.Color;
import java.awt.Point;

import model.SoccerBall;

/**
 * The GamePlayer class represents a soccer player in the game.
 * Each player has a color, name, statistics, and position.
 */
public class GamePlayer implements Comparable<GamePlayer>{
	
	/**
	 * The color of the player
	 */
	private final Color color;
	
	/**
	 * The name of the player
	 */
	public final String playerName;
	
	/**
	 * The statistics of the player. (Could either be saves or goals)
	 */
	public PlayerStatistics playerStatistics;
	
	/**
	 * The position of the player represented by a point
	 */
	private Point position;
	
	/**
	 * A boolean representing whether or not the player is in possession of the ball
	 */
	protected Boolean hasBall;

	/**
	 * Creates a player with a specified name and color.
	 * At creation the player does not possess the ball, and does not have any statistics
	 * @param name - the name of the player
	 * @param color - the color of the player
	 */
	public GamePlayer(String name, Color color){
		this.color = color;
		this.playerName = name;
		this.hasBall = false;
		this.playerStatistics = new PlayerStatistics();
	}
	
	/**
	 * Returns the name of the player
	 * @return A String representing the players name
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * Returns the color of the player
	 * @return A Color representing the players color
	 */
	public Color getPlayerColor() {
		return color;
	}
	
	/**
	 * Returns the position of the player
	 * @return A Point representing the players position
	 */
	public Point getPlayerPosition() {
		return position;
	}
	
	/**
	 * Returns a Boolean representation of the players possession.
	 * A GamePLayer is in possession of the ball if the ball is within 55 radius
	 * @return True if the player has the ball, false otherwise
	 */
	public boolean isPlayerHasBall() {
		if(
				SoccerBall.getSoccerBall().getPosition().getX() > this.getPlayerPosition().x - 40 &&
				SoccerBall.getSoccerBall().getPosition().getX() < this.getPlayerPosition().x + 70 &&
				SoccerBall.getSoccerBall().getPosition().getY() > this.getPlayerPosition().y - 20 &&
				SoccerBall.getSoccerBall().getPosition().getY() < this.getPlayerPosition().y + 90)
		{
			hasBall = true;
		}
		return hasBall;
	}
	
	/**
	 * Moves the player in the -x direction
	 */
	public void moveLeft() {}
	
	/**
	 * Moves the player in the +x direction
	 */
	public void moveRight() {}
	
	/**
	 * Moves the player in the -y direction
	 */
	public void moveUp() {}
	
	/**
	 * Moves the player in the +y direction
	 */
	public void moveDown() {}

	/**
	 * Makes the player shoot the ball by moving the ball
	 */
	public void shootBall() {}
	
	/**
	 * Sets the initial position of the player
	 */
	public void setInitialPosition(){}
	
	/**
	 * Sets the position of the player
	 * @param point - the Point to set position to
	 */
	public void setPlayerPosition(Point point){
		this.position = point;
	}
	
	/**
	 * Returns the player's statistics
	 * @return An Integer representation of the player's statistics
	 */
	public Integer getPlayerStatistics() {
		return playerStatistics.getStats();
	}
	
	/**
	 * Sets the player's statistics
	 * @param stat - the value to set playerStatistic to
	 */
	public void setPlayerStatistics(int stat) {
		playerStatistics.setStats(stat);
	}

	/**
	 * Compares two players based on their names
	 * @return A negative integer, zero, or a positive integer as the
     *          specified GamePlayer is greater than, equal to, or less
     *          than this GamePlayer, ignoring case considerations.
	 */
	@Override
	public int compareTo(GamePlayer o) {
		return this.playerName.compareToIgnoreCase(o.playerName);
	}
}
