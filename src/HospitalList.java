import java.util.LinkedList;
import java.util.List;

public class HospitalList {
    private final List<Hospital> hospitals = new LinkedList<>();

    public void remove(Hospital hospital) {
        hospitals.remove(hospital);
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void add(Hospital hospital) {
        hospitals.add(hospital);
    }

    public Hospital getByName(String name) {
        for (Hospital hospital : hospitals) {
            if (hospital.getName().equals(name)) {
                return hospital;
            }
        }
        throw new IllegalArgumentException("No hospital with name " + name);
    }
}
