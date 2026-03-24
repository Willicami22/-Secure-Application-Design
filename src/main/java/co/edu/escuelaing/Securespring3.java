package co.edu.escuelaing;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import org.springframework.boot.SpringApplication;

@SpringBootApplication//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Securespring3 {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Securespring3.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", 5000));
        app.run(args);
    }
}

