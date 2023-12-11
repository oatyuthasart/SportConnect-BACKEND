package sit.cp23ms2.sportconnect.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.cp23ms2.sportconnect.entities.Activity;
import sit.cp23ms2.sportconnect.entities.Request;
import sit.cp23ms2.sportconnect.entities.User;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class RequestDto {
    private Integer userId;
    private String username;
    private Integer activityId;
    private String message;
    private Instant requestedAt;

}
