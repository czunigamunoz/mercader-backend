package com.ecommerce.app.controllers;

import com.ecommerce.app.model.User;
import com.ecommerce.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Represents a user controller
 * @version 1.0
 * @author czm
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

    /**
     * Represents user service to connect with repository
     */
    @Autowired
    private UserService service;

    /**
     * Return a list of users on database
     * @return A list representing users
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }

    /**
     * Return a user
     * @param email String email's user
     * @param password String password's user
     * @return User with these credentials
     */
    @GetMapping("{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.authUser(email, password);
    }

    /**
     * Return true if exits or false if not
     * @param email String email's user
     * @return Boolean
     */
    @GetMapping("/emailexist/{email}")
    public  boolean existEmail(@PathVariable("email") String email){
        return service.existEmail(email);
    }

    /**
     * Function to create a user
     * @param user User
     * @return user created
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User signUp(@RequestBody User user){
        return service.save(user);
    }

    /**
     * Function to update a user
     * @param user User
     * @return User updated or if already exists on database return same data that receives
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }
}
