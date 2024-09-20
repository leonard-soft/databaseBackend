package university.jala.databaseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.jala.databaseApp.Dto.UserDto;
import university.jala.databaseApp.entities.User;
import university.jala.databaseApp.repositories.UserRepository;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDto convertToUserDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getAge(), user.getUsername());
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::convertToUserDto).toList();
    }


}
