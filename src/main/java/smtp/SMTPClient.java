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
        LOG.info("create socket at adresse "+serverAdress);
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));
        writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(),"UTF-8"),true);

        String line = reader.readLine();
        LOG.info(line);

        writer.write("EHLO client\r\n");
        writer.flush();

        line = reader.readLine();
        LOG.info(line);
        while(line.startsWith("250-")){

            line = reader.readLine();
            LOG.info(line);
        }

       writer.write("MAIL FROM: ");
       writer.write(mail.getAuthor());
       writer.write("\r\n");
        writer.flush();
        line = reader.readLine();
        LOG.info(line);


        for(String destinataire : mail.getDestinataires()){
            writer.write("RCPT TO: "+ destinataire+"\r\n");
//            writer.write(destinataire);
//            writer.write("\n");

            writer.flush();
            line = reader.readLine();
            LOG.info(line);
        }

        for(String copies : mail.getCopies()){
            writer.write("RCPT TO: "+ copies+"\r\n");
//            writer.write(copies);
//            writer.write("\n");

            writer.flush();
            line = reader.readLine();
            LOG.info(line);
        }


        writer.write("DATA\r\n");
        writer.flush();
        line = reader.readLine();
        LOG.info(line);

        writer.write("From: ");
        writer.write(mail.getAuthor());
        writer.write("\r\n");

        writer.write("To: ");
        for(String destinatair : mail.getDestinataires()){
            writer.write(destinatair+ ", ");
        }
        writer.write("\r\n");

        writer.write("Cc: ");
        for(String copy : mail.getCopies()){
            writer.write(copy+ ", ");
        }
        writer.write("\r\n");


        writer.write("Subject: ");
        writer.write(mail.getSujet());
        writer.write("\n\n");

        writer.write(mail.getTexte());
        writer.write("\r\n");


        writer.write(".");
        writer.write("\r\n");
        writer.flush();
        line= reader.readLine();
        LOG.info(line);

        writer.write("QUIT");
        writer.write("\r\n");
        writer.flush();
        line= reader.readLine();
        LOG.info(line);

        writer.close();
        reader.close();
        clientSocket.close();





    }
}
