package com.example.storedatademo.controller;

import com.example.storedatademo.model.Task;
import com.example.storedatademo.model.User;
import com.example.storedatademo.service.TaskService;
import com.example.storedatademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody User user){
        return ResponseEntity.ok( userService.saveUser(user));
    }


    @GetMapping("/:{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }


    @GetMapping("")
    public ResponseEntity<?> getAll(){
            return ResponseEntity.ok(userService.getAllUsers());
    }



    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody User user){
        return ResponseEntity.ok(userService.editUser(user));
    }


    @DeleteMapping("/:{id}")
    public String delete(@PathVariable Long id){
        userService.deleteUser(id);
        return "deleted";
    }


}
