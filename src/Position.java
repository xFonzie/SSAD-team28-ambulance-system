public class Position {
    public double x, y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getDistance(Position other) {
        return Math.sqrt((this.x - other.x) * (this.x - other.x) +
                         (this.y - other.y) * (this.y - other.y));
    }
}
