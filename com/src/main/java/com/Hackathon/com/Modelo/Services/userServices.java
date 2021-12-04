/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Services;

import com.Hackathon.com.Modelo.Repository.userRepository;
import com.Hackathon.com.Modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author calix
 */
@Service
public class userServices {

    @Autowired
    private userRepository metodosCrud;

    public List<User> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<User> getUser(int id) {
        return metodosCrud.getUser(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
            return metodosCrud.save(user);
        } else {
            Optional<User> evt = metodosCrud.getUser(user.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(user);
            } else {
                return user;
            }

        }

    }

    public User update(User user) {
        if (user.getId() != null) {
            return metodosCrud.save(user);
        } else {
            Optional<User> e = metodosCrud.getUser(user.getId());
            if (!e.isEmpty()) {
                if (user.getName()!= null) {
                    e.get().setName(user.getName());
                }
                if (user.getIdentification()!= null) {
                    e.get().setIdentification(user.getIdentification());
                }
                if (user.getCellPhone()!= null) {
                    e.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail()!= null) {
                    e.get().setEmail(user.getEmail());
                }
                if (user.getPassword()!= null) {
                    e.get().setPassword(user.getPassword());
                }
                if (user.getAge()!= 0) {
                    e.get().setAge(user.getAge());
                }
                if (user.getTest()!= null) {
                    e.get().setTest(user.getTest());
                }
                return e.get();
            } else {
                return user;
            }
        }
    }

    public boolean deleteUser(int id) {
        Boolean aBoolean = getUser(id).map(user -> {
            metodosCrud.delete(user);
            return true;
        }).orElse(aBoolean = false);
        return aBoolean;
    }
}
