package model;

import java.util.Timer;
import java.util.TimerTask;

import model.players.*;

/**
 * SoccerGame represents the soccer game
 */
public class SoccerGame {

	/**
	 * The time remaining in the current game
	 */
	private Integer timeRemaining;

	/**
	 * The number of goals scored
	 */
	private Integer goal;

	/**
	 * A boolean representing whether the game is paused or not
	 */
	private Boolean isPaused;

	/**
	 * A boolean representing whether the game is over or not
	 */
	private Boolean isOver;

	/**
	 * A Collection of GamePlayers in the current game
	 */
	private final PlayerCollection gamePlayers;

	/**
	 * Instantiates a new SoccerGame
	 */
	public SoccerGame() {
		timeRemaining = 60;
		goal = 0;
		isPaused = false;
		isOver = false;
		SoccerBall.getSoccerBall().resetSoccerBall();
		PlayerFactory playerFactory = new PlayerFactory();
		gamePlayers = new PlayerCollection();
		gamePlayers.add(playerFactory.getPlayer("striker"));
		gamePlayers.add(playerFactory.getPlayer("goalkeeper"));
		startGame();
	}

	/**
	 * Launches the new game
	 */
	private void startGame() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (!isPaused()) {
					if (getTimeRemaining() <= 0) {
						setOver(true);
						timer.cancel();
					} else {
						setTimeRemaining(getTimeRemaining() - 1);
					}
					if (isScored()) {
						setPaused(true);
						setGoal(getGoal() + 1);
						getActivePlayer().setPlayerStatistics(getActivePlayer().getPlayerStatistics() + 1);
						getGamePlayers().get("Striker").setInitialPosition();
						SoccerBall.getSoccerBall().resetSoccerBall();
					} else {
						automateGoalkeeper();
					}
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}

	/**
	 * Gets the time remaining in the game
	 * @return the remaining time
	 */
	public Integer getTimeRemaining() {
		return timeRemaining;
	}

	/**
	 * Sets the time remaining in the game
	 * @param timeRemaining - the value to set the time to
	 */
	public void setTimeRemaining(Integer timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	/**
	 * Gets the number of goals scored
	 * @return the number of goals scored
	 */
	public Integer getGoal() {
		return goal;
	}

	/**
	 * Sets the amount of goals scored
	 * @param newGoal - the value to set the goal to
	 */
	public void setGoal(Integer newGoal) {
		goal = newGoal;
	}

	/**
	 * Checks if the game is paused
	 * @return true if the game is paused, false otherwise
	 */
	public Boolean isPaused() {
		return isPaused;
	}

	/**
	 * Changes the value of isPaused
	 * @param paused - the value to set isPaused to
	 */
	public void setPaused(Boolean paused) {
		isPaused = paused;
	}

	/**
	 * Checks if the game is over
	 * @return true if the game is over, false otherwise
	 */
	public Boolean isOver() {
		return isOver;
	}

	/**
	 * Changes the value of isOver
	 * @param over - the value to set isOver to
	 */
	public void setOver(Boolean over) {
		isOver = over;
	}

	/**
	 * Gets the Collection of GamePlayers in the game
	 * @return the collection of players
	 */
	public PlayerCollection getGamePlayers() {
		return gamePlayers;
	}

	/**
	 * Automates the goalkeeper's behavior
	 * If the ball is on the keeper's side, Goalkeeper will attempt to grab and shoot the ball
	 * Otherwise the keeper will move randomly
	 */
	public void automateGoalkeeper() {
		SoccerBall soccerBall = SoccerBall.getSoccerBall();
		Goalkeeper goalkeeper = (Goalkeeper) gamePlayers.get("Goalkeeper");
		if (soccerBall.onGoalkeeperSide()) {
			goalkeeper.grabsBall();
			goalkeeper.shootBall();
			goalkeeper.setPlayerStatistics(goalkeeper.getPlayerStatistics() + 1);
		} else {
			goalkeeper.moveRandomly();
		}
	}

	/**
	 * Checks if a goal has been scored
	 * @return true if the ball is in the gate, false otherwise
	 */
	public boolean isScored() {
		return SoccerBall.getSoccerBall().inGate();
	}

	/**
	 * Gets the player controlled by the user
	 * @return the user controlled player
	 */
	public GamePlayer getActivePlayer() {
		return gamePlayers.get("Striker");
	}
}
