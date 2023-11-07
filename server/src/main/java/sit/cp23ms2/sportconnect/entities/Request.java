package sit.cp23ms2.sportconnect.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "request")
public class Request implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fromUserId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activityId")
    private Activity activity;


    @Column(name = "message")
    private String message;

    @CreationTimestamp
    @Column(name = "requestedAt")
    private Instant requestedAt;
}
