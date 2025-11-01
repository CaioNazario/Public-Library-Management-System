package com.example.library_api.service;
import com.example.library_api.DTO.UserRequest;
import com.example.library_api.model.User;
import com.example.library_api.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userRequest) {

        if (userRepository.findByEmail(userRequest.email()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        if (userRepository.findByEmail(userRequest.CPF()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
        User user = new User();

        user.setPassword(userRequest.password());
        user.setUserName(userRequest.name());
        user.setEmail(userRequest.email());

        User savedUser = userRepository.save(user);
        return savedUser;

    }
}