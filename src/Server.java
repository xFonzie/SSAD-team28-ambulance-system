import java.util.HashMap;
public class Server {
   public HospitalList hospitals;
   public Ambulance[] ambulances;
   public HashMap<Integer, User> users;
   private GoggleMaps map;
   private Operator operator;
   public void approve(Request request){

   }
   public void manageRequest(Request request){

   }
   public void manageEmergencyRequest(EmergencyRequest emergencyRequest){

   }
   private Ambulance findAmbulance(Request request, Position position){
         for (Ambulance ven : ambulances){
            if (ven.approve(request, position)){

            }
         }
   }
   private boolean askAmbulance(Ambulance transport, Position coordinates, Request request){

   }
   public void finishRequest(Request request){

   }
}
