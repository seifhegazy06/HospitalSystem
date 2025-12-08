package hospitalSystem;

public class Appointment {
	
	private int doctorID;
	private int patientMedicalHistoryID;
	private String date;
	private String time;
	private boolean isAvailable = true;
	
	public Appointment(int doctorID, int patientMedicalHistoryID, String date, String time) {
		setDoctorID(doctorID);
		setPatientMedicalHistoryID(patientMedicalHistoryID);
		setDate(date);
		this.time = time;
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

}
