package com.example.kafka.rest;

import com.example.kafka.model.Employee;
import example.avro.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avro")
public class AvroPublisher {

    @Autowired
    private MessageChannel output;

    @PostMapping()
    public User user(@RequestBody User user) {

        output.send(MessageBuilder.withPayload(user).build());
        return user;
    }
}
