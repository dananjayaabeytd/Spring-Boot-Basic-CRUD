package com.example.demo.service;


import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelmapper;
    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelmapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getallusers(){
        List <User> userslist = userRepo.findAll();
        return modelmapper.map(userslist, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateuser(UserDTO userDTO){
        userRepo.save(modelmapper.map(userDTO,User.class));
        return userDTO;
    }

    public boolean deleteuser(UserDTO userDTO){
        userRepo.delete(modelmapper.map(userDTO,User.class));
        return true;
    }

    //user id -> userdetails
    // select * from user where id = 1
    public UserDTO getuserbyid(String userid){
        User user = userRepo.getuserbyuserid(userid);
        return modelmapper.map(user,UserDTO.class);
    }

    //user id ,address > userdetails
    //select * from where id = 1 and address = "kandy"
    public UserDTO getuserbyidaddress(String userid,String useraddress){
        User user = userRepo.getuserbyidaddress(userid,useraddress);
        return modelmapper.map(user,UserDTO.class);
    }
}
