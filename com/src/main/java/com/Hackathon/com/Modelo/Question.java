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
@Table(name = "question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String description;
    public String a;
    public String b;
    public String c;
    public String answer;
    public String review;
    public String difficulty;


    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties(value = {"question","testQuestion"})
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "question")
    @JsonIgnoreProperties(value = "question")
    private List<TestQuestion> testQuestion;

    public Question() {
        
    }

    public Question(Integer id, String description, String a, String b, String c, String answer, String review, String difficulty, Category category, List<TestQuestion> testQuestion) {
        this.id = id;
        this.description = description;
        this.a = a;
        this.b = b;
        this.c = c;
        this.answer = answer;
        this.review = review;
        this.difficulty = difficulty;
        this.category = category;
        this.testQuestion = testQuestion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<TestQuestion> getTestQuestion() {
        return testQuestion;
    }

    public void setTestQuestion(List<TestQuestion> testQuestion) {
        this.testQuestion = testQuestion;
    }
    
    
}
