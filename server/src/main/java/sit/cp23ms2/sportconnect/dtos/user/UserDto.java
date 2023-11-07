package sit.cp23ms2.sportconnect.dtos.user;

import sit.cp23ms2.sportconnect.entities.Activity;
import sit.cp23ms2.sportconnect.enums.Gender;
import sit.cp23ms2.sportconnect.enums.Role;
import lombok.Getter;
import lombok.Setter;


import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    private Integer userId;
    private String username;
    private String email;
    private Role role;
    private String profilePicture;
    private Gender gender;
    private Date dateOfBirth;
    private String phoneNumber;
    private String lineId;
    private Instant lastLogin;
    private Instant createdAt;
    private Instant updatedAt;

    private Set<Activity> userActivities = new HashSet<>();
}
