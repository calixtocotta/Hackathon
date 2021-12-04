/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Web;

import com.Hackathon.com.Modelo.Services.questionServices;
import com.Hackathon.com.Modelo.Question;
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
@RequestMapping("/api/question")
@CrossOrigin("*")
public class questionWeb {
    
    @Autowired
    private questionServices servicios;

    @GetMapping("/all")
    public List<Question> getAll() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Integer id) {
        return servicios.getQuestion(id).orElse(null);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Question> save(@RequestBody Question question) throws Exception {
        Question u = servicios.save(question);

        return new ResponseEntity(u, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity update(@RequestBody Question question) {
        Question u = servicios.update(question);

        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable("id") int Id) {
        servicios.deleteQuestion(Id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
