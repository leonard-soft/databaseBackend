package university.jala.databaseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import university.jala.databaseApp.components.JwtUtil;
import university.jala.databaseApp.entities.AuthRequest;
import university.jala.databaseApp.entities.AuthResponse;
import university.jala.databaseApp.entities.User;
import university.jala.databaseApp.repositories.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse authenticate(AuthRequest authRequest) {
        User user = userRepository.findByUsername(authRequest.getUsername());

        if (user == null) {
            System.out.println("user not found");
            throw new BadCredentialsException("User not found");
        }

        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            System.out.println("password incorrect");
            throw new BadCredentialsException("Incorrect password");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token, user.getFirstName(), user.getLastName(), user.getBirthDate());
    }
}
