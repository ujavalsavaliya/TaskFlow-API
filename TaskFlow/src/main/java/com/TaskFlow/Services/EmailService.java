package com.TaskFlow.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String subject, String description, String email, String userName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ujavalsavaliya@gmail.com"); // Ideally use properties config
        message.setTo(email);

        String sub = "Task Assignment Notification";

        String body = "Dear " + userName + ",\n\n"
                + "   We are pleased to inform you that a new project has been assigned to you.\n\n"
                + "Project Details:\n\n"
                + description + "\n\n"
                + "    We trust that you will approach this project with dedication and deliver your best performance.\n"
                + "    If you have any questions or require additional details, please feel free to reach out to your project manager.\n\n"
                + "Best regards, \n"
                + "The TaskFlow Team";

        message.setSubject(sub + " : " + subject);
        message.setText(body);
        javaMailSender.send(message);
    }
}
