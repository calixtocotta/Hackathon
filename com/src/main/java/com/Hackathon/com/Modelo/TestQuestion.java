/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author calix
 */
@Entity
@Table(name = "test_question")
public class TestQuestion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public boolean answer;

    @ManyToOne
    @JoinColumn(name = "question")
    @JsonIgnoreProperties(value = {"testQuestion","question"})
    private Question question;

    @ManyToOne
    @JoinColumn(name = "test")
    @JsonIgnoreProperties(value = {"testQuestion","user"})
    private Test test;

    public TestQuestion() {
    }

    public TestQuestion(Integer id, boolean answer, Question question, Test test) {
        this.id = id;
        this.answer = answer;
        this.question = question;
        this.test = test;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

}
