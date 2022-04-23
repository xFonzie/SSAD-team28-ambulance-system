import java.util.*;
import java.math.*;
public class Server {
   public HospitalList hospitals;
   public Ambulance[] ambulances;
   public HashMap<Integer, User> users;
   private GoggleMaps map;
   private Operator operator;
   public void approve(Request request, Ambulance ven, Hospital target_hospital){
         operator.SendNotification(request.clientID, true);
         target_hospital.addSuccessfulRequest(request);
   }
   public void manageRequest(Request request){
         Ambulance target_ambulance = findAmbulance(request, request.car);
         if (target_ambulance == null){
             operator.SendNotification(request.clientID, false);
         }
         List<Hospital> tmp = hospitals.getHospitals();
         for (Hospital cur : tmp){
            if (cur.getName() == request.hospitalName){
               approve(request, target_ambulance, cur);
            }
         }
       operator.SendNotification(request.clientID, false);
   }
   public void manageEmergencyRequest(EmergencyRequest emergencyRequest){
      Ambulance target_ambulance = findAmbulance(emergencyRequest, Vehicle.any);
       if (target_ambulance == null){
           operator.SendNotification(emergencyRequest.clientID, false);
       }
      String meem = map.getNearestHospitalName(emergencyRequest.position);
       List<Hospital> tmp = hospitals.getHospitals();
       for (Hospital cur : tmp) {
           if (cur.getName() == meem) {
               approve(emergencyRequest, target_ambulance, cur);
           }
       }
       operator.SendNotification(emergencyRequest.clientID, false);
   }
   private Ambulance findAmbulance(Request request, Vehicle tp){
         for (Ambulance ven : ambulances){
            if (ven.type == tp || tp == Vehicle.any) {
               if (ven.approve(request)) {
                  return ven;
               }
            }
         }
         return null;
   }
}
