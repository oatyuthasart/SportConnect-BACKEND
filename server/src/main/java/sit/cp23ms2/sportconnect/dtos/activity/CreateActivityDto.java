package sit.cp23ms2.sportconnect.dtos.activity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateActivityDto {
    private Integer activityId;
    private Integer hostUserId;
    private Integer categoryId;

    @NotBlank(message = "must not be blank")
    @Size(max = 100, message = "size must not over 100")
    private String title;

    @NotBlank(message = "must not be blank")
    private String description;

    @NotBlank(message = "must not be blank")
    @Size(max = 100, message = "size must not over 100")
    private String place;

    private Instant dateTime;

    private Integer duration;

    private Integer noOfMembers;

    //Auto generated
    private Instant createdAt;
    private Instant updatedAt;
}
