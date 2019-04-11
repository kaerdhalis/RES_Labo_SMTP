package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class PrankGenerator {

    private ArrayList<Group> groupe;
    private Map<String,String> messageFile;

    public PrankGenerator(ArrayList<Group> groupe, Map<String,String> messageFile) {
        this.groupe = groupe;
        this.messageFile = messageFile;
    }

    public Prank generatePrank(){

        Prank prank = new Prank();
        Random rand = new Random();

        int n = rand.nextInt(groupe.size());

        Group group = groupe.get(n);

        n = rand.nextInt(group.getGroupember().size());
        group.setSender(group.getGroupember().get(n));
        prank.setSenderVictim(group.getGroupember().get(n));

        Collections.copy(group.getReceivers(), group.getGroupember());
        group.getReceivers().remove(n);

        prank.setToVictiom(group.getReceivers());

        n = rand.nextInt(messageFile.size());

        String[] subjects = messageFile.keySet().toArray(new String[0]);

        String subject = subjects[n];
        prank.setSubject(subject);
        prank.setMessage(messageFile.get(subject));


        return prank;
    }

//    private String[] getMessagList{
//
//         ArrayList<String> messages;
//         String line;
//         String message;
//
//        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader =
//                    new FileReader(messageFile);
//
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader =
//                    new BufferedReader(fileReader);
//
//            while((line = bufferedReader.readLine()) != null) {
//
//
//
//            }
//
//            // Always close files.
//            bufferedReader.close();
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println(
//                    "Unable to open file '" +
//                            messageFile + "'");
//        }
//        catch(IOException ex) {
//            System.out.println(
//                    "Error reading file '"
//                            + messageFile + "'");
//            // Or we could just do this:
//            // ex.printStackTrace();
//        }



    }
