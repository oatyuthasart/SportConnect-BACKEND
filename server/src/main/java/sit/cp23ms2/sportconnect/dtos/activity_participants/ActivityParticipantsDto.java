package sit.cp23ms2.sportconnect.dtos.activity_participants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.cp23ms2.sportconnect.enums.StatusParticipant;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class ActivityParticipantsDto {
    private Integer userId;
    private Integer activityId;
    private StatusParticipant status;
    private Instant joinedAt;
}
