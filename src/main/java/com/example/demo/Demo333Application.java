package com.example.demo;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class Demo333Application implements CommandLineRunner {
    @Autowired
    UserRepo userrepo ;

    public static void main(String[] args) {
        SpringApplication.run(Demo333Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Random rnd = new Random();
        for (int i = 0 ; i < 6 ; i++){
            User user = new User();
            user.setName(RandomString.make(5));
            user.setDomain(RandomString.make(8));
            user.setEmail(RandomString.make(8));
            user.setExperience(12+ rnd.nextInt(12));
            userrepo.save(user);
        }
    }
}
