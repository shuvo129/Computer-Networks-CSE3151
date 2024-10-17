package Networking;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * This class is used to send simple email.
 * @author w3spoint
 */
public class SendSimpleEmail {
    final String senderEmailId = "tr617739@gmail.com";
    final String senderPassword = "uhkqjrkquknlcgws";
    final String emailSMTPserver = "smtp.gmail.com";

    public SendSimpleEmail(String receiverEmail,
                           String subject, String messageText) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", emailSMTPserver);
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        try {
            //Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmailId,senderPassword);
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmailId));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiverEmail));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);
            System.out.println("Email send successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error in sending email."+e);
        }
    }

    /*class SMTPAuthenticator extends
            javax.mail.Authenticator {
        public PasswordAuthentication
        getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmailId,
                    senderPassword);
        }
    }*/

    public static void main(String[] args) {
        SendSimpleEmail obj=new SendSimpleEmail("tarekrahman1884@gmail.com",
                "Code Testing", "Hi,\n\n My name is khan and \nI am not a terrorist");
    }
}
