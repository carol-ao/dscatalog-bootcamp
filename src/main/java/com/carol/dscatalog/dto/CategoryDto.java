package com.carol.dscatalog.dto;

import com.carol.dscatalog.entities.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

    private Long id;
    private String name;

    public CategoryDto(Category category){
        this.id = category.getId();
        this.name = category.getName();
    }
}
