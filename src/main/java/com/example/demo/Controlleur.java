package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Controlleur {
    @Autowired
    private UserRepo userRepo;


    @PostMapping("/register")
    public String Register(@RequestBody User user){
        this.userRepo.save(user);
        return "Hi"+ user.getName() +" your Registration process successfully completed";
    }

    @GetMapping("/getAllUsers")
    public List<User> findAllUsers(){

        return userRepo.findAll();
    }
    @GetMapping("/findUser/{email}")
    public List<User> findUser(@PathVariable String email) {
        return userRepo.findByEmailContains(email);
    }




    @DeleteMapping("/cancel/{id}")
    public  List<User>  Delete(@PathVariable int id){
        userRepo.deleteById(id);
        return  userRepo.findAll();

    }
}
