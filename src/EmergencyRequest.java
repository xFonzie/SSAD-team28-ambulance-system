public class EmergencyRequest extends Request {

    public EmergencyRequest(Position position, int clientID, GoggleMaps Gogglemaps){
        this.position = position;
        this.clientID = clientID;
        this.hospitalName = Gogglemaps.getNearestHospitalName(position);
        this.car = Vehicle.any;
        sendRequest(server);
    }
    @Override
    boolean sendRequest(Server server){
        return server.manageEmergencyRequest(this);
    }
}
