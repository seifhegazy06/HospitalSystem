package hospitalSystem;
import java.util.ArrayList;

public class HospitalSystem {
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	private ArrayList<Appointments> appointments = new ArrayList<Appointments>();
	
	
	public void addDoctor(String name, int ID, String email, String phoneNumber,
						DoctorSpecialization specialization, ArrayList<String> availableTime, RoomNum roomNum) {
		
		Doctor doctor = new Docotor(name, ID, email, phoneNumber, specialization, availableTime, roomNum);
				
		doctors.add(doctor);
		
	}
	
	public void editDoctor(int ID, String email, String phoneNumber, DoctorSpecialization specialization, RoomNum roomNum) {
		Doctor doctor = findDoctor(ID);
		
		if (doctor == null)
			return;
	
		doctor.setEmail(email);
		doctor.setPhoneNumber(phoneNumber);
		doctor.setSpecialization(specialization);
		doctor.setRoomNum(roomNum);
	
	}
	
	public void addPatient(int ID, String name, String email, int phoneNumber, int medicalHistoryID) {

		Patient patient = new Patient (ID, name, email, phoneNumber, medicalHistoryID);
			
		patients.add(patient);
		
	}
	
	public void editPatient(int patientID, String email, int phoneNumber) {
		Patient patient = findPatient(patientID);
		if (patient == null)
			return;
		
		patient.setEmail(email);
		patient.setPhoneNumber(phoneNumber);
	}
	
	public void addAvailableSlot(int doctorID, String date, String time) {
		Doctor doctor = findDoctor(doctorID);
		
		if (doctor == null)
			return;

		// ADD time to doctor object according to the format needed
		
	}
	
	
	// to be implemented when the Doctor and Appointment Classes are pushed to the repo
	public void bookAppointment() {}
	public void cancelAppointment() {}
	public ArrayList<String> getBookedAppointments(int doctorID) {}
	public ArrayList<String> getAvailableAppointments(int doctorID) {}
	
	private Doctor findDoctor(int doctorID) {
		for (Doctor doctor : doctors) {
			if (doctor.getID() == doctorID)
				return doctor;
		}
		System.out.println("!Warning: Doctor of entered ID is not found, double check its ID or add the doctor to the system first.");
		return null;
	}
	
	private Patient findPatient(int patientID) {
		for (Patient patient: patients) {
			if (patient.getID() == patientID)
				return patient;
		}
		System.out.println("!Warning: patient of entered ID is not found, double check its ID or add the patient to the system first.");
		return null;
	}
}
