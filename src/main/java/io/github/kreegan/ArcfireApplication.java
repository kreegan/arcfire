package io.github.kreegan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ArcfireApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArcfireApplication.class, args);
    }
}
