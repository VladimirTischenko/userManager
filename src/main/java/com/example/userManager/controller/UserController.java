package com.example.userManager.controller;

import com.example.userManager.dao.User;
import com.example.userManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserController.REST_URL)
public class UserController {
    static final String REST_URL = "/users";
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path="/all")
    public Iterable<User> getAll() {
        return service.getAll();
    }

    @GetMapping(path="/{id}")
    public User get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping()
    public User addNew(@RequestBody User user) {
        return service.save(user);
    }
}
