package model;

import java.util.ArrayList;

public class Group {

    private ArrayList<Person> groupember;
    private Person sender;
    private ArrayList<Person> receivers;

    public void  add(Person p){
        groupember.add(p);
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public void setReceivers(ArrayList<Person> receivers) {
        this.receivers = receivers;
    }

    public ArrayList<Person> getGroupember() {
        return groupember;
    }

    public Person getSender() {
        return sender;
    }

    public ArrayList<Person> getReceivers() {
        return receivers;
    }
}
