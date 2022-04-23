public class Operator {
    Server server;
    public boolean SendNotification(int id, boolean value){
        server.users.get(id).notify();
    }
}
