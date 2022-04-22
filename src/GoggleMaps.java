import java.util.LinkedList;
import java.util.List;

public class GoggleMaps {
    private HospitalList hospitals;

    public GoggleMaps(HospitalList hospitals) {
        this.hospitals = hospitals;
    }

    public List<String> getAllHospitalInfo() {
        List<String> info = new LinkedList<>();
        for (Hospital h : hospitals.getHospitals()) {
            info.add(h.getName() + ": " + h.getPosition());
        }
        return info;
    }

    public String getNearestHospitalName(Position position) {
        if (hospitals.getHospitals().isEmpty()) {
            throw new IllegalArgumentException("No hospitals in the list, cannot find the nearest one");
        }
        double minDistance = Double.MAX_VALUE;
        String nearestHospital = "";
        for (Hospital hospitalToConsider : hospitals.getHospitals()) {
            double distance = position.getDistanceTo(hospitalToConsider.getPosition());
            if (distance < minDistance) {
                minDistance = distance;
                nearestHospital = hospitalToConsider.getName();
            }
        }
        return nearestHospital;
    }

}
