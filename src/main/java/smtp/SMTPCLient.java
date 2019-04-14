package smtp;

import model.Mail;

import java.io.IOException;


public interface SMTPCLient {

     void sendMail(Mail mail) throws IOException;
}
