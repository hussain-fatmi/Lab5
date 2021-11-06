package model.players;

import model.SoccerBall;

import java.awt.*;
import java.util.Random;

public class Goalkeeper extends GamePlayer {

	private int movementStep;

	public Goalkeeper(String name, Color color) {
		super(name, color);
		movementStep = 10;
	}

	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 5 - movementStep > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - movementStep, getPlayerPosition().y));
		}
	}

	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 + movementStep < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + movementStep, getPlayerPosition().y));
		}
	}

	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 300) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(-20, -5.0, -0.05);
		this.hasBall = false;
	}
	
	public void grabsBall() {
		if(SoccerBall.getSoccerBall().getPosition().x < 200 || SoccerBall.getSoccerBall().getPosition().x > 400) {
			SoccerBall.getSoccerBall().setPosition(this.getPlayerPosition());
			this.hasBall = true;
		} else if(SoccerBall.getSoccerBall().getPosition().x == this.getPlayerPosition().x) {
			SoccerBall.getSoccerBall().setPosition(this.getPlayerPosition());
			this.hasBall = true;
		}
	}

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

	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(280, 70));
	}

	@Override
	public String toString() {
		return playerName + " caught " + playerStatistics.toString() + " balls";
	}
}
