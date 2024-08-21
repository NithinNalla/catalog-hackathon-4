import java.util.ArrayList;
import java.util.Scanner;

class Child {
    private String name;
    private String dateOfBirth;
    private ArrayList<String> vaccinations;
    private ArrayList<String> appointments;

    public Child(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.vaccinations = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<String> getVaccinations() {
        return vaccinations;
    }

    public ArrayList<String> getAppointments() {
        return appointments;
    }

    public void addVaccination(String vaccination) {
        vaccinations.add(vaccination);
    }

    public void scheduleAppointment(String date) {
        appointments.add(date);
    }

    public void viewRecord() {
        System.out.println("Child Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Vaccinations: " + String.join(", ", vaccinations));
        System.out.println("Appointments: " + String.join(", ", appointments));
    }
}

class VaccinationSystem {
    private ArrayList<Child> children;

    public VaccinationSystem() {
        this.children = new ArrayList<>();
    }

    public void addChild(String name, String dateOfBirth) {
        children.add(new Child(name, dateOfBirth));
    }

    public Child findChildByName(String name) {
        for (Child child : children) {
            if (child.getName().equalsIgnoreCase(name)) {
                return child;
            }
        }
        return null;
    }

    public void scheduleVaccination(String childName, String date) {
        Child child = findChildByName(childName);
        if (child != null) {
            child.scheduleAppointment(date);
            System.out.println("Appointment scheduled on " + date + " for " + childName);
        } else {
            System.out.println("Child not found.");
        }
    }

    public void updateVaccinationRecord(String childName, String vaccination) {
        Child child = findChildByName(childName);
        if (child != null) {
            child.addVaccination(vaccination);
            System.out.println("Vaccination record updated for " + childName);
        } else {
            System.out.println("Child not found.");
        }
    }

    public void viewChildRecord(String childName) {
        Child child = findChildByName(childName);
        if (child != null) {
            child.viewRecord();
        } else {
            System.out.println("Child not found.");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VaccinationSystem system = new VaccinationSystem();

        while (true) {
            System.out.println("\n--- Vaccination Management System ---");
            System.out.println("1. Add Child");
            System.out.println("2. Schedule Vaccination Appointment");
            System.out.println("3. Update Vaccination Record");
            System.out.println("4. View Child Record");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter child's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter child's date of birth (DD/MM/YYYY): ");
                    String dob = scanner.nextLine();
                    system.addChild(name, dob);
                    System.out.println("Child added successfully.");
                    break;
                case 2:
                    System.out.print("Enter child's name: ");
                    String childNameForAppointment = scanner.nextLine();
                    System.out.print("Enter appointment date (DD/MM/YYYY): ");
                    String appointmentDate = scanner.nextLine();
                    system.scheduleVaccination(childNameForAppointment, appointmentDate);
                    break;
                case 3:
                    System.out.print("Enter child's name: ");
                    String childNameForVaccination = scanner.nextLine();
                    System.out.print("Enter vaccination name: ");
                    String vaccination = scanner.nextLine();
                    system.updateVaccinationRecord(childNameForVaccination, vaccination);
                    break;
                case 4:
                    System.out.print("Enter child's name: ");
                    String childNameForRecord = scanner.nextLine();
                    system.viewChildRecord(childNameForRecord);
                    break;
                case 5:
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
