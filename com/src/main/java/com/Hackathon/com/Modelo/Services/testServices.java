/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Services;

import com.Hackathon.com.Modelo.Test;
import com.Hackathon.com.Modelo.Repository.testRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author calix
 */
@Service
public class testServices {

    @Autowired
    private testRepository metodosCrud;

    public List<Test> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Test> getTest(int id) {
        return metodosCrud.getTest(id);
    }

    public Test save(Test test) {
        if (test.getId() == null) {
            return metodosCrud.save(test);
        } else {
            Optional<Test> evt = metodosCrud.getTest(test.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(test);
            } else {
                return test;
            }

        }

    }

    public Test update(Test test) {
        if (test.getId() != null) {
            return metodosCrud.save(test);
        } else {
            Optional<Test> e = metodosCrud.getTest(test.getId());
            if (!e.isEmpty()) {
                if (test.getDifficulty() != null) {
                    e.get().setDifficulty(test.getDifficulty());
                }
                if (test.getQuality() != null) {
                    e.get().setQuality(test.getQuality());
                }
                if (test.getScore() != 0.0) {
                    e.get().setScore(test.getScore());
                }
                if (test.getUser() != null) {
                    e.get().setUser(test.getUser());
                }
                return e.get();
            } else {
                return test;
            }
        }
    }

    public boolean deleteTest(int id) {
        Boolean aBoolean = getTest(id).map(test -> {
            metodosCrud.delete(test);
            return true;
        }).orElse(aBoolean = false);
        return aBoolean;
    }
}
