package model.players;

import java.awt.Color;

/**
 * A factory class for GamePlayers
 */
public class PlayerFactory {
	
	/**
	 * Creates a new GamePlayer with the specified name.
	 * Can be a striker or a goalkeeper depending of the name
	 * @param name - the name of the player to creates
	 * @return a new GamePlayer (Striker or Goalkeeper)
	 */
	public GamePlayer getPlayer(String name) {
		if(name.equalsIgnoreCase("striker")) {
			Striker s = new Striker(name, Color.BLUE);
			s.setInitialPosition();
			return s;
		} else {
			Goalkeeper g = new Goalkeeper(name, Color.YELLOW);
			g.setInitialPosition();
			return g;
		}
	}
}
