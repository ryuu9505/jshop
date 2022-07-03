package com.example.jshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * example : API for user management
     */

    // read all users: GET /users
    @GetMapping
    public String findAll() {
        return "FOUND";
    }

    // create: POST /users
    @PostMapping
    public String add() {
        return "ADDED";
    }

    // read a user: GET /users/{userId}
    @GetMapping("/{userId}")
    public String findById(@PathVariable String userId) {
        return userId + " FOUND";
    }

    // update: PATCH /users/{userId}
    @PatchMapping("/{userId}")
    public String updateById(@PathVariable String userId) {
        return userId + " UPDATED";
    }

    // delete: DELETE /users/{userId}
    @DeleteMapping("/{userId}")
    public String deleteById(@PathVariable String userId) {
        return userId + " DELETED";
    }

}
