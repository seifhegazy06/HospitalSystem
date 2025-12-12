package hospitalSystem;

public class Appointment {

	private int doctorID;
	private int patientMedicalHistoryID;
	private String date;
	private String time;
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

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return this.date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return this.time;
	}

	public void markAsDone() {
		isDone = true;
	}

	public boolean isDone() {
		return this.isDone;
	}

	@Override
	public String toString() {
		return "Doctor ID: " + doctorID + ", Patient History ID: " + patientMedicalHistoryID +
				", Date: " + date + ", Time: " + time + ", Status: " + (isDone ? "Done" : "Scheduled");
	}

}
