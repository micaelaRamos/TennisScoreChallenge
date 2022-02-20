public class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public void score() {
        this.points ++;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}
