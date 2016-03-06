package net.javacasts.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class InterceptApplication {

    @Autowired
    private RestTemplate restTemplate;

    private static final DateFormat dateFormat = new SimpleDateFormat(
            "HH:mm:ss");

    public static void main(String[] args) {
        SpringApplication.run(InterceptApplication.class, args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMessage() {
        return dateFormat.format(new Date()) + ": "
                + restTemplate.getForObject("http://hello/", String.class);
    }
}
