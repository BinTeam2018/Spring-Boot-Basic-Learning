package com.springboot2.project07.dao;

import com.springboot2.project07.config.MailConfig;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailSender {
    private Properties properties;
    private Session session;
    private MimeMessage mimeMessage;
    private MailSSLSocketFactory mailSSLSocketFactory;

    public void sendMessage(String toSendAddress, String toMessage){
        try {
            properties = System.getProperties();
            properties.setProperty("mail.smtp.host", MailConfig.MAILSMTPHOST);
            properties.put("mail.smtp.auth", "true");
            mailSSLSocketFactory = new MailSSLSocketFactory();
            mailSSLSocketFactory.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", mailSSLSocketFactory);
            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MailConfig.MAILACCOUNT,MailConfig.MAILPASSWORD);
                }
            });
            mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(MailConfig.MAILACCOUNT));
            mimeMessage.addRecipients(Message.RecipientType.TO,toSendAddress);
            mimeMessage.setSubject("-- -- -- -- -- -- -- --");
            mimeMessage.setText(toMessage);
            Transport.send(mimeMessage);
            System.err.println("sending...");
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
