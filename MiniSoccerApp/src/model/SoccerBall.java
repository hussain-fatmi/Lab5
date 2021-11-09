package model;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The SoccerBall class represents a soccerball
 */
public class SoccerBall {

	/**
	 * The soccerball for the game
	 */
	private static final SoccerBall soccerBall = new SoccerBall();

	/**
	 * The location of the ball represented by a Point(x, y)
	 */
	private Point position;

	/**
	 * The velocity that the ball is moving at
	 */
	private double velocity;

	/**
	 * The color of the ball
	 */
	private final Color color;

	/**
	 * Initializes a new ball
	 */
	private SoccerBall() {
		color = Color.white;
		resetSoccerBall();
	}

	/**
	 * A method to get a new ball for the game
	 * @return a new SoccerBall
	 */
	public static SoccerBall getSoccerBall() {
		return soccerBall;
	}

	/**
	 * Moves the ball over a specified distance, with a specified velocity and acceleration
	 * @param initialDistance - the distance to move the ball
	 * @param initialVelocity - the velocity to move the ball with
	 * @param acceleration - the acceleration to apply to the ball movements
	 */
	public void moveBall(int initialDistance, double initialVelocity, double acceleration) {
		moveBallY(initialDistance);
		setVelocity(initialVelocity);
		Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				if (Math.abs(velocity) < 2) {
					velocity = 0.0;
					timer.cancel();
				} else {
					velocity = velocity - acceleration;
				}
				moveBallY((int) velocity);
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}

	/**
	 * Moves the ball by a certain distance in the y direction
	 * @param distance - the distance to move the ball
	 */
	public void moveBallY(int distance) {
		if (getPosition().y + distance < 510 && getPosition().y - distance > 20) {
			setPosition(new Point(getPosition().x, getPosition().y - distance));
		} else {
			setVelocity(0.0);
		}
	}

	/**
	 * Resets the SoccerBall to the initial position (480, 500)
	 */
	public void resetSoccerBall() {
		setVelocity(0.0);
		setPosition(new Point(480, 500));
	}

	/**
	 * Checks if the ball is on the goalkeepers side of the penalty line
	 * @return true if the ball is on the goalkeepers size, false otherwise
	 */
	public boolean onGoalkeeperSide() {
		return getPosition().y < 200;
	}

	/**
	 * Checks if the ball is within the gate (i.e. a goal is scored)
	 * @return true if the ball is in the gate, false otherwise
	 */
	public boolean inGate() {
		return getPosition().x > 180 && getPosition().x < 400 && getPosition().y > 10 && getPosition().y < 60;
	}

	/**
	 * Sets the velocity of the ball
	 * @param velocity - the value to set
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	/**
	 * Gets the position of the ball
	 * @return the position (Point) to the ball
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Sets the position of the ball
	 * @param position - the Point to move the ball to
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Gets the color of the ball
	 * @return the color of the ball
	 */
	public Color getColor() {
		return color;
	}
}
