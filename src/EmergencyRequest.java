public class EmergencyRequest extends Request {

    public EmergencyRequest(Position position, int clientID, GoggleMaps Gogglemaps){
        this.position = position;
        this.clientID = clientID;
        this.hospitalName = Gogglemaps.getNearestHospitalName(position);
        this.car = Vehicle.any;
    }
    @Override
    void sendRequest(Server server){
         server.manageEmergencyRequest(this);
    }
}
