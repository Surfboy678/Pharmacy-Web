package com.brodacki.janusz.pharmacy.email.service;

import com.brodacki.janusz.pharmacy.email.model.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    private JavaMailSender javaMailSender;

    @Autowired
    public SimpleEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(final Mail mail){
        LOGGER.info("Starting email preparation");
        try {
            javaMailSender.send(createMailMessage(mail));
            LOGGER.info("Email has been sent");

        }catch (MailException e){
            LOGGER.error("Failed to process mail sending", e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMailMessage(final Mail mail){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mail.getMailTo());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getMessage());
        return simpleMailMessage;

    }

}
