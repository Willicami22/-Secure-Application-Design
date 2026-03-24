package co.edu.escuelaing.service;

import co.edu.escuelaing.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // "Base de datos" en memoria
    private final Map<String, User> users = new HashMap<>();

    public UserService() {
        // Usuarios precargados con contraseñas YA hasheadas
        // Nunca guardamos la contraseña en texto plano
        register("admin", "admin123");
        register("estudiante", "eci2024");
    }

    public void register(String username, String plainPassword) {
        String hash = encoder.encode(plainPassword);
        users.put(username, new User(username, hash));
    }

    public boolean authenticate(String username, String plainPassword) {
        User user = users.get(username);
        if (user == null) return false;
        // BCrypt compara el texto plano con el hash almacenado
        return encoder.matches(plainPassword, user.getPasswordHash());
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }
}
