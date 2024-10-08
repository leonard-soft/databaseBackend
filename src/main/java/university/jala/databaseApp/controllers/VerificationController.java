package university.jala.databaseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import university.jala.databaseApp.Dto.SaveUserDto;
import university.jala.databaseApp.Dto.UserDto;
import university.jala.databaseApp.Dto.VerificationCodeDto;
import university.jala.databaseApp.services.UserService;

import java.util.HashMap;

@PropertySource("application.properties")
@RestController
public class VerificationController {

    @Autowired
    UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    HashMap<String, SaveUserDto> temporaryUsers = new HashMap<>();

    @PostMapping("/registry/user")
    public ResponseEntity<String> registerUser(@RequestBody SaveUserDto userDto) {
        String code = java.util.UUID.randomUUID().toString();
        temporaryUsers.put(code, userDto);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userDto.getEmail());
        message.setSubject("verification email");
        message.setText(code);
        message.setFrom("${spring.mail.username}");
        mailSender.send(message);
        return ResponseEntity.ok("Your verification code has been generated");
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestBody VerificationCodeDto verificationCodeDto) {
        SaveUserDto userDto = temporaryUsers.get(verificationCodeDto.getVerificationCode());
        if (userDto != null) {
            System.out.println(userDto.getEmail());
            userService.save(userDto);
            temporaryUsers.remove(verificationCodeDto.getVerificationCode());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
