package sit.cp23ms2.sportconnect.repositories;

import sit.cp23ms2.sportconnect.entities.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    @Query(
            value = "SELECT * FROM \"activities\" ",nativeQuery = true
    )
    Page<Activity> findAllActivities(
            Pageable pageable
    );

    @Query(
            value = "SELECT * FROM \"activities\" WHERE activityId = ?1 ",nativeQuery = true
    )
    Activity findActivityById(Integer id);

    public boolean existsByTitleAndActivityIdNot(String title, Integer id);

    public boolean existsByTitle(String title);
}
