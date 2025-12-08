package hospitalSystem;

import java.util.ArrayList;

public class Doctor extends Person {

    ArrayList<String> availableTimes = new ArrayList<>();

    DoctorSpecialization  specialization;
    RoomNum roomNumber;

    public Doctor(int ID, String name, String email, int phoneNumber, DoctorSpecialization doctorSpecialization, RoomNum roomNumber){
        super(ID, name, email, phoneNumber);
        setSpecialization(doctorSpecialization);
        setRoomNum(roomNumber);
    }

    public void setSpecialization(DoctorSpecialization specialization) {
        this.specialization = specialization;
    }

    public DoctorSpecialization getSpecialization() {
        return specialization;
    }

    public ArrayList<String> getAvailableTimes() {
        return availableTimes;
    }

    public void addAvailableTime(String timeSlot){
        availableTimes.add(timeSlot);
    }

    public void deleteAvailableTimeSlot(String timeSlot){
        availableTimes.remove(timeSlot);
    }

    public void setRoomNum(RoomNum roomNum) {
        this.roomNumber = roomNum;
    }

    public RoomNum getRoomNumber() {
        return roomNumber;
    }

    @Override
    public void display(){
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getID());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Specialization: " + getSpecialization());
        System.out.println("Room Number: " + getRoomNumber());
        System.out.print("Available Times :");
        for(String time : availableTimes){
            System.out.print(" " + time);
        }
        System.out.println(" ");
    }

    @Override
    public String toString(){
        return getName() + ", " + getID() + ", " + getEmail() + ", " + getPhoneNumber() + ", " + getRoomNumber() + ", " + getSpecialization();
    }

}
