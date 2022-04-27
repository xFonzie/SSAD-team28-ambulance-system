public class Ambulance {
    protected String name;
    protected Request currentRequest;
    protected Position position;
    protected Vehicle type;

    public Ambulance(String name, Position position, Vehicle type) {
        this.name = name;
        this.position = position;
        this.type = type;
    }

    public boolean approve(Request request) {
        return currentRequest == null &&
                !(position.getDistanceTo(request.position) > 100);
    }
    public void updateRequest(Request request) {
        currentRequest = request;
    }

    public Position getPositionOfCurrentRequest() {
        return currentRequest.position;
    }

    public void finishCurrentRequest() {
        position = currentRequest.position;
        currentRequest = null;
    }

    public Position getPosition() {
        return position;
    }

    public Vehicle getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
