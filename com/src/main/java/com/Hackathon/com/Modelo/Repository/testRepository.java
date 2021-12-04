/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Repository;

import com.Hackathon.com.Modelo.Interfaz.testInterfaz;
import com.Hackathon.com.Modelo.Test;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author calix
 */
@Repository
public class testRepository {
    
     @Autowired
    private testInterfaz crud;

    public List<Test> getAll() {
        return (List<Test>) crud.findAll();
    }

    public Optional<Test> getTest(int id) {
        return crud.findById(id);
    }

    public Test save(Test test) {
        return crud.save(test);
    }

    //DELETE
    public void delete(Test test) {
        crud.delete(test);
    }
}
