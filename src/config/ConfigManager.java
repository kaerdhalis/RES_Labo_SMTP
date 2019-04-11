package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigManager {

    private InputStream inputStream;
    private String serverAdress;
    private int serverPort;
    private  int numberOfGroup;
    private String witnessCc;
    private String maliciusUser;

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

    public String getMaliciusUser() {
        return maliciusUser;
    }

    public ConfigManager() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
             serverAdress = prop.getProperty("serverAdress");
             serverPort = Integer.parseInt(prop.getProperty("serverPort"));
             numberOfGroup = Integer.parseInt(prop.getProperty("numberOfGroup"));
             witnessCc = prop.getProperty("witnessCc");
             maliciusUser = prop.getProperty("maliciusUser");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }
}
