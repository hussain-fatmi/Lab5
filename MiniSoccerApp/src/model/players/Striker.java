package model.players;

import model.SoccerBall;

import java.awt.*;

/**
 * The Striker class represents a GamePlayer that is a striker.
 */
public class Striker extends GamePlayer {
	
	/**
	 * Creates a Striker with a specified name and color.
	 * @param name
	 * @param color
	 */
	public Striker(String name, Color color) {
		super(name, color);
	}

	/**
	 * Moves the Striker left by 5, if Striker has the ball, moves the ball as well
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 10 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - 5, getPlayerPosition().y));
		}
		if(this.isPlayerHasBall()) {
			SoccerBall.getSoccerBall().setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Moves the Striker right by 5, if Striker has the ball, moves the ball as well
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + 5, getPlayerPosition().y));
		}
		if(this.isPlayerHasBall()) {
			SoccerBall.getSoccerBall().setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Moves the Striker up by 5, if Striker has the ball, moves the ball as well
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 200) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
		if(this.isPlayerHasBall()) {
			SoccerBall.getSoccerBall().setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Moves the Striker down by 5, if Striker has the ball, moves the ball as well
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 500) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
		if(this.isPlayerHasBall()) {
			SoccerBall.getSoccerBall().setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Makes the striker shoot the ball towards the goalkeepers side of the pitch.
	 * After the shot, the Striker no longer has the ball
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(60, 5.0, 0.05);
		this.hasBall = false;
	}

	/**
	 * Sets the initial position of the player
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(500, 450));
	}

	/**
	 * Returns the statistics of the striker
	 * @return A string representation of the strikers goals
	 */
	@Override
	public String toString() {
		return playerName + " scored " + playerStatistics.toString() + " goals";
	}
}
