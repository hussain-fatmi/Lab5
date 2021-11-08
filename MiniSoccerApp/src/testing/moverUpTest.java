package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import org.junit.jupiter.api.Test;

import model.players.Striker;

class moverUpTest {

	@Test
	void test() {
		Striker player = new Striker("Striker", Color.black);
		player.setPlayerPosition(new Point(300, 300));;
		player.moveUp();
		assertEquals(-5.0, player.getPlayerPosition().getY() - 300);
	}

}
