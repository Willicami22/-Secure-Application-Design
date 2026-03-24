package co.edu.escuelaing.controller;

import co.edu.escuelaing.dto.LoginRequest;
import co.edu.escuelaing.dto.LoginResponse;
import co.edu.escuelaing.security.JwtUtil;
import co.edu.escuelaing.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        boolean valid = userService.authenticate(
                request.getUsername(),
                request.getPassword()
        );

        if (valid) {
            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(
                    new LoginResponse(true, "Login exitoso. Bienvenido, " + request.getUsername(), token)
            );
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(false, "Usuario o contraseña incorrectos", null));
        }
    }
}