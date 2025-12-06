package hospitalSystem;

public class Patient extends Person {
    private int medicalHistoryID;

    public Patient(int ID, String name, String email, int phoneNumber,int medicalHistoryID) {
        super(ID, name, email, phoneNumber);
        this.medicalHistoryID = medicalHistoryID;
    }


    public void setMedicalHistoryID(int medicalHistoryID){
        this.medicalHistoryID = medicalHistoryID;
    }
    public int getMedicalHistoryID(){
        return medicalHistoryID;
    }
}
