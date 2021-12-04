/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Services;

import com.Hackathon.com.Modelo.Question;
import com.Hackathon.com.Modelo.Repository.questionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author calix
 */
@Service
public class questionServices {

    @Autowired
    private questionRepository metodosCrud;

    public List<Question> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Question> getQuestion(int id) {
        return metodosCrud.getQuestion(id);
    }

    public Question save(Question question) {
        if (question.getId() == null) {
            return metodosCrud.save(question);
        } else {
            Optional<Question> evt = metodosCrud.getQuestion(question.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(question);
            } else {
                return question;
            }

        }

    }

    public Question update(Question question) {
        if (question.getId() != null) {
            return metodosCrud.save(question);
        } else {
            Optional<Question> e = metodosCrud.getQuestion(question.getId());
            if (!e.isEmpty()) {
                if (question.getDescription()!= null) {
                    e.get().setDescription(question.getDescription());
                }
                if (question.getA()!= null) {
                    e.get().setA(question.getA());
                }
                if (question.getB()!= null) {
                    e.get().setB(question.getB());
                }
                if (question.getC()!= null) {
                    e.get().setC(question.getC());
                }
                if (question.getAnswer()!= null) {
                    e.get().setAnswer(question.getAnswer());
                }
                if (question.getReview()!= null) {
                    e.get().setAnswer(question.getReview());
                }
                return e.get();
            } else {
                return question;
            }
        }
    }

    public boolean deleteQuestion(int id) {
        Boolean aBoolean = getQuestion(id).map(question -> {
            metodosCrud.delete(question);
            return true;
        }).orElse(aBoolean = false);
        return aBoolean;
    }
}

