package university.jala.databaseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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




}
