package hospitalSystem;

import java.util.ArrayList;

public class Doctor extends Person {

    ArrayList<String> availableTimes = new ArrayList<>();

    DoctorSpecialization specialization;
    RoomNum roomNumber;

    public Doctor(int id, String name, String email, int phoneNumber, DoctorSpecialization doctorSpecialization,
            RoomNum roomNumber) {
        super(id, name, email, phoneNumber);
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

    public void addAvailableTime(String timeSlot) {
        availableTimes.add(timeSlot);
    }

    public void deleteAvailableTimeSlot(String timeSlot) {
        availableTimes.remove(timeSlot);
    }

    public void setRoomNum(RoomNum roomNum) {
        this.roomNumber = roomNum;
    }

    public RoomNum getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getRoomNumber() + ", " + getSpecialization();
    }

}
