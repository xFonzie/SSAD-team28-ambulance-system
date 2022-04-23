public abstract class Ambulance {
    protected String name;
    protected Request currentRequest;
    protected Position position;
    protected Vehicle type;

    public Ambulance(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean approve(Request request) {
        if (currentRequest != null ||
                position.getDistance(request.position) > 100)
            return false;
        currentRequest = request;
        return true;
    }

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
