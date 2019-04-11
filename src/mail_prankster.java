import config.ConfigManager;
import config.MessageReader;
import config.VictimReader;
import model.Person;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class mail_prankster {

    public static void main(String[] args)throws IOException{

        ConfigManager config = new ConfigManager();
        //System.out.println(config.getMaliciusUser()+ config.getServerAdress() + config.getServerPort());

        MessageReader messageReader = new MessageReader(config.getMessageFile());

        VictimReader victimReader = new VictimReader(config.getVictimFile());

        Map<String,String > message = messageReader.getMessages();
        for (Map.Entry<String,String> entry : message.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());


        List<Person> vitims = victimReader.getVictims();

        for (Person entry : vitims)
            System.out.println(entry);


    }

}
