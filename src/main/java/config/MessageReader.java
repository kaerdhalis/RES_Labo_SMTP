package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MessageReader {

    private String fileName;

    public MessageReader(String fileName) {
        this.fileName = fileName;
    }

   public Map<String,String> getMessages(){


       String line = null;
       String subject = null;
       String message = null;
       Map<String,String> messages = new HashMap<>();
       boolean title = true;

       try {
           // FileReader reads text files in the default encoding.
           FileReader fileReader = new FileReader(fileName);

           // Always wrap FileReader in BufferedReader.
           BufferedReader bufferedReader =
                   new BufferedReader(fileReader);

           while((line = bufferedReader.readLine()) != null) {

               if(line.startsWith("===")) {

                   messages.put(subject,message);
                   subject = "";
                   message = "";
                   title = true;
               }
               else if(title) {

                   subject = line;
                   title = false;
               }
               else {

                   message += line +"\n";
               }

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

       return messages;
   }
}
