package com.carol.dscatalog.resources;

import com.carol.dscatalog.entities.Category;
import com.carol.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value ="/categories")
public class CategoryResource {

    @Autowired
    CategoryService service;
    @GetMapping
    ResponseEntity<List<Category>> findAll(){

        return ResponseEntity.ok().body(service.findAll());
    }


}
