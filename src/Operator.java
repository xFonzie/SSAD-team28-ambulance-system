public class Operator {
    Server server;
    public void SendNotification(int id, boolean value){
        server.users.get(id).notify(value);
    }
}
