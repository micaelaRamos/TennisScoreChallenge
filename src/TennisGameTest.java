import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest {
    private TennisGame tennisGame;
    private Player player1;
    private Player player2;

    @Before
    public void initialize() {
        player1 = new Player("A");
        player2 = new Player("B");
        tennisGame = new TennisGame(player1, player2);
    }

    @Test
    public void TestRegisterPointInitialState() {
        assertEquals("Love - All", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayer1FirstScore() {
        tennisGame.registerPoint(player1);

        assertEquals("Fifteen - Love", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayer2FirstScore() {
        tennisGame.registerPoint(player2);

        assertEquals("Love - Fifteen", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayerBWinning() {
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player2);

        assertEquals("Fifteen - Thirty", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayerTieBeforeForty() {
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player2);

        assertEquals("Thirty - All", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayerThirtyForty() {
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player1);

        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);

        assertEquals("Thirty - Forty", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayerPlayer2Wins() {
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player1);

        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);

        assertEquals("Player B wins", tennisGame.getStatus());
        assertEquals(0, player1.getPoints());
        assertEquals(0, player2.getPoints());
    }

    @Test
    public void TestRegisterPointPlayerRollbackAdv() {
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player1);

        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);

        tennisGame.registerPoint(player1);

        assertEquals("Deuce", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointOnly1Scores() {
        tennisGame.registerPoint(player1);
        assertEquals("Fifteen - Love", tennisGame.getStatus());

        tennisGame.registerPoint(player1);
        assertEquals("Thirty - Love", tennisGame.getStatus());

        tennisGame.registerPoint(player1);
        assertEquals("Forty - Love", tennisGame.getStatus());

        tennisGame.registerPoint(player1);
        assertEquals("Player A wins", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPoint() {
        tennisGame.registerPoint(player1);
        assertEquals("Fifteen - Love", tennisGame.getStatus());

        tennisGame.registerPoint(player1);
        assertEquals("Thirty - Love", tennisGame.getStatus());

        tennisGame.registerPoint(player1);
        assertEquals("Forty - Love", tennisGame.getStatus());

        tennisGame.registerPoint(player2);
        assertEquals("Forty - Fifteen", tennisGame.getStatus());

        tennisGame.registerPoint(player2);
        assertEquals("Forty - Thirty", tennisGame.getStatus());

        tennisGame.registerPoint(player1);
        assertEquals("Player A wins", tennisGame.getStatus());
    }
}
