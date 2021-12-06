/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Web;

import com.Hackathon.com.Modelo.Services.testServices;
import com.Hackathon.com.Modelo.Test;
import com.Hackathon.com.Modelo.TestQuestion;
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
@RequestMapping("/api/test")
@CrossOrigin("*")
public class testWeb {
    @Autowired
    private testServices servicios;

    @GetMapping("/all")
    public List<Test> getAll() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Test getTest(@PathVariable Integer id) {
        return servicios.getTest(id).orElse(null);
    }
    
    @GetMapping("/Score")
    public List<Test> ScoreDesc() {
        return servicios.ScoreDesc();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Test> save(@RequestBody Test test) throws Exception {
        Test u = servicios.save(test);

        return new ResponseEntity(u, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity update(@RequestBody Test test) {
        Test u = servicios.update(test);

        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable("id") int Id) {
        servicios.deleteTest(Id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
