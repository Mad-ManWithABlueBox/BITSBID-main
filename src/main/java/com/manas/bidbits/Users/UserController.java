package com.manas.bidbits.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/")
    public Iterable<UserModel> hello() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{userId}")
    public UserModel getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(path = "/")
    public UserModel addUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @PostMapping(path = "/check")
    public Boolean checkUser(@RequestParam Long userId) {
        UserModel user = userService.getUserById(userId);
        return user != null;
    }

    @PostMapping(path = "/setHostel")
    public UserModel setHostel(@RequestParam Long userId, @RequestParam String hostel) {
        return userService.setHostel(userId, hostel);
    }

    @PostMapping(path = "/setCampusId")
    public UserModel setCampusId(@RequestParam Long userId, @RequestParam String campusId) {
        return userService.setCampusId(userId, campusId);
    }

    @PostMapping(path = "/setPhone")
    public UserModel setPhone(@RequestParam Long userId, @RequestParam String phone) {
        return userService.setPhone(userId, phone);
    }
}
