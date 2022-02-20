public class TennisGame {
    private Player player1;
    private Player player2;
    private GameStatus status;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.status = new GameStatus();
    }

    public String registerPoint(Player player) {
        player.score();
        return status.updateStatus(player1, player2);
    }

    public String getStatus() {
        return status.getStatus();
    }
}
