package model;

import java.util.ArrayList;

public class Prank {

    private Person senderVictim;
    private ArrayList<Person> toVictiom;
    private ArrayList<Person> copies;
    private String subject;
    private String message;


    public ArrayList<Person> getCopies() {
        return copies;
    }

    public void setCopies(ArrayList<Person> copies) {
        this.copies = copies;
    }

    public Mail generateMail(){

        Mail mail = new Mail();
        mail.setAuthor(senderVictim.getMailAdress());


        String[] victims = new String[toVictiom.size()];
        int i = 0;
        for(Person vic : toVictiom){
            victims[i] = vic.getMailAdress();
            i++;
        }

        String[] copie = new String[copies.size()];
         i = 0;
        for(Person copy : copies){
            copie[i] = copy.getMailAdress();
            i++;
        }

        mail.setCopies(copie);

        mail.setDestinataires(victims);
        mail.setSujet(subject);
        mail.setTexte(message);

        return mail;
    }

    public Person getSenderVictim() {
        return senderVictim;
    }

    public void setSenderVictim(Person senderVictim) {
        this.senderVictim = senderVictim;
    }

    public ArrayList<Person> getToVictiom() {
        return toVictiom;
    }

    public void setToVictiom(ArrayList<Person> toVictiom) {
        this.toVictiom = toVictiom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
