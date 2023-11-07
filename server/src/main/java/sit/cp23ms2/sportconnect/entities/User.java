package sit.cp23ms2.sportconnect.entities;

import sit.cp23ms2.sportconnect.enums.Gender;
import sit.cp23ms2.sportconnect.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "profilePicture")
    private String profilePicture;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "lineId")
    private String lineId;

    @Column(name = "lastLogin")
    private Instant lastLogin;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt", nullable = false)
    private Instant updatedAt;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "activityParticipants"
            ,joinColumns = {@JoinColumn(name = "userId")}
            ,inverseJoinColumns = {@JoinColumn(name = "activityId")})
    private Set<Activity> userActivities = new HashSet<>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "hostUser")
//    private Set<Activity> activities = new LinkedHashSet<>();

}