package com.mail.SpringMailApi.controller;

import com.mail.SpringMailApi.dto.MailRequest;
import com.mail.SpringMailApi.dto.MailResponse;
import com.mail.SpringMailApi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MailController {
    @Autowired private EmailService emailService;

    @PostMapping(value = "/sendEmail")
    public MailResponse sendEmail(@RequestBody MailRequest request){
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());
        model.put("Location", "Noida");
        return emailService.sendEmail(request, model);
    }
}