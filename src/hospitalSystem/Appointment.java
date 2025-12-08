package hospitalSystem;

public class Appointment {
	
	private int doctorID;
	private int patientMedicalHistoryID;
	private String date;
	private String time;
	private boolean isAvailable = true;
	private boolean isDone = false;
	
	public Appointment(int doctorID, int patientMedicalHistoryID, String date, String time) {
		setDoctorID(doctorID);
		setPatientMedicalHistoryID(patientMedicalHistoryID);
		setDate(date);
		setTime(time);
	}
	
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	
	public int getDoctorID() {
		return this.doctorID;
	}

	public void setPatientMedicalHistoryID(int patientMedicalHistoryID) {
		this.patientMedicalHistoryID = patientMedicalHistoryID;
	}

	public int getPatientMedicalHistoryID() {
		return this.patientMedicalHistoryID;
	}

	public void setDate(String date){
		this.date = date;
	}
	
	public String getDate(){
		return this.date;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return this.time;
	}

	public boolean isAvailable(){
		return this.isAvailable;
	}

	public void setAvailability(boolean availablity){
		this.isAvailable = availablity;
	}

	public void markAsDone(){
		isDone = true;
		isAvailable = false;
	}

	public boolean isDone(){
		return isDone;
	}

	public void display(){
		System.out.println("============= Appointment Details =================");
		System.out.println("Doctor ID: " + getDoctorID());
		System.out.println("Patient Medical History ID: " + getPatientMedicalHistoryID());
		System.out.println("Date: " + getDate());
		System.out.println("Time: " + getTime());
		System.out.println("Is Available: " + isAvailable());
		System.out.println("Is Done: " + isDone());
		System.out.println("===================================================");
	}

	public String getAppointment(){
		return"Doctor ID: " + getDoctorID() + "| " + HospitalSystem.wrapDateTimeString(date, time);
	}
}
