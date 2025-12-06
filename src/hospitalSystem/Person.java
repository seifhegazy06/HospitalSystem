package hospitalSystem;

public abstract class Person {
    private int ID;
    private String name;
    private String email;
    private int phoneNumber;

    public Person(int ID, String name, String email, int phoneNumber){
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.ID);
        System.out.println("Email: " + this.email);
        System.out.println("Phone Number: " + this.phoneNumber);

    }

    @Override
    public String toString(){
        return this.name + ", " + this.ID + ", " + this.email + ", " + this.phoneNumber;
    }

    public int getID(){ return ID; }
    public String getname(){ return name; }
    public String getEmail(){ return email; }
    public int getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(int phoneNumber){ this.phoneNumber = phoneNumber; }
    public void setEmail(String email){ this.email = email; }
}
