package co.edu.escuelaing.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecureController {

    @GetMapping("/secure")
    public String secureEndpoint(Authentication authentication) {
        return "Hello, " + authentication.getName() + "! This is a protected resource.";
    }
}
