package com.carol.dscatalog.services;

import com.carol.dscatalog.dto.CategoryDto;
import com.carol.dscatalog.entities.Category;
import com.carol.dscatalog.repositories.CategoryRepository;
import com.carol.dscatalog.services.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDto> findAll(){
        return repository.findAll().stream().map( category -> new CategoryDto(category)).collect(Collectors.toList());
    }

    public CategoryDto findById(Long id) {
        Category category = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("Category not found."));
        return new CategoryDto(category);
    }
}
