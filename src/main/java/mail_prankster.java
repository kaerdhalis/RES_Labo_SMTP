import config.ConfigManager;
import model.Group;
import model.Person;
import model.Prank;
import model.PrankGenerator;
import smtp.SMTPClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mail_prankster {

    public static void main(String[] args)throws IOException{

    ConfigManager config = new ConfigManager();

    int numberVictim = config.getVictims().size();
    int numberGroup = config.getNumberOfGroup();
    ArrayList<Person> copy = new ArrayList<>();
    copy.add(new Person(config.getWitnessCc()));

    if(numberVictim/numberGroup <3)
        numberGroup = numberVictim/3;

        List<Person> availableVictim = new ArrayList<>(config.getVictims());
        Collections.shuffle(availableVictim);
        List<Group> groups = new ArrayList<>();
        for(int i = 0; i < config.getNumberOfGroup();i++){
            Group group = new Group();
            groups.add(group);
        }

        int turn = 0;
        Group targetGroup;
        while(availableVictim.size()>0){

            targetGroup = groups.get(turn);
            turn = (turn+1)%groups.size();
            Person victim = availableVictim.remove(0);
            targetGroup.add(victim);
        }

        SMTPClient client = new SMTPClient(config.getServerAdress(),config.getServerPort());

        PrankGenerator pranker = new PrankGenerator(groups,config.getMessages(),copy);

        while(!groups.isEmpty()){
        Prank prank = pranker.generatePrank();
            client.sendMail(prank.generateMail());
        }
//        Prank prank = pranker.generatePrank();
//        client.sendMail(prank.generateMail());




    }

}
