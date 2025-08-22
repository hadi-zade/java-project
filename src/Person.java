public class Person {
    protected String name;
    protected String id;
    protected String email;
    protected String nationalId;
    protected String phoneNumber;
    protected String birthDate;

    public Person(String name, String id, String email, String nationalId, String phoneNumber, String birthDate) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.nationalId = nationalId;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public void showInfo() {

        System.out.println("Name: " + name + ", ID: " + id);
    }
}