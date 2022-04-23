import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

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
    private Position getCoordinates(){
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        System.out.println("x = "); double x = Scanner.nextDouble();
        System.out.println("y = "); double y = Scanner.nextDouble();
        return new Position(x, y);
    }
    public String getHospital(){
        Scanner Scanner = new Scanner(System.in);
        List<String> Hospitals = Gogglemap.getAllHospitalInfo();
        System.out.println("Select the hospital: ");
        for (int i = 0; i < Hospitals.size(); i++){
            System.out.println(Hospitals.get(i) + " - " + Integer.toString(i));
        }
        while (true) {
            int i = Scanner.nextInt();
            if (i < Hospitals.size()) return Hospitals.get(i);
            else System.out.println("Wrong number, try again");
        }

    }
    public Vehicle getCar(){
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Enter the car: ");
        System.out.println("BIG - 1");
        System.out.println("SMALL - 2");

        while (true) {
            int n = Scanner.nextInt();
            if (n == 1) return Vehicle.BIG;
            else if (n == 2) return Vehicle.SMALL;
            else System.out.println("Wrong number, try again");
        }
    }
    public boolean makeRequest(){

        Position position = getCoordinates();
        Vehicle car = getCar();
        String hospitalName = getHospital();

        Request request = new Request(position, car, hospitalName, id);
        return request.sendRequest(server);
    }
    public boolean makeEmergencyRequest(){
        Position position = getCoordinates();
        Request EmergencyRequest = new EmergencyRequest(position, id, Gogglemap);
        return EmergencyRequest.sendRequest(server);
    }
    public void notify(boolean value){
        if (value) System.out.println("Request Approved");
        else System.out.println("Request Canceled");
    }



}
