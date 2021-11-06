package model.players;

import java.awt.Color;

public class PlayerFactory {
	
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
