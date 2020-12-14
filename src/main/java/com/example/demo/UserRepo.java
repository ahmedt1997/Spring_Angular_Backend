package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface UserRepo extends JpaRepository<User,Integer> {

    @RestResource(path = "/selectBynom")
    public List<User> findByNameContains(@Param("nom") String nom);

    @RestResource(path = "/selectedBydomain")
    public List<User> findByDomainContains(@Param("domain") String domain);

    @RestResource(path = "/selectedByemail")
    public List<User> findByEmailContains(@Param("email") String email);

    /*to run this methode all that you can do  is just tape in url :
    http://localhost:8080/users/search/selectedByemail?email=[nom email]
    */



    //Register


}
