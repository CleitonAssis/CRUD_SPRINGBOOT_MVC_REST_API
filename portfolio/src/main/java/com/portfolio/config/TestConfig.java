package com.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.portfolio.repositories.UserRepository;
import com.portfolio.entities.User;

import java.util.Arrays;

@Component
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
