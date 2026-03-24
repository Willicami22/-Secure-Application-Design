package co.edu.escuelaing.controller;

import co.edu.escuelaing.dto.LoginRequest;
import co.edu.escuelaing.dto.LoginResponse;
import co.edu.escuelaing.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        boolean valid = userService.authenticate(
                request.getUsername(),
                request.getPassword()
        );

        if (valid) {
            return ResponseEntity.ok(
                    new LoginResponse(true, "Login exitoso. Bienvenido, " + request.getUsername())
            );
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(false, "Usuario o contraseña incorrectos"));
        }
    }
}