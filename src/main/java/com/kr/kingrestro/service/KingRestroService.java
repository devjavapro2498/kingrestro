package com.kr.kingrestro.service;

import com.kr.kingrestro.entity.BookingEntity;
import com.kr.kingrestro.repository.KingRestroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class KingRestroService {
    @Autowired
    KingRestroRepo kingRestroRepo;

    public void addEmp(BookingEntity bookingEntity) {
        kingRestroRepo.save(bookingEntity);
        System.out.println("Prepare to Send Message");
        String message="HI"+"/"+ bookingEntity.getName()+
                "Thank you for Booking .Your Booking is Confirmed for 7 Star King Restaurant . Our CEO Mr. Mohit  welcome you because   you're very Special guest so we will provide you great service." +
                "Thank you" +
                "BooKing Time:" +bookingEntity.getDatetime() + "Customer Name: " +bookingEntity.getName()+ "No of People: " +bookingEntity.getNoOfPeople();
        String subject ="KingRestro: Confirmation";
        String to =bookingEntity.getEmail();
        String from = "cultivatejava@gmail.com";
        sendEmail(message,subject,to,from);
    }

    private static void sendEmail(String message, String subject, String to, String from) {
        //varianle for gmail host
        String host ="smtp.gmail.com";
        Properties properties= System.getProperties();
        System.out.println("PROPERTIES" +properties);
        //Setting Important info to properties object
        //host set
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        //Step :1 To get the Session Object
        Session session= Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("cultivatejava@gmail.com" ,"***********");
            }
        });
//Compose the message
        session.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            //from email
            mimeMessage.setFrom(from);
            mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);
            // Step:3  Send
            Transport.send(mimeMessage);
            System.out.println("Successfully Send");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

