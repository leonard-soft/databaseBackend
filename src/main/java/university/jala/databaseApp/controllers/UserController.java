package university.jala.databaseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.jala.databaseApp.Dto.UserDto;
import university.jala.databaseApp.services.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/findAll")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/findById/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

//    @PostMapping("/users/save")
//    public UserDto save(@RequestBody SaveUserDto saveUserDto) {
//        return userService.save(saveUserDto);
//    }

//    @PostMapping("/mail/validate/email")
//    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
//        emailService.sendVerificationEmail(userDto.getEmail());
//        return new ResponseEntity<>("User created successfully. Please check your email to verify your account.", HttpStatus.OK);
//    }

    @PutMapping("/users/update/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        return userService.update(userDto, id);
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
