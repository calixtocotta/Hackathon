/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Web;


import com.Hackathon.com.Modelo.Services.testQuestionServices;
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
@RequestMapping("/api/testQuestion")
@CrossOrigin("*")
public class testQuestionWeb {

    @Autowired
    private testQuestionServices servicios;

    @GetMapping("/all")
    public List<TestQuestion> getAll() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public TestQuestion getTestQuestion(@PathVariable Integer id) {
        return servicios.getTestQuestion(id).orElse(null);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TestQuestion> save(@RequestBody TestQuestion testQuestion) throws Exception {
        TestQuestion u = servicios.save(testQuestion);

        return new ResponseEntity(u, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity update(@RequestBody TestQuestion testQuestion) {
        TestQuestion u = servicios.update(testQuestion);

        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable("id") int Id) {
        servicios.deleteTestQuestion(Id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
