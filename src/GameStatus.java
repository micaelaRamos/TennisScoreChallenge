public class GameStatus {
    private String status;

    public GameStatus() {
        this.status = "Love - All";
    }

    public String updateStatus(Player player1, Player player2) {
        int p1Points = player1.getPoints();
        int p2Points = player2.getPoints();

        if (p1Points < 3 && p2Points < 3) {
            // If we enter here, at least one of them has scored less than 3
            status = getStatusByPoint(p1Points) + " - " + getStatusByPoint(p2Points);

            if (p1Points == p2Points) {
                status = getStatusByPoint(p1Points) + " - All";
            }

            return status;
        }

        if (p1Points == p2Points) {
            return status = "Deuce";
        }

        int pointsDifference = p1Points - p2Points;

        if (pointsDifference == 1) {
            if (p2Points < 3) {
                return status = getStatusByPoint(p1Points) + " - " + getStatusByPoint(p2Points);
            }
            return status = "Advantage Player " + player1.getName();
        }

        if (pointsDifference == -1) {
            if (p1Points < 3) {
                return status = getStatusByPoint(p1Points) + " - " + getStatusByPoint(p2Points);
            }
            return status = "Advantage Player " + player2.getName();
        }

        if (pointsDifference == 2) {
            return status = "Player " + player1.getName() + " wins";
        }

        if (pointsDifference == -2) {
            return status = "Player " + player2.getName() + " wins";
        }

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

    public String getStatus() {
        return status;
    }
}
