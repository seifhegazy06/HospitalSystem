package hospitalSystem;

public class  Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doctor doctor = new Doctor(0, null, null, 0, DoctorSpecialization.Cardiologist, RoomNum.A1);
		Patient patient = new Patient(0, null, null, 0, 0);
		doctor.display();
		patient.display();

		System.err.println(doctor);
	}

}
