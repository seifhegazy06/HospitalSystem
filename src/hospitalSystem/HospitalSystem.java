package hospitalSystem;
import java.util.ArrayList;

public class HospitalSystem {
	private ArrayList<Doctor> doctors = new ArrayList<>();
	private ArrayList<Patient> patients = new ArrayList<>();
	private ArrayList<Appointment> appointments = new ArrayList<>();
	
	public HospitalSystem() {}
	
	public static String wrapDateTimeString(String date, String time){
		return date + ", " + time;
	}

	public int addDoctor(String name, int ID, String email, int phoneNumber,
						DoctorSpecialization specialization, ArrayList<String> availableTime, RoomNum roomNum) {
		Doctor doctor = findDoctor(ID);
		if (doctor != null){
			System.out.println("The doctor already exists\n=================================================");
			doctor.display();
			System.out.println("=================================================");
			return -1;
		}

		doctor = new Doctor(ID, name, email, phoneNumber, specialization, roomNum);
		doctors.add(doctor);

		System.out.println("The patient is added successfully");

		return 0;
		
	}
	
	public int editDoctor(int ID, String email, int phoneNumber, DoctorSpecialization specialization, RoomNum roomNum) {
		Doctor doctor = findDoctor(ID);
		
		if (doctor == null)
			return -1;

		doctor.setEmail(email);
		doctor.setPhoneNumber(phoneNumber);
		doctor.setSpecialization(specialization);
		doctor.setRoomNum(roomNum);

		return 0;
	
	}
	
	public int addPatient(int ID, String name, String email, int phoneNumber, int medicalHistoryID) {

		Patient patient = findPatient(ID);
		if (patient != null){
			System.out.println("The Patien already exists\n=================================================");
			patient.display();
			System.out.println("=================================================");
			return -1;
		}
			
		patient = new Patient (ID, name, email, phoneNumber, medicalHistoryID);
		patients.add(patient);
		
		System.out.println("the patient is added successfully");

		return 0;
		
	}
	
	public int editPatient(int patientID, String email, int phoneNumber) {
		Patient patient = findPatient(patientID);
		if (patient == null)
			return -1;
		
		patient.setEmail(email);
		patient.setPhoneNumber(phoneNumber);

		return 0;
	}
	
	public int addAvailableSlot(int doctorID, String date, String time) {
		Doctor doctor = findDoctor(doctorID);
		if (doctor == null)
			return -1;

		String timeSlot = wrapDateTimeString(date, time);

		for (String availableTime : doctor.getAvailableTimes()){
			if (availableTime.equals(timeSlot)){
				System.out.println("This time slot is already exists in the doctor's available time");
				return -1;
			}
		}
		
		doctor.addAvailableTime(timeSlot);
		System.out.println(timeSlot + " is successfully added to the doctors available times");
		return 0;
	}
	
	public int bookAppointment(int doctorID, int patientMedicalHistoryID, String date, String time) {
			if(checkAppointment(doctorID, patientMedicalHistoryID))
				return -1;

			Doctor doctor = findDoctor(doctorID);
			for (String availableSlot : doctor.getAvailableTimes()){
				if (availableSlot.equals(wrapDateTimeString(date, time))){
					Appointment appointment = new Appointment(doctorID, patientMedicalHistoryID, date, time);

					appointments.add(appointment);
					
					doctor.deleteAvailableTimeSlot(wrapDateTimeString(date, time));

					System.out.println("Appointment is booked successfully at " + wrapDateTimeString(date, time));
					return 0;
				}
			}
			System.out.println("Doctor is not available at " + wrapDateTimeString(date, time) + ", make sure of doctor available time slots.");
			return -1;
		}

	public int cancelAppointment(int doctorID, int patientMedicalHistoryID, String date, String time) {
		for (Appointment appointment : appointments){
			if (appointment.getDoctorID() == doctorID && appointment.getPatientMedicalHistoryID() == patientMedicalHistoryID &&
				appointment.getDate() == date && appointment.getTime() == time){

				appointments.remove(appointment);
				
				addAvailableSlot(doctorID, date, time);

				System.out.println("The Appointment is successfully cancelled");

				return 0;
			}
		}
		System.out.println("There is no such appointment between the patient and the doctor at " + wrapDateTimeString(date, time));
		return -1;
	}
	
	public ArrayList<Appointment> getBookedAppointments() {
		ArrayList<Appointment> bookedAppointments = new ArrayList<>();
		
		for (Appointment appointment : appointments) {
			if (!appointment.isDone()){
				bookedAppointments.add(appointment);
				appointment.display();
			}
		}
		return bookedAppointments;
	}

	public ArrayList<Appointment> getBookedAppointments(int doctorID) {
		ArrayList<Appointment> bookedAppointments = new ArrayList<>();
		
		for (Appointment appointment : appointments) {
			if (appointment.getDoctorID() == doctorID && !appointment.isDone()){
				bookedAppointments.add(appointment);
				appointment.display();
			}
		}
		return bookedAppointments;
	}
	
	public ArrayList<Appointment> getAvailableAppointments() {
		ArrayList<Appointment> availableAppointments = new ArrayList<>();
		
		for (Appointment appointment : appointments) {
			if (!appointment.isDone() && appointment.isAvailable()){
				availableAppointments.add(appointment);
				appointment.display();
			}
		}
		return availableAppointments;
	}

	public ArrayList<Appointment> getAvailableAppointments(int doctorID) {
		ArrayList<Appointment> availableAppointments = new ArrayList<>();
		
		for (Appointment appointment : appointments) {
			if (appointment.getDoctorID() == doctorID && !appointment.isDone() && appointment.isAvailable()){
				availableAppointments.add(appointment);
				appointment.display();
			}
		}
		return availableAppointments;
	}

	public void markAppointmentAsDone(int doctorID, int patientMedicalHistoryID, String date, String time){
		for (Appointment appointment : appointments) {
			if (appointment.getDoctorID() == doctorID && appointment.getPatientMedicalHistoryID()==patientMedicalHistoryID &&
			appointment.getDate() == date && appointment.getTime() == time){
				appointment.markAsDone();
			}
		}
	}

	private Doctor findDoctor(int doctorID) {
		for (Doctor doctor : doctors) {
			if (doctor.getID() == doctorID)
				return doctor;
		}
		System.out.println("Doctor of entered ID is not found");
		return null;
	}
	
	private Patient findPatient(int patientID) {
		for (Patient patient: patients) {
			if (patient.getID() == patientID)
				return patient;
		}
		System.out.println("patient of entered ID is not found");
		return null;
	}

	private boolean checkAppointment(int doctorID, int patientMedicalHistoryID){
		for (Appointment appointment : appointments){
			if (appointment.getDoctorID() == doctorID && appointment.getPatientMedicalHistoryID() == patientMedicalHistoryID && !appointment.isDone()){
				System.out.println("There is already an incoming appointment for the patient with the same doctor at "
					+ wrapDateTimeString(appointment.getDate(), appointment.getTime()));
					return true;
				}
			}
			return false;
	}
}