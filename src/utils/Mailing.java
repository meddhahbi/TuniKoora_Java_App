package utils;

import Models.Users;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Nayrouz
 */
public class Mailing {
    
            public static void sendMail(Users c) throws Exception {


        Properties prop = new Properties();
        final String moncompteEmail = "mahdiaroua9@gmail.com";
        final String psw = "mahdiaroua92";
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.ssl.trust", "*");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session ses = Session.getInstance(prop, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(moncompteEmail, psw);
            }
        });

        try {

            Message msg = new MimeMessage(ses);
            msg.setFrom(new InternetAddress(moncompteEmail));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(c.getEmail()));
            msg.setSubject("ForU");
            msg.setText("Bonjour Mr/Mme "+ c.getNom()+", votre inscription est validé ! " );
            System.out.println(c.getEmail());
            System.out.println("mail sent");

            Transport.send(msg);

        } catch (MessagingException ex) {
            Logger.getLogger(Mailing.class.getName()).log(Level.SEVERE, null, ex);
        }

         }   
}