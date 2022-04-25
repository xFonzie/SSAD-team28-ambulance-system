import java.util.*;
import java.math.*;
public class Server {
   public HospitalList hospitals;
   public  List<Ambulance> ambulances = new LinkedList<Ambulance>();
   public HashMap<Integer, User> users;
   public GoggleMaps map;
   public Operator operator;

    Server(HospitalList a, GoggleMaps b){
        hospitals = a;
        ambulances = new LinkedList<Ambulance>();
        users = new HashMap<Integer, User>();
        map = b;
        operator = new Operator(this);
    }
    public void add_ambulance(Ambulance kek){
        ambulances.add(kek);
    }
    public void add_user(int id, User user){
        users.put(id, user);
    }

   public void approve(Request request, Ambulance ven, Hospital target_hospital){
         ven.updateRequest(request);
         operator.SendNotification(request.clientID, true);
         target_hospital.addSuccessfulRequest(request);
   }
   public void manageRequest(Request request){
         Ambulance target_ambulance = findAmbulance(request, request.car);
         if (target_ambulance == null){
             operator.SendNotification(request.clientID, false);
             return;
         }
         var hospital = hospitals.getByName(request.hospitalName);
         approve(request, target_ambulance, hospital);
            System.out.println("The ambulance " + target_ambulance.name + " is going to "+request.position + " and then to " + request.hospitalName);
   }
   public void manageEmergencyRequest(EmergencyRequest emergencyRequest){
      Ambulance target_ambulance = findAmbulance(emergencyRequest, Vehicle.any);
       if (target_ambulance == null){
           operator.SendNotification(emergencyRequest.clientID, false);
           return;
       }
      String meem = map.getNearestHospitalName(emergencyRequest.position);
       var hospital = hospitals.getByName(meem);
       approve(emergencyRequest, target_ambulance, hospital);
       System.out.println("EMERGENCY: The ambulance " + target_ambulance.name + " is going to " +emergencyRequest.position + " and then to " + emergencyRequest.hospitalName);

   }
   private Ambulance findAmbulance(Request request, Vehicle tp){
        Ambulance ret = null;
        double cur_dist = Double.MAX_VALUE;
         for (Ambulance ven : ambulances){
            if (ven.type == tp || tp == Vehicle.any) {
               if (ven.approve(request)) {
                  double val = ven.position.getDistanceTo(request.position);
                  if (val < cur_dist){ ret = ven;}
               }
            }
         }
         return ret;
   }
}
