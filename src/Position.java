public class Position {
    public double x, y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistanceTo(Position other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
