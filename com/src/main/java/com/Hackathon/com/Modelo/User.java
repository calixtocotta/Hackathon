/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author calix
 */
@Entity
@Table(name="user")
public class User implements Serializable{
    
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String identification;
    public String cellPhone;
    public String email;
    public String password;
    public Integer age;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "user")
    @JsonIgnoreProperties(value="user")
    private List<Test> test;

    public User() {
    }

    public User(Integer id, String name, String identification, String cellPhone, String email, String password, Integer age, List<Test> test) {
        this.id = id;
        this.name = name;
        this.identification = identification;
        this.cellPhone = cellPhone;
        this.email = email;
        this.password = password;
        this.age = age;
        this.test = test;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }
    
    
}
