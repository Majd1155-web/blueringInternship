package com.example.blueringInternship.controller;

import com.example.blueringInternship.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("createUsers")
    @ResponseStatus(HttpStatus.OK)
    public String CreateUser(@RequestBody Map<String, Object> usersDTO) {
        usersService.CreateUser(usersDTO);
        return "User created successfully";
    }

    @GetMapping({"getUsers"})
    @ResponseStatus(HttpStatus.OK)
    public List<?> getUsers() {
        return usersService.GetUsers();
    }

    @GetMapping({"getUsersById/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<?> getUsersById(@PathVariable Integer id) {
        return usersService.GetUsersById(id);
    }

    @PatchMapping("updateUsers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpdateUser(@PathVariable Integer id, @RequestBody Map<String, Object> usersDTO) {
        usersService.UpdateUser(id, usersDTO);
        return "User updated successfully";
    }

    @DeleteMapping("deleteUsers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String DeleteUser(@PathVariable Integer id) {
        usersService.DeleteUser(id);
        return "User deleted successfully";
    }


}
