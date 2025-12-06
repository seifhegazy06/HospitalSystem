package hospitalSystem;

public class Patient extends Person {
    private int medicalHistoryID;

    public Patient(String name, int ID, String email, String phoneNumber, int medicalHistoryID) {
//        super(int ID, String name, );
        this.medicalHistoryID = medicalHistoryID;
    }

    public void setMedicalHistoryID(int medicalHistoryID){
        this.medicalHistoryID = medicalHistoryID;
    }
    public int getMedicalHistoryID(){
        return medicalHistoryID;
    }
}
