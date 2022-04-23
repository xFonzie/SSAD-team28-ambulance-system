public class User {
    private String name;
    private Server server;
    private GoggleMaps Gogglemap;
    private int id;

    public User (String name, Server server, GoggleMaps Gogglemap, int id){
        this.Gogglemap = Gogglemap;
        this.id = id;
        this.server = server;
        this.name = name;
    }
    public boolean makeRequest(){

        double x = 1, y = 1;
        Vehicle car = Vehicle.any;
        String hospitalName = "";

        Request request = new Request(new Position(x, y), car, hospitalName, id);
        request.sendRequest(server);
    }
    public void makeEmergencyRequest(){
        double x = 1, y = 1;
        Request EmergencyRequest = new EmergencyRequest(new Position(x, y), id, Gogglemap);
        EmergencyRequest.sendRequest(server);
    }
    public void notify(boolean value){
        if (value) System.out.println("Request Approved");
        else System.out.println("Request Canceled");
    }



}
