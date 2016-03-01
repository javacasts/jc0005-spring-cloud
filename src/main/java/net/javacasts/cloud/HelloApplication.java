package net.javacasts.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloApplication {

    @Value("${hello.text}")
    private String message;

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return message;
    }
}
