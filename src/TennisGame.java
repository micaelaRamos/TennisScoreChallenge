public class TennisGame {
    private static final String ADVANTAGE_PLAYER = "Advantage Player ";
    private static final String PLAYER_STRING_ID = "Player ";
    private static final String TIE_WORDING = "Deuce";
    private Player player1;
    private Player player2;
    private String status;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.status = "Love - All";
    }

    public String registerPoint(Player player) {
        player.score();

        int p1Points = player1.getPoints();
        int p2Points = player2.getPoints();

        if (p1Points < 3 && p2Points < 3) {
            status = getStatusByPoint(p1Points) + " - " + getStatusByPoint(p2Points);

            if (p1Points == p2Points) {
                status = getStatusByPoint(p1Points) + " - All";
            }

            return status;
        }

        if (p1Points == p2Points) {
            return status = TIE_WORDING;
        }

        return status = calculateStatusWithScoreOver3();
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
        }
        return "";
    }

    public String calculateStatusWithScoreOver3() {
        int pointsDifference = player1.getPoints() - player2.getPoints();

        switch (pointsDifference) {
            case 1:
                if (player2.getPoints() < 3) {
                    return getStatusByPoint(player1.getPoints()) + " - " + getStatusByPoint(player2.getPoints());
                }
                return ADVANTAGE_PLAYER + player1.getName();
            case -1:
                if (player1.getPoints() < 3) {
                    return status = getStatusByPoint(player1.getPoints()) + " - " + getStatusByPoint(player2.getPoints());
                }
                return ADVANTAGE_PLAYER + player2.getName();
            case 2:
                return PLAYER_STRING_ID + player1.getName() + " wins";
        }

        return PLAYER_STRING_ID + player2.getName() + " wins";
    }

    public String getStatus() {
        return status;
    }
}
