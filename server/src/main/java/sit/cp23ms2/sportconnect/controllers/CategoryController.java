package sit.cp23ms2.sportconnect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import sit.cp23ms2.sportconnect.dtos.activity.ActivityDto;
import sit.cp23ms2.sportconnect.dtos.category.CategoryDto;
import sit.cp23ms2.sportconnect.dtos.category.PageCategoryDto;
import sit.cp23ms2.sportconnect.dtos.user.PageUserDto;
import sit.cp23ms2.sportconnect.services.CategoryService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/categories")
@Component
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public PageCategoryDto getCategories(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int pageSize
                                         , HttpServletResponse response) throws IOException {
        //response.sendRedirect("https://google.com");

        return categoryService.getCategory(page, pageSize);
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Integer id) {
        return modelMapper.map(categoryService.getById(id), CategoryDto.class);
    }
}
