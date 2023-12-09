package sit.cp23ms2.sportconnect.dtos.category;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageCategoryDto {
    private List<CategoryDto> content;
    private int number;
    private int size;
    private int totalPages;
    private int numberOfElements;
    private int totalElements;
    private boolean last;
    private boolean first;
}
