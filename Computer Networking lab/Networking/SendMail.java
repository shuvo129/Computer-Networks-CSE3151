package Networking;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class SendMail {

    public static void main(String[] args) {

        // change accordingly
        final String username = "tarekrahman1884@gmail.com";

        // change accordingly
        final String password = "uhkqjrkquknlcgws";

        // or IP address
       // final String host = "localhost";

        // Get system properties
        Properties props = new Properties();

        // enable authentication
        props.put("mail.smtp.auth", "true");

        // enable STARTTLS
        props.put("mail.smtp.starttls.enable", "true");

        // Setup mail server
        props.put("mail.smtp.host", "smtp.gmail.com");

        // TLS Port
        props.put("mail.smtp.port", "587");

        // creating Session instance referenced to
        // Authenticator object to pass in
        // Session.getInstance argument
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    //override the getPasswordAuthentication method
                    protected PasswordAuthentication
                    getPasswordAuthentication() {

                        return new PasswordAuthentication(username,
                                password);
                    }
                });

        try {

            // compose the message
            // javax.mail.internet.MimeMessage class is
            // mostly used for abstraction.
            Message message = new MimeMessage(session);

            // header field of the header.
            message.setFrom(new InternetAddress("tarekrahman1884@gmail.com"));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("mdjasont@gmail.com"));
            message.setSubject("hello");
            message.setText("Yo it has been sent");

            Transport.send(message);		 //send Message

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
