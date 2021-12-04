/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hackathon.com.Modelo.Services;

import com.Hackathon.com.Modelo.Category;
import com.Hackathon.com.Modelo.Repository.categoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author calix
 */
@Service
public class categoryServices {

    @Autowired
    private categoryRepository metodosCrud;

    public List<Category> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return metodosCrud.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId_Category() == null) {
            return metodosCrud.save(category);
        } else {
            Optional<Category> evt = metodosCrud.getCategory(category.getId_Category());
            if (evt.isEmpty()) {
                return metodosCrud.save(category);
            } else {
                return category;
            }

        }

    }

    public Category update(Category category) {
        if (category.getId_Category() != null) {
            return metodosCrud.save(category);
        } else {
            Optional<Category> e = metodosCrud.getCategory(category.getId_Category());
            if (!e.isEmpty()) {
                if (category.getName() != null) {
                    e.get().setName(category.getName());
                }
                if (category.getQuestion() != null) {
                    e.get().setQuestion(category.getQuestion());
                }
                return e.get();
            } else {
                return category;
            }
        }
    }

    public boolean deleteCategory(int id) {
        Boolean aBoolean = getCategory(id).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(aBoolean = false);
        return aBoolean;
    }
}
