package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import org.junit.jupiter.api.Test;

import model.players.Striker;

class moverRightTest {

	@Test
	void test() {
		Striker player = new Striker("Striker", Color.black);
		player.setPlayerPosition(new Point(300, 300));;
		player.moveRight();
		assertEquals(5.0, player.getPlayerPosition().getX() - 300);
	}
	
	@Test
	void test2() {
		Striker player = new Striker("Striker", Color.black);
		player.setPlayerPosition(new Point(300, 300));;
		player.moveRight();
		player.moveRight();
		assertNotEquals(5.0, player.getPlayerPosition().getX() - 300);
	}


}
