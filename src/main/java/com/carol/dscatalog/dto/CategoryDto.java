package com.carol.dscatalog.dto;

import com.carol.dscatalog.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Long id;
    private String name;

    public CategoryDto(Category category){
        this.id = category.getId();
        this.name = category.getName();
    }
}
