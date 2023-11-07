package sit.cp23ms2.sportconnect.repositories;

import sit.cp23ms2.sportconnect.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
