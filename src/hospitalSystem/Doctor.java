package hospitalSystem;

import java.util.ArrayList;

public class Doctor extends Person {

    ArrayList<String> availableTimes ;

    DoctorSpecialization  specialization;
    roomNum roomNumber;

    public void setSpecialization(DoctorSpecialization specialization) {
        this.specialization = specialization;
    }

    public DoctorSpecialization  getSpecialization() {
        return specialization;
    }


    public ArrayList<String> getAvailableTimes() {
        return availableTimes;
    }

    public void setRoomNum(roomNum roomNum) {
        this.roomNumber = roomNum;

    }

    public roomNum getRoomNumber() {
        return roomNumber;
    }

    @Override
    public void display(){
        System.out.println("Name: " + getname());
        System.out.println("ID: " + getID());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Specialization: " + this.specialization);
        System.out.println("Room Number: " + this.roomNumber);

    }

}
