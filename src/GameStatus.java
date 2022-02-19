public class GameStatus {
    private String status;

    public GameStatus() {
        this.status = "";
    }

    public String updateStatus(Player player1, Player player2) {
        int p1Points = player1.getPoints();
        int p2Points = player2.getPoints();

        return status;
    }

    private String getStatusByPoint(int points) {
        switch(points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            case 4:
                return "Advantage";
        }
        return "";
    }
}
