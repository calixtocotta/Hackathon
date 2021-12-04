/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Web;

import com.Hackathon.com.Modelo.Services.userServices;
import com.Hackathon.com.Modelo.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author calix
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class userWeb {

    @Autowired
    private userServices servicios;

    @GetMapping("/all")
    public List<User> getAll() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return servicios.getUser(id).orElse(null);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> save(@RequestBody User user) throws Exception {
        User u = servicios.save(user);

        return new ResponseEntity(u, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity update(@RequestBody User user) {
        User u = servicios.update(user);

        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable("id") int Id) {
        servicios.deleteUser(Id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
