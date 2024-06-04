package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value ="select * from user where id=?1",nativeQuery = true)
    User getuserbyuserid(String userid);
    @Query(value ="select * from user where id=?1 and address=?2",nativeQuery = true)
    User getuserbyidaddress(String userid,String useraddress);

    //when using update query
    //@Modifying
    //@query(value="update ....

}
