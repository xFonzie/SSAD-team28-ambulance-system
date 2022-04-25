import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Simulation {
    private static final HospitalList hospitalList = new HospitalList();
    private static final ArrayList<User> users = new ArrayList<>();
    private static final GoggleMaps maps = new GoggleMaps(hospitalList);
    private static final Server server = new Server(hospitalList, maps);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
            System.out.println("""
                    Available operations:
                    0 - Register new User
                    1 - Register new Hospital
                    2 - Register new Ambulance
                    3 - Login as an User
                    4 - Exit the program
                    Choose the operation:\040""");
            switch (scanner.nextInt()) {
                case 0:
                    registerUser();
                    break;
                case 1:
                    addHospital();
                    break;
                case 2:
                    addAmbulance();
                    break;
                case 3:
                    findUser();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("""
                            Unsupported operation. Try again.
                                                        
                            """);
                    break;
            }
            } catch (InputMismatchException ignored) {
                System.out.println("""
                            Unsupported operation. Try again.
                                                        
                            """);
            }
        }
    }

    private static void registerUser() {
        System.out.println("Please, specify the name of the user: ");
        String name = new Scanner(System.in).nextLine();
        int id = new Random().nextInt();
        User newUser = new User(name, server, maps, id);
        users.add(newUser);
        server.add_user(id, newUser);
        System.out.printf("""
                The registration was successful.
                Added new user %s with id %d%n""", name, id);
    }

    private static void addAmbulance() {
        System.out.print("""
                Please, specify ambulance name:
                """);
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.print("Please, specify the coordinates of the hospital:\nx= ");
        double x, y;
        x = sc.nextDouble();
        System.out.print("y= ");
        y = sc.nextDouble();
        System.out.println("Available ambulance types:");
        for (Vehicle i : Vehicle.values()) {
            if (i != Vehicle.any)
                System.out.println(i.name());
        }
        sc = new Scanner(System.in);
        Vehicle type;
        while (true) {
            try {
                String typeStr = sc.nextLine();
                type = Vehicle.valueOf(typeStr);
                if (type == Vehicle.any)
                    continue;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("""
                        Wrong type name. Try again.
                        """);
            }
        }

        Ambulance newAmbulance = new Ambulance(name, new Position(x, y), type);
        server.add_ambulance(newAmbulance);
    }

    private static void addHospital() {
        System.out.print("Please, specify the coordinates of the hospital:\nx= ");
        Scanner sc = new Scanner(System.in);
        double x, y;
        x = sc.nextDouble();
        System.out.print("y= ");
        y = sc.nextDouble();
        System.out.print("Please, specify the name of the hospital:\n");
        sc.nextLine();
        String name = sc.nextLine();
        Hospital newHospital = new Hospital(new Position(x, y), name);
        hospitalList.add(newHospital);
        System.out.printf("""
                The registration was successful.
                Added new hospital at %s with name %s.%n%n""", newHospital.getPosition().toString(), newHospital.getName());
    }

    private static void loginInUser(User user) {
        while (true) {
            System.out.print("""
                   Available actions:
                   0 - Make new request
                   1 - Logout
                   Select the action:\040""");
            switch (new Scanner(System.in).nextInt()) {
                case 0:
                    user.makeRequest();
                    break;
                case 1:
                    return;
            }
        }
    }

    private static void findUser() {
        System.out.println("""
                Enter the user id:\040""");
        int x = new Scanner(System.in).nextInt();
        for (User user : users) {
            if (user.getId() == x) {
                loginInUser(user);
                return;
            }
        }
        System.out.println("""
                Error: There is no such id in the system.
                """);
    }
}
