package com.example.bookstoreproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class JMSMailSender {

    @Autowired
    JavaMailSender javaMailSender;

    public void mailSender(String toMail,String subject,String data){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nicenaveengorakala@gmail.com");
        message.setTo(toMail);
        message.setSubject(subject);
        message.setText(data);
        javaMailSender.send(message);
    }
}
