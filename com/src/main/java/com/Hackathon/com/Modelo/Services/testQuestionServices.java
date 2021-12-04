/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Services;

import com.Hackathon.com.Modelo.Repository.testQuestionRepository;
import com.Hackathon.com.Modelo.TestQuestion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author calix
 */
@Service
public class testQuestionServices {

    @Autowired
    private testQuestionRepository metodosCrud;

    public List<TestQuestion> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<TestQuestion> getTestQuestion(int id) {
        return metodosCrud.getTestQuestion(id);
    }

    public TestQuestion save(TestQuestion testQuestion) {
        if (testQuestion.getId() == null) {
            return metodosCrud.save(testQuestion);
        } else {
            Optional<TestQuestion> evt = metodosCrud.getTestQuestion(testQuestion.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(testQuestion);
            } else {
                return testQuestion;
            }

        }

    }

    public TestQuestion update(TestQuestion testQuestion) {
        if (testQuestion.getId() != null) {
            return metodosCrud.save(testQuestion);
        } else {
            Optional<TestQuestion> e = metodosCrud.getTestQuestion(testQuestion.getId());
            if (!e.isEmpty()) {
                if (testQuestion.getAnswer()!= 0.0) {
                    e.get().setAnswer(testQuestion.getAnswer());
                }
                if (testQuestion.getQuestion()!= null) {
                    e.get().setQuestion(testQuestion.getQuestion());
                }
                if (testQuestion.getTest()!= null) {
                    e.get().setTest(testQuestion.getTest());
                }
                return e.get();
            } else {
                return testQuestion;
            }
        }
    }

    public boolean deleteTestQuestion(int id) {
        Boolean aBoolean = getTestQuestion(id).map(testQuestion -> {
            metodosCrud.delete(testQuestion);
            return true;
        }).orElse(aBoolean = false);
        return aBoolean;
    }
}
