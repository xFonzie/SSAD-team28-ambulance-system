public class Request {

    public Vehicle car;
    public Position position;
    public String hospitalName;
    public int clientID;

    public Request(){}
    public Request(Position position, Vehicle car, String hospitalName, int clientID){
        this.car = car;
        this.position = position;
        this.hospitalName = hospitalName;
        this.clientID = clientID;
    }
    void sendRequest(Server server){
        server.manageRequest(this);
    }
}
