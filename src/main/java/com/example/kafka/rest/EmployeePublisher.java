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
@RequestMapping("/emp")
public class EmployeePublisher {

    @Autowired
    private MessageChannel output;

    @PostMapping()
    public Employee emp(@RequestBody Employee emp) {

        output.send(MessageBuilder.withPayload(emp).build());
        return emp;
    }

}
