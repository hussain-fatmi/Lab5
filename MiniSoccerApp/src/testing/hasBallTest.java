package testing;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;


import org.junit.jupiter.api.Test;

import model.SoccerBall;
import model.players.GamePlayer;

class hasBallTest {

	@Test
	void testfalse1() {
		GamePlayer player = new GamePlayer("player", Color.black);
		player.setPlayerPosition(new Point(500, 400));
		SoccerBall ball = SoccerBall.getSoccerBall();
		ball.resetSoccerBall();
		assertFalse(player.isPlayerHasBall());
		
	}

	@Test
	void testfalse2() {
		GamePlayer player = new GamePlayer("player", Color.black);
		player.setPlayerPosition(new Point(400, 400));
		SoccerBall ball = SoccerBall.getSoccerBall();
		ball.resetSoccerBall();
		assertFalse(player.isPlayerHasBall());
		
	}
	
	@Test
	void testfalse3() {
		GamePlayer player = new GamePlayer("player", Color.black);
		player.setPlayerPosition(new Point(470, 500));
		SoccerBall ball = SoccerBall.getSoccerBall();
		ball.resetSoccerBall();
		assertTrue(player.isPlayerHasBall());
		
	}
	
	
	@Test
	void testfalse4() {
		GamePlayer player = new GamePlayer("player", Color.black);
		player.setPlayerPosition(new Point(470, 10));
		SoccerBall ball = SoccerBall.getSoccerBall();
		ball.resetSoccerBall();
		assertFalse(player.isPlayerHasBall());
		
	}

	
	@Test
	void testfalse5() {
		GamePlayer player = new GamePlayer("player", Color.black);
		player.setPlayerPosition(new Point(470, 490));
		SoccerBall ball = SoccerBall.getSoccerBall();
		ball.resetSoccerBall();
		assertTrue(player.isPlayerHasBall());
		
	}

}
