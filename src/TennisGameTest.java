import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest {
    @Test
    public void TestRegisterPointPlayer1FirstScore() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.registerPoint(player1);

        assertEquals("Fifteen - Love", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayer2FirstScore() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.registerPoint(player2);

        assertEquals("Love - Fifteen", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayerBWinning() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player2);

        assertEquals("Fifteen - Thirty", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayerTieBeforeForty() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player2);

        assertEquals("Thirty - All", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayerThirtyForty() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player1);

        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);

        assertEquals("Thirty - Forty", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayerPlayer2Wins() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player1);
        tennisGame.registerPoint(player1);

        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);
        tennisGame.registerPoint(player2);

        assertEquals("Player B wins", tennisGame.getStatus());
    }

    @Test
    public void TestRegisterPointPlayerRollbackAdv() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        TennisGame tennisGame = new TennisGame(player1, player2);

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
    public void TestRegisterPointLoveAll() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        TennisGame tennisGame = new TennisGame(player1, player2);

        assertEquals("Love - All", tennisGame.getStatus());
    }
}
