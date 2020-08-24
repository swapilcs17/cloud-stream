package com.example.kafka;

import com.example.kafka.model.Employee;
import example.avro.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;


@SpringBootApplication
@EnableBinding({Source.class, Sink.class})
public class CloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamApplication.class, args);
	}

	@StreamListener("input")
	public void consumeMessage(Employee emp) {
		System.out.println(emp);
	}

	@StreamListener("input")
	public void consumeMessageAvro(User user) {
		System.out.println(user);
	}

}
