package config;

import model.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class ConfigManager {

    private InputStream inputStream;
    private String messageFile;
    private String victimFile;
    private String serverAdress;
    private int serverPort;
    private  int numberOfGroup;
    private String witnessCc;
    private Map<String,String> messages;
    private List<Person> victims;



    public String getServerAdress() {
        return serverAdress;
    }

    public int getServerPort() {
        return serverPort;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public String getWitnessCc() {
        return witnessCc;
    }

    public String getMessageFile() {
        return messageFile;
    }

    public String getVictimFile() {
        return victimFile;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public List<Person> getVictims() {
        return victims;
    }

    public ConfigManager()throws IOException{

        try {
            Properties prop = new Properties();

            String propFileName = "config.properties";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            messageFile = prop.getProperty("messageFile");
            victimFile = prop.getProperty("victimFile");
             serverAdress = prop.getProperty("serverAdress");
             serverPort = Integer.parseInt(prop.getProperty("serverPort"));
             numberOfGroup = Integer.parseInt(prop.getProperty("numberOfGroup"));
             witnessCc = prop.getProperty("witnessCc");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {

            try {
                if( inputStream!=null ) {
                    inputStream.close();
                }
            } catch(IOException e) {
                System.out.println("Exception: " + e);
            }

        }

        messages = new MessageReader(messageFile).getMessages();
        victims = new VictimReader(victimFile).getVictims();



    }
}
