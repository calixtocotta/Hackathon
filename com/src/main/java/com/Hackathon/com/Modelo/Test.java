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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author calix
 */
@Entity
@Table(name = "test")
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String difficulty;
    public String quality;
    public double score;

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonIgnoreProperties(value = "test")
    private User user;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "test")
    @JsonIgnoreProperties(value = "test")
    private List<TestQuestion> testQuestion;

    public Test() {
    }

    public Test(Integer id, String difficulty, String quality, double score, User user, List<TestQuestion> testQuestion) {
        this.id = id;
        this.difficulty = difficulty;
        this.quality = quality;
        this.score = score;
        this.user = user;
        this.testQuestion = testQuestion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<TestQuestion> getTestQuestion() {
        return testQuestion;
    }

    public void setTestQuestion(List<TestQuestion> testQuestion) {
        this.testQuestion = testQuestion;
    }

}
