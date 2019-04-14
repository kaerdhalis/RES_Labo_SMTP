package config;

import model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VictimReader {

    private String fileName;

    public VictimReader(String fileName) {
        this.fileName = fileName;
    }

    public List<Person> getVictims(){

        List<Person> victims = new ArrayList<>();

        String line = null;

        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader = new FileReader(fileName);
//
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader =
//                    new BufferedReader(fileReader);

            FileInputStream fIs = new FileInputStream(fileName);

            InputStreamReader isr = new InputStreamReader(fIs,"UTF-8");

            BufferedReader bufferedReader = new BufferedReader(isr);

            while((line = bufferedReader.readLine()) != null) {

                victims.add(new Person(line));

            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }

        return victims;
    }
}
