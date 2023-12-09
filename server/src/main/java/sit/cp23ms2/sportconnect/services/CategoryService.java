package sit.cp23ms2.sportconnect.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.cp23ms2.sportconnect.dtos.activity.PageActivityDto;
import sit.cp23ms2.sportconnect.dtos.category.PageCategoryDto;
import sit.cp23ms2.sportconnect.entities.Activity;
import sit.cp23ms2.sportconnect.entities.Category;
import sit.cp23ms2.sportconnect.exceptions.type.ApiNotFoundException;
import sit.cp23ms2.sportconnect.repositories.CategoryRepository;

import java.util.Set;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;
    @Autowired
    ModelMapper modelMapper;

    public PageCategoryDto getCategory(int pageNum, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNum, pageSize);
        Page<Category> listCategories = repository.findAllCategories(pageRequest);
        PageCategoryDto pageCategoryDto = modelMapper.map(listCategories, PageCategoryDto.class); //map ใส่ PageUserDto
        return  pageCategoryDto;
    }

    public Category getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ApiNotFoundException("Category not found!"));
    }
}
