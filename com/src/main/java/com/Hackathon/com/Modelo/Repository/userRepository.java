/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Repository;

import com.Hackathon.com.Modelo.Interfaz.userInterfaz;
import com.Hackathon.com.Modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author calix
 */
@Repository
public class userRepository {
     @Autowired
    private userInterfaz crud;

    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }

    public Optional<User> getUser(int id) {
        return crud.findById(id);
    }

    public User save(User user) {
        return crud.save(user);
    }

    //DELETE
    public void delete(User user) {
        crud.delete(user);
    }
}
