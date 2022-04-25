public class Operator {
    public Server server;
    Operator(Server sr){
        this.server = sr;
    }
    public void SendNotification(int id, boolean value){
        server.users.get(id).notify();
    }
}
