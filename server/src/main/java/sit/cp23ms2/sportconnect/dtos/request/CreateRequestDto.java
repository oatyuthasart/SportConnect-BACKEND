package sit.cp23ms2.sportconnect.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequestDto {
    private Integer userId;
    private Integer activityId;
    @Size(max = 100, message = "size must not over 100 characters")
    private String message;
    private Instant requestedAt;
}
