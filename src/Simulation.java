public class Simulation {
    public static void main(String[] args) {
        HospitalList hospitalList = new HospitalList();
        hospitalList.add(new Hospital(new Position(0, 0), "Hospital 1"));
        hospitalList.add(new Hospital(new Position(1, 1), "Hospital 2"));
        hospitalList.add(new Hospital(new Position(2, 2), "Hospital 3"));
        hospitalList.add(new Hospital(new Position(3, 3), "Hospital 4"));
        GoggleMaps goggleMaps = new GoggleMaps(hospitalList);
        Server server = new Server(hospitalList, goggleMaps);
        User user = new User("Vitaliy",server,goggleMaps, 0);
        server.add_user(0,user);

        server.add_ambulance(new Ambulance("Ambulance 1",new Position(0, 0),Vehicle.SMALL));
        server.add_ambulance(new Ambulance("Ambulance 1",new Position(10, 10),Vehicle.SMALL));
        server.add_ambulance(new Ambulance("Ambulance 2",new Position(1, 1),Vehicle.BIG));

        user.makeRequest();
        user.makeEmergencyRequest();

    }
}
