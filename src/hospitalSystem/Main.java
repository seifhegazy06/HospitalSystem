package hospitalSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static boolean running = true;
    private static Scanner scanner = new Scanner(System.in);
    private static HospitalSystem system = new HospitalSystem();

    public static void main(String[] args) {
        printLogo();

        while (running) {
            int choice = mainMenu();
            switch (choice) {
                case 1:
                    handleDoctorMenu();
                    break;
                case 2:
                    handlePatientMenu();
                    break;
                case 3:
                    handleAppointmentMenu();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Input! Try again");
            }
        }

        System.out.println("Exiting...");
        scanner.close();
    }

    // helper functions
    private static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getUserInputInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        return input;
    }

    private static <T extends Enum<T>> T getUserInputEnum(String prompt, Class<T> enumType) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            for (T constant : enumType.getEnumConstants()) {
                if (constant.name().equalsIgnoreCase(input)) {
                    return constant;
                }
            }

            System.out.print("Invalid input. Available options: [");
            T[] constants = enumType.getEnumConstants();
            for (int i = 0; i < constants.length; i++) {
                System.out.print(constants[i].name());
                if (i < constants.length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    private static void printLogo() {
        System.out.println(
                "▄    ▄                               ▄▄     ▀                         ▄    ▄                        ▀      ▄           ▀▀█");
        System.out.println(
                "█  ▄▀   ▄▄▄    ▄▄▄    ▄ ▄▄           ██   ▄▄▄    ▄ ▄▄   ▄   ▄         █    █  ▄▄▄    ▄▄▄   ▄▄▄▄   ▄▄▄    ▄▄█▄▄   ▄▄▄     █   ");
        System.out.println(
                "█▄█    ▀   █  █   ▀   █▀  ▀         █  █    █    █▀  █  ▀▄ ▄▀         █▄▄▄▄█ █▀ ▀█  █   ▀  █▀ ▀█    █      █    ▀   █    █   ");
        System.out.println(
                "█  █▄  ▄▀▀▀█   ▀▀▀▄   █             █▄▄█    █    █   █   █▄█          █    █ █   █   ▀▀▀▄  █   █    █      █    ▄▀▀▀█    █   ");
        System.out.println(
                "█   ▀▄ ▀▄▄▀█  ▀▄▄▄▀   █            █    █ ▄▄█▄▄  █   █   ▀█           █    █ ▀█▄█▀  ▀▄▄▄▀  ██▄█▀  ▄▄█▄▄    ▀▄▄  ▀▄▄▀█    ▀▄▄");
        System.out.println(
                "                                                         ▄▀                                █");
        System.out.println(
                "                                                        ▀▀                                 ▀");
    }

    // menus
    private static int mainMenu() {
        System.out.println("\n=== HOSPITAL MANAGEMENT SYSTEM ===");
        System.out.println("1. Doctor Management");
        System.out.println("2. Patient Management");
        System.out.println("3. Appointment/Booking");
        System.out.println("0. Exit");
        System.out.print("==================================\n");

        return getUserInputInt("Choose an option: ");
    }

    private static void handleDoctorMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- DOCTOR MANAGEMENT ---");
            System.out.println("1. Add New Doctor");
            System.out.println("2. Edit Doctor Details");
            System.out.println("3. Add Available Slot");
            System.out.println("0. Back");

            int choice = getUserInputInt("Choose operation: ");
            switch (choice) {
                case 1:
                    addDoctorUI();
                    break;
                case 2:
                    editDoctorUI();
                    break;
                case 3:
                    addSlotUI();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void handlePatientMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- PATIENT MANAGEMENT ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Edit Patient Info");
            System.out.println("0. Back");

            int choice = getUserInputInt("Choose operation: ");
            switch (choice) {
                case 1:
                    addPatientUI();
                    break;
                case 2:
                    editPatientUI();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void handleAppointmentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- APPOINTMENT CENTER ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. Cancel Appointment");
            System.out.println("3. View All Booked Appointments");
            System.out.println("4. View Doctor Availability");
            System.out.println("0. Back");

            int choice = getUserInputInt("Choose operation: ");
            switch (choice) {
                case 1:
                    bookAppointmentUI();
                    break;
                case 2:
                    cancelAppointmentUI();
                    break;
                case 3:
                    printAppointments(system.getBookedAppointments());
                    break;
                case 4:
                    int docID = getUserInputInt("Enter Doctor ID: ");
                    try {
                        printAppointments(system.getAvailableAppointments(docID));
                    } catch (EntityNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void printAppointments(ArrayList<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("============= Appointments =================");
            for (Appointment appt : appointments) {
                System.out.println(appt);
            }
            System.out.println("============================================");
        }
    }

    // --- ACTION METHODS ---

    private static void addDoctorUI() {
        System.out.println(">> Adding New Doctor");
        String name = getUserInput("Name: ");
        int id = getUserInputInt("ID: ");
        String email = getUserInput("Email: ");
        int phone = getUserInputInt("Phone Number: ");

        DoctorSpecialization spec = getUserInputEnum("Specialization: ", DoctorSpecialization.class);
        RoomNum room = getUserInputEnum("Room Number: ", RoomNum.class);

        // Passing empty list for initial time slots to keep UI clean
        try {
            system.addDoctor(name, id, email, phone, spec, new ArrayList<>(), room);
            System.out.println("Doctor added successfully.");
        } catch (DuplicateEntityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void editDoctorUI() {
        System.out.println(">> Editing Doctor");
        int id = getUserInputInt("Enter Doctor ID to edit: ");
        String email = getUserInput("New Email: ");
        int phone = getUserInputInt("New Phone: ");

        DoctorSpecialization spec = getUserInputEnum("New Specialization: ", DoctorSpecialization.class);
        RoomNum room = getUserInputEnum("New Room: ", RoomNum.class);

        try {
            system.editDoctor(id, email, phone, spec, room);
            System.out.println("Doctor updated.");
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addSlotUI() {
        int id = getUserInputInt("Doctor ID: ");
        String date = getUserInput("Date (DD-MM-YYYY): ");
        String time = getUserInput("Time (HH:MM): ");
        try {
            system.addAvailableSlot(id, date, time);
            System.out.println("Slot added successfully.");
        } catch (EntityNotFoundException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addPatientUI() {
        System.out.println(">> Registering Patient");
        int id = getUserInputInt("ID: ");
        String name = getUserInput("Name: ");
        String email = getUserInput("Email: ");
        int phone = getUserInputInt("Phone: ");
        int medHistID = getUserInputInt("Medical History ID: ");

        try {
            system.addPatient(id, name, email, phone, medHistID);
            System.out.println("Patient registered.");
        } catch (DuplicateEntityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void editPatientUI() {
        int id = getUserInputInt("Patient ID: ");
        String email = getUserInput("New Email: ");
        int phone = getUserInputInt("New Phone: ");

        try {
            system.editPatient(id, email, phone);
            System.out.println("Patient updated.");
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void bookAppointmentUI() {
        int docID = getUserInputInt("Doctor ID: ");
        int patHistID = getUserInputInt("Patient Med. History ID: ");
        String date = getUserInput("Date (DD-MM-YYYY): ");
        String time = getUserInput("Time (HH:MM): ");

        try {
            system.bookAppointment(docID, patHistID, date, time);
            System.out.println("Appointment Booked!");
        } catch (EntityNotFoundException | AppointmentConflictException | IllegalArgumentException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

    private static void cancelAppointmentUI() {
        int docID = getUserInputInt("Doctor ID: ");
        int patHistID = getUserInputInt("Patient Med. History ID: ");
        String date = getUserInput("Date (DD-MM-YYYY): ");
        String time = getUserInput("Time (HH:MM): ");

        try {
            system.cancelAppointment(docID, patHistID, date, time);
            System.out.println("Appointment Cancelled.");
        } catch (EntityNotFoundException e) {
            System.out.println("Cancellation failed: " + e.getMessage());
        }
    }
}
