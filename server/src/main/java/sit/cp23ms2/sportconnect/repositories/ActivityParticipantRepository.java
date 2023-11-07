package sit.cp23ms2.sportconnect.repositories;

import sit.cp23ms2.sportconnect.entities.ActivityParticipant;
import sit.cp23ms2.sportconnect.entities.idclass.ActivityParticipantId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.Instant;

public interface ActivityParticipantRepository extends JpaRepository<ActivityParticipant, ActivityParticipantId> {

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO \"activityParticipants\" VALUES(?1, ?2, cast(?3 as status_participant), ?4)", nativeQuery = true
    )
    public void insertWithEnum(Integer userId, Integer activityId, String status, Instant joinedAt);
}
