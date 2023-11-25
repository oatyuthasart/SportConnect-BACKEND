package sit.cp23ms2.sportconnect.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sit.cp23ms2.sportconnect.entities.Request;
import sit.cp23ms2.sportconnect.entities.idclass.RequestId;

import javax.transaction.Transactional;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, RequestId> {
    @Query(
            value = "SELECT * FROM \"request\" WHERE (\"activityId\" = :activityId OR :activityId IS NULL)" +
                    "AND (\"fromUserId\" = :userId OR :userId IS NULL) ",nativeQuery = true
    )
    Page<Request> findAllRequests(
            Pageable pageable,
            @Param("activityId") Integer activityId,
            @Param("userId") Integer userId
    );

    public boolean existsByActivity_ActivityIdAndUser_UserId(Integer activityId, Integer userId);
    public Optional<Request> findByActivityActivityIdAndUser_UserId(Integer activityId, Integer userId);
    @Transactional
    public void deleteByActivity_ActivityIdAndUser_UserId(Integer activityId, Integer userId);
}
