/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Repository;

import com.Hackathon.com.Modelo.Interfaz.testQuestionInterfaz;
import com.Hackathon.com.Modelo.TestQuestion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author calix
 */
@Repository
public class testQuestionRepository {

    @Autowired
    private testQuestionInterfaz crud;

    public List<TestQuestion> getAll() {
        return (List<TestQuestion>) crud.findAll();
    }

    public Optional<TestQuestion> getTestQuestion(int id) {
        return crud.findById(id);
    }

    public TestQuestion save(TestQuestion testQuestion) {
        return crud.save(testQuestion);
    }

    //DELETE
    public void delete(TestQuestion testQuestion) {
        crud.delete(testQuestion);
    }
}
