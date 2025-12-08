package hospitalSystem;

public class Patient extends Person {
    private int medicalHistoryID;

    public Patient(int ID, String name, String email, int phoneNumber,int medicalHistoryID) {
        super(ID, name, email, phoneNumber);
        setMedicalHistoryID(medicalHistoryID);
    }

    @Override
    public void display(){
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getID());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("medicalHistoryID: " + getMedicalHistoryID());
    }

    @Override
    public String toString(){
        return getName() + ", " + getID() + ", " + getEmail() + ", " + getPhoneNumber() + ", " + getMedicalHistoryID();
    }

    public void setMedicalHistoryID(int medicalHistoryID){
        this.medicalHistoryID = medicalHistoryID;
    }
    
    public int getMedicalHistoryID(){
        return medicalHistoryID;
    }
}
