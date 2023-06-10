package com.codeup.codeupspringblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.codeup.codeupspringblog.models.Post;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Post post, String subject, String body){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("jj@gov.com");
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        try{
            this.mailSender.send(msg);
        } catch (MailException ex){
            System.out.println(ex.getMessage());
        }
    }
}
