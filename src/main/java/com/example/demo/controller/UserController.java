package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api/v1/user")
@RestController
@CrossOrigin

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<UserDTO> getuser() {
        return userService.getallusers();
    }

    @PostMapping("/saveuser")
    public UserDTO saveuser(@RequestBody UserDTO userDTO) {

        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateuser")
    public UserDTO updateuser(@RequestBody UserDTO userDTO) {

        return userService.updateuser(userDTO);
    }

    @DeleteMapping("/deleteuser")
    public boolean deleteuser(@RequestBody UserDTO userDTO) {

        return userService.deleteuser(userDTO);
    }

    @GetMapping("/getuserbyuserid/{userid}")
    public UserDTO getuserbyuserid(@PathVariable String userid) {
        return userService.getuserbyid(userid);
    }

    @GetMapping("/getuserbyuseridaddress/{userid}/{address}")
    public UserDTO getuserbyidaddress(@PathVariable String userid, @PathVariable String address) {
        System.out.println(userid + " " + address);
        return userService.getuserbyidaddress(userid, address);
    }


}
