package model.players;

/**
 * This class is a representation of a player's statistics. The statistics are either saves or goals depending on the type of player.
 */
public class PlayerStatistics {
	
	/**
	 * Integer value of player statistics
	 */
	Integer playerStatistics;
	
	/** 
	 * Creates a new playerStatistic set to 0
	 */
	public PlayerStatistics() {
		this.playerStatistics = 0;
	}
	
	/**
	 * Retrieves the player statistics
	 * @return the player statistic value
	 */
	public Integer getStats() {
		return this.playerStatistics;
	}
	
	/**
	 * Sets the player statistics
	 * @param stat - the value to set playerStatistic to
	 */
	public void setStats(int stat) {
		this.playerStatistics = stat;
	}
	
	/**
	 * COnverts player statistics into an integer
	 * @return a string representation of the player statistic
	 */
	@Override
	public String toString() {
		return ""+playerStatistics;	
	}
}
