package hospitalSystem;

public class Patient extends Person {
    private int medicalHistoryID;

    public Patient(int id, String name, String email, int phoneNumber, int medicalHistoryID) {
        super(id, name, email, phoneNumber);
        this.medicalHistoryID = medicalHistoryID;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getMedicalHistoryID();
    }

    public void setMedicalHistoryID(int medicalHistoryID) {
        this.medicalHistoryID = medicalHistoryID;
    }

    public int getMedicalHistoryID() {
        return medicalHistoryID;
    }
}
