package com.ceyntra.chatserver.repository;

import com.ceyntra.chatserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u.userType from User u where u.userId =: userID")
    int getUserTypeByUserId(@Param("userID") int userID);

    @Query("select u.isLoggedIn from User u where u.userId=:userId")
    int getLoginStatusByUserId(@Param("userId") int userId);

}
