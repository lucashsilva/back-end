package com.github.sadufcg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Antunes Dantas on 17/03/17.
 */
public class MailServerServiceImpl implements MailServerService {

    JavaMailSender mailSender;

    @Value("${mail.reply.adress}")
    private String replyMailAdress;

    @Value("${mail.subject}")
    private String subject;

    @Autowired
    public MailServerServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String recipient, String mailBody) {
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(recipient);
            helper.setReplyTo(replyMailAdress);
            helper.setFrom(replyMailAdress);
            helper.setSubject(subject);
            helper.setText(mailBody);
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {}
        mailSender.send(mail);
    }

}