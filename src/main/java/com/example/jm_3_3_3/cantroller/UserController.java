package com.example.jm_3_3_3.cantroller;

import com.example.jm_3_3_3.exception.UserNotFoundException;
import com.example.jm_3_3_3.model.User;
import com.example.jm_3_3_3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "/")
    public ResponseEntity<String> Hello() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers().toString());
    }

    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestParam String name, @RequestParam String lastName, @RequestParam String email) {
        User user = new User(name, lastName, email);
        return ResponseEntity.ok(userService.addUser(user).toString());
    }
    @GetMapping("/find")
    public ResponseEntity<String> find(@RequestParam Long id) {
        return ResponseEntity.ok(userService.findUser(id).toString());
    }
    @GetMapping("/update")
    public ResponseEntity<String> update(@RequestParam String name, @RequestParam String lastName, @RequestParam String email) {
        User user = new User(name, lastName, email);
        return ResponseEntity.ok(userService.updateUser(user).toString());
    }

    @GetMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> studentNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }
}
