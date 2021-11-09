package model.players;

import model.SoccerBall;

import java.awt.*;
import java.util.Random;

/**
 * The Goalkeeper class represents a GamePlayer that is a goalkeeper.
 */
public class Goalkeeper extends GamePlayer {

	private int movementStep;

	/**
	 * Creates a Goalkeeper with a specified name and color.
	 * @param name - the name of the goalkeeper
	 * @param color - the color of the goalkeeper
	 */
	public Goalkeeper(String name, Color color) {
		super(name, color);
		movementStep = 10;
	}

	/**
	 * Moves the goalkeeper by {@code int movementStep}} in the -x direction
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 5 - movementStep > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - movementStep, getPlayerPosition().y));
		}
		if(this.isPlayerHasBall()) {
			SoccerBall.getSoccerBall().setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Moves the goalkeeper by {@code int movementStep}} in the +x direction
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 + movementStep < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + movementStep, getPlayerPosition().y));
		}
		if(this.isPlayerHasBall()) {
			SoccerBall.getSoccerBall().setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Moves the goalkeeper by 5 in the -y direction
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
		if(this.isPlayerHasBall()) {
			SoccerBall.getSoccerBall().setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Moves the goalkeeper by 5 in the +y direction
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 300) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
		if(this.isPlayerHasBall()) {
			SoccerBall.getSoccerBall().setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Makes the goalkeeper shoot the ball by moving the SoccerBall
	 * After shooting the ball the player is no longer in possession of the ball
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(-20, -5.0, -0.05);
		this.hasBall = false;
	}
	
	/**
	 * Makes the goalkeeper grab the ball if the ball is in range or out for a goal kick
	 * Sets the ball in possession of the goalkeeper
	 */
	public void grabsBall() {
		if(SoccerBall.getSoccerBall().getPosition().x < 200 || SoccerBall.getSoccerBall().getPosition().x > 400) {
			SoccerBall.getSoccerBall().setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
			this.hasBall = true;
		} else if(this.isPlayerHasBall()) { //SoccerBall.getSoccerBall().getPosition().x == this.getPlayerPosition().x
			if(this.isPlayerHasBall()) {
				SoccerBall.getSoccerBall().setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
			}
		}
	}

	/**
	 * Moves the goalkeeper randomly within the goal frame
	 */
	public void moveRandomly() {
		Random random = new Random();
		double playerCurrentXPosition = (double) getPlayerPosition().x + 15;
		double chanceOfMovingLeft = (playerCurrentXPosition - 300) / 100 - (random.nextGaussian());
		movementStep = (int) Math.abs(30 * chanceOfMovingLeft);
		if (chanceOfMovingLeft > 0) {
			moveLeft();
		} else {
			moveRight();
		}
	}

	/**
	 * Sets the initial position of the goalkeeper to (280, 70)
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(280, 70));
	}

	/**
	 * Returns the statistics of the goalkeeper
	 * @return A string representation of the goalkeepers saves
	 */
	@Override
	public String toString() {
		return playerName + " caught " + playerStatistics.toString() + " balls";
	}
}
