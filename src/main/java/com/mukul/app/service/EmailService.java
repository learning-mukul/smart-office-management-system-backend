package com.mukul.app.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class EmailService {

    private JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine){
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    public void sendWelcomeMail(String toEmail, String name) throws MessagingException {
        Context context = new Context();
        context.setVariable("name",name);
        context.setVariable("email",toEmail);

        String htmlContent = templateEngine.process("welcome-mail",context);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(toEmail);
        helper.setSubject("Welcome to Smart Office");
        helper.setText(htmlContent,true); // true= html

        mailSender.send(mimeMessage);

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(toEmail);
//        message.setSubject("Welcome to Smart Office");
//        message.setText("Dear, Welcome to the company");
//        mailSender.send(message);

    }
}
