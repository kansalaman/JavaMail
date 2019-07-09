import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail{
    public static void main(String[] args){
        String to="akansal1906@gmail.com";
        String from="amankansal.india@gmail.com";
        String host="smtp.gmail.com";

//        Properties properties=System.getProperties();

        Properties props=new Properties();
        props.setProperty("mail.transport.protocol","smtp");
        props.setProperty("mail.host","smtp.gmail.com");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");
        props.put("mail.debug", "true");
//        props.put("mail.smtp.host",host);
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//        props.setProperty("mail.smtp.socketFactory.port","amankansal.india@gmail.com");
//        props.setProperty("mail.password","hahahaha");

        Session session=Session.getDefaultInstance(props,
                new javax.mail.Authenticator(){
            protected  PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("amankansal.india@gmail.com","hahahaha");
            }
                }
                );

        try{
            MimeMessage message=new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

            message.setSubject("This is the Subject Line!");

            message.setText("This is actual message");

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex){
            mex.printStackTrace();
        }
    }

}
