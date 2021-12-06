/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Hackathon.com.Modelo.Interfaz;

import com.Hackathon.com.Modelo.Test;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author calix
 */
public interface testInterfaz extends CrudRepository<Test, Integer>{
    public List<Test> findAllByOrderByScoreDesc();
}
