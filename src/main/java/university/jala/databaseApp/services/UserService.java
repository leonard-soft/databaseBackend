package university.jala.databaseApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import university.jala.databaseApp.Dto.SaveUserDto;
import university.jala.databaseApp.Dto.UserDto;
import university.jala.databaseApp.entities.User;
import university.jala.databaseApp.repositories.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDto convertToUserDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(),  user.getUsername());
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::convertToUserDto).toList();
    }

    public UserDto findById(Long id) {
        UserDto userDto = new UserDto();
        Optional<User> user = userRepository.findById(id);
        userDto = user.map(this::convertToUserDto).orElse(null);
        return userDto;
    }

    public UserDto save(SaveUserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user = userRepository.save(user);
        return convertToUserDto(user);
    }

    public UserDto update(UserDto userDto, Long id) {
        UserDto updatedUserDto = new UserDto();
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User databaseUser = user.get();
            databaseUser.setFirstName(userDto.getFirstName());
            databaseUser.setLastName(userDto.getLastName());
            databaseUser.setEmail(userDto.getEmail());
            databaseUser.setAge(userDto.getAge());
            databaseUser.setUsername(userDto.getUsername());
            userRepository.save(databaseUser);
            updatedUserDto = convertToUserDto(databaseUser);
        } else {
            updatedUserDto = null;
        }
        return updatedUserDto;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
