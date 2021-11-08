package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import org.junit.jupiter.api.Test;

import model.players.Striker;

class moveDownTest {


	@Test
	void test() {
		Striker player = new Striker("Striker", Color.black);
		player.setPlayerPosition(new Point(300, 300));;
		player.moveDown();
		assertEquals(5.0, player.getPlayerPosition().getY() - 300);
	}
	
	@Test
	void test2() {
		Striker player = new Striker("Striker", Color.black);
		player.setPlayerPosition(new Point(300, 300));;
		player.moveDown();
		player.moveDown();
		assertNotEquals(5.0, player.getPlayerPosition().getY() - 300);
	}

	
	
}
