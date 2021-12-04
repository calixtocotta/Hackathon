/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Hackathon.com.Modelo.Interfaz;

import com.Hackathon.com.Modelo.Question;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author calix
 */
public interface questionInterfaz extends CrudRepository<Question, Integer>{
    
}
