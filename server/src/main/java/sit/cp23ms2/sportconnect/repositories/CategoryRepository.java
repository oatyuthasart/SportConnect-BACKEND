package sit.cp23ms2.sportconnect.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import sit.cp23ms2.sportconnect.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import sit.cp23ms2.sportconnect.entities.User;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(
            value = "SELECT * FROM \"categories\" ",nativeQuery = true
    )
    Page<Category> findAllCategories(
            Pageable pageable
    );
}
