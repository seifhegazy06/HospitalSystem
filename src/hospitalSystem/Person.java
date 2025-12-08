package hospitalSystem;

public abstract class Person {
    private int ID;
    private String name;
    private String email;
    private int phoneNumber;

    public Person(int ID, String name, String email, int phoneNumber){
        this.ID = ID;
        this.name = name;
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public void display(){
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getID());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());

    }

    @Override
    public String toString(){
        return this.name + ", " + this.ID + ", " + this.email + ", " + this.phoneNumber;
    }

    public int getID(){ return ID; }
    public String getName(){ return name; }
    public String getEmail(){ return email; }
    public int getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(int phoneNumber){ this.phoneNumber = phoneNumber; }
    public void setEmail(String email){ this.email = email; }
}
