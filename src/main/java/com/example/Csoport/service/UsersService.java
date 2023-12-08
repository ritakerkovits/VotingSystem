package com.example.Csoport.service;

import com.example.Csoport.domain.Users;
import com.example.Csoport.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    private void setUsersRepository(UsersRepository ur) {this.usersRepository = ur;}

    public void saveUser(Users user){
        usersRepository.save(user);
    }

    private List<Users> getUsers(){
       List<Users> users = usersRepository.findAll();

        return users;
    }

    public boolean checkUser(String username, String password){
        if(usersRepository.findByUsernameAndPassword(username, password)==null){
            return false;
        }
        return true;
    }






}
