package hospitalSystem;

public abstract class Person {
    private int ID;
    private String name;
    private String email;
    private int phoneNumber;

    public int getID(){ return ID; }
    public String getname(){ return name; }
    public String getEmail(){ return email; }
    public int getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(int phoneNumber){ this.phoneNumber = phoneNumber; }
    public void setEmail(String email){this.email = email;}
}
