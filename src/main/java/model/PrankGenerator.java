package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PrankGenerator {

    private List<Group> groupe;
    private Map<String,String> messageFile;
    private ArrayList<Person> copy;

    public PrankGenerator(List<Group> groupe, Map<String,String> messageFile,ArrayList<Person> copy) {
        this.groupe = groupe;
        this.messageFile = messageFile;
        this.copy = copy;
    }

    public Prank generatePrank(){

        Prank prank = new Prank();
        Random rand = new Random();

        int n = rand.nextInt(groupe.size());

        Group group = groupe.get(n);
        groupe.remove(n);

        n = rand.nextInt(group.getGroupember().size());
        group.setSender(group.getGroupember().get(n));
        prank.setSenderVictim(group.getGroupember().get(n));

        ArrayList<Person> reciver = new ArrayList<>(group.getGroupember());
        reciver.remove(n);

        prank.setToVictiom(reciver);
        prank.setCopies(copy);

        n = rand.nextInt(messageFile.size());

        String[] subjects = messageFile.keySet().toArray(new String[0]);

        String subject = subjects[n];
        prank.setSubject(subject);
        prank.setMessage(messageFile.get(subject));

        return prank;
    }

    }
