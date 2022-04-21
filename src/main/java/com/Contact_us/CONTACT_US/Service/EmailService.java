package com.Contact_us.CONTACT_US.Service;


import com.Contact_us.CONTACT_US.Model.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender)
    {
        this.javaMailSender= javaMailSender;
    }
    public void sendmail(String toEmail , String subject , String message)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
       mailMessage.setTo(toEmail);
       mailMessage.setSubject(subject);
       mailMessage.setText(message);
       javaMailSender.send(mailMessage);
    }
}
