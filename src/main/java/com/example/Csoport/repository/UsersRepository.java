package com.example.Csoport.repository;

import com.example.Csoport.domain.Users;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    @Override
    List<Users> findAll();

    Users findByEmail(String email);
    Users findByUsername(String username);
    Users findByUsernameAndPassword(String username, String password);

}
