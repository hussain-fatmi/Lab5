package model.players;

import java.awt.Color;
import java.awt.Point;

import model.SoccerBall;

public class GamePlayer implements Comparable<GamePlayer>{
	
	private final Color color;
	public final String playerName;
	public Integer playerStatistics;
	private Point position;
	protected Boolean hasBall;

	public GamePlayer(String name, Color color){
		this.color = color;
		this.playerName = name;
		this.hasBall = false;
		this.playerStatistics = 0;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public Color getPlayerColor() {
		return color;
	}
	
	public Point getPlayerPosition() {
		return position;
	}
	
	public boolean isPlayerHasBall() {
		if(
				SoccerBall.getSoccerBall().getPosition().getX() > this.getPlayerPosition().x - 20 &&
				SoccerBall.getSoccerBall().getPosition().getX() < this.getPlayerPosition().x + 40 &&
				SoccerBall.getSoccerBall().getPosition().getY() > this.getPlayerPosition().y &&
				SoccerBall.getSoccerBall().getPosition().getY() < this.getPlayerPosition().y + 90)
		{
			hasBall = true;
		}
		return hasBall;
	}
	
	public void moveLeft() {}
	
	public void moveRight() {}
	
	public void moveUp() {}
	
	public void moveDown() {}

	public void shootBall() {}
	
	public void setInitialPosition(){}
	
	public void setPlayerPosition(Point point){
		this.position = point;
	}
	
	public Integer getPlayerStatistics() {
		return playerStatistics;
	}
	
	public void setPlayerStatistics(int stat) {
		playerStatistics = stat;
	}

	@Override
	public int compareTo(GamePlayer o) {
		return this.playerName.compareToIgnoreCase(o.playerName);
	}
}
