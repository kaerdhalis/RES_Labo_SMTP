package smtp;

import model.Mail;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SMTPClient implements SMTPCLient {

    final static Logger LOG = Logger.getLogger(SMTPClient.class.getName());

    private String serverAdress;
    private int serverPort;

    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean connected = false;

    public SMTPClient(String serverAdress,int serverPort){

        this.serverAdress = serverAdress;
        this.serverPort = serverPort;

    }

    @Override
    public void sendMail(Mail mail) throws IOException {

        LOG.info("sending mail via SMTP ");

        clientSocket = new Socket(serverAdress, serverPort);
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));
        writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(),"UTF-8"),true);

        String line = reader.readLine();
        LOG.info(line);

        writer.write("EHLO client");

        line = reader.readLine();
        while(line.startsWith("250")){

            reader.readLine();
        }

        writer.write("MAIL FROM:");
        writer.write(mail.getAuthor());
        writer.write("\n");
        reader.readLine();


        //faire une boucle
        writer.write("RCPT TO:");
        writer.write(mail.getDestinataires()[0]);
        writer.write("\n");
        reader.readLine();


        writer.write("DATA");
        reader.readLine();

        writer.write("Subject:");
        writer.write(mail.getSujet());
        writer.write("\n");

        writer.write(mail.getTexte());
        writer.write("\n");


        writer.write(".");
        writer.write("\n");
        reader.readLine();

        writer.write("QUIT");
        writer.write("\n");
        reader.readLine();

        clientSocket.close();





    }
}
