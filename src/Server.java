import java.util.*;
import java.math.*;
public class Server {
   public HospitalList hospitals;
   public Ambulance[] ambulances;
   public HashMap<Integer, User> users;
   private GoggleMaps map;
   private Operator operator;
   public void approve(Request request, Ambulance ven, Hospital target_hospital){
         operator.notify(request.clientID, true);
         target_hospital.bookingHistory.add(request);
   }
   public void manageRequest(Request request){
         Ambulance target_ambulance = findAmbulance(request, request.car);
         for (Hospital cur : HospitalList.hospitals){
            if (cur.name == request.hospitalName){
               approve(request, target_ambulance, cur);
            }
         }
   }
   public void manageEmergencyRequest(EmergencyRequest emergencyRequest){
      Ambulance target_ambulance = findAmbulance(request, Vehicle.any);
      String meem = map.getNearestHospitalName(emergencyRequest.position);
       for (Hospital cur : HospitalList.hospitals) {
           if (cur.name == meem) {
               approve(emergencyRequest, target_ambulance, cur);
           }
       }
   }
   private Ambulance findAmbulance(Request request, Vehicle tp){
         for (Ambulance ven : ambulances){
            if (ven.type == tp || tp == Vehicle.any) {
               if (ven.approve(request)) {
                  return ven;
               }
            }
         }
   }
   public void finishRequest(Request request){

   }
}
