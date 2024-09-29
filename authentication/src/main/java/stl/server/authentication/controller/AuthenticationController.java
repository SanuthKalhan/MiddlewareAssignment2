package stl.server.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stl.server.authentication.entity.User;
import stl.server.authentication.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestParam String phoneNumber, @RequestParam String password) {
        User user = userService.registerUser(phoneNumber, password);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String phoneNumber, @RequestParam String password) {
        Optional<User> user = userService.authenticateUser(phoneNumber, password);
        if (user.isPresent()) {
            // Generate JWT token here (not implemented in this example)
            return ResponseEntity.ok("Login successful! Token: ...");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid phone number or password.");
    }
}
