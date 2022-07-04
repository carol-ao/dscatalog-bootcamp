package com.carol.dscatalog.resources;

import com.carol.dscatalog.dto.CategoryDto;
import com.carol.dscatalog.entities.Category;
import com.carol.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value ="/categories")
public class CategoryResource {

    @Autowired
    CategoryService service;
    @GetMapping
    ResponseEntity<List<CategoryDto>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<CategoryDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    ResponseEntity<CategoryDto> insertCategory(@RequestBody CategoryDto dto){
        CategoryDto categoryDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoryDto.getId()).toUri();
        return ResponseEntity.created(uri).body(categoryDto);
    }


}
