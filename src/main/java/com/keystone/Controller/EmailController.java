package com.keystone.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keystone.DTO.EmailLogsDTO;
import com.keystone.Security.EmailService;

//@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/resetPasswordEmail")
    public ResponseEntity<String> sendResetPasswordEmail(
            @RequestParam String to,
            @RequestParam String token) {

        emailService.sendResetPasswordLink(to, token);

        return ResponseEntity.ok("Reset Password link sent over on your Email");
    }

    @PostMapping("/notify")
    public ResponseEntity<String> notification(
            @RequestBody EmailLogsDTO emailLog) {

        String result = emailService.notify(emailLog);

        return ResponseEntity.ok(result);
    }
}