package model;

public class Person {

    private String firstName;
    private String lastName;
    private String mailAdress;

    public Person(String mailAdress) {
        this.mailAdress = mailAdress;
        String delim = "@";
        String tokens[] = mailAdress.split(delim);
        delim = "\\.";
        String name[]= tokens[0].split(delim);

        this.firstName = name[0];
        this.lastName = name[1];

    }

    public Person(String firstName, String lastName, String mailAdress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAdress = mailAdress;
    }

    public String toString(){
        return firstName + " " + lastName + " " + mailAdress;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMailAdress() {
        return mailAdress;
    }
}
