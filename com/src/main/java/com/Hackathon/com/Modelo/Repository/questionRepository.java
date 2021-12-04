/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Repository;

import com.Hackathon.com.Modelo.Interfaz.questionInterfaz;
import com.Hackathon.com.Modelo.Question;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author calix
 */
@Repository
public class questionRepository {

    @Autowired
    private questionInterfaz crud;

    public List<Question> getAll() {
        return (List<Question>) crud.findAll();
    }

    public Optional<Question> getQuestion(int id) {
        return crud.findById(id);
    }

    public Question save(Question question) {
        return crud.save(question);
    }

    //DELETE
    public void delete(Question question) {
        crud.delete(question);
    }
}
