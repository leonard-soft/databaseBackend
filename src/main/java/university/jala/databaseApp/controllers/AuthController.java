package university.jala.databaseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.jala.databaseApp.entities.AuthRequest;
import university.jala.databaseApp.entities.AuthResponse;
import university.jala.databaseApp.services.AuthService;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        try {
            AuthResponse authResponse = authService.authenticate(authRequest);
            return ResponseEntity.ok(authResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse(e.getMessage()));
        }
    }
}