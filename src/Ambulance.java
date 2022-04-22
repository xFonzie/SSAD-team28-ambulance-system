public abstract class Ambulance {
    private String name;
    private Request currentRequest;
    private Position currentRequestPosition;
    private Position position;
    private Vehicle type;

    abstract public boolean approve(Request request);

    public Position getPositionOfCurrentRequest() {
        return currentRequest.position;
    }

    public void finishCurrentRequest() {
        currentRequest = null;
    }

    public Position getPosition() {
        return position;
    }

    public Vehicle getType() {
        return type;
    }
}
