package com.example.SpringBoot_HW2.service;

import com.example.SpringBoot_HW2.exception.UserNotFoundException;
import com.example.SpringBoot_HW2.model.User;
import com.example.SpringBoot_HW2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        log.info("Get user with id: {}", id);
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        log.info("Create new user: {}", user);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        log.info("Updating User with id: {}", id);
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setLastName(updatedUser.getLastName());
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    user.setAge(updatedUser.getAge());
                    log.info("User updated: {}", user);
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }
}
