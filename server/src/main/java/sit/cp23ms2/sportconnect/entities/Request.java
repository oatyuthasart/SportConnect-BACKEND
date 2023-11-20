package sit.cp23ms2.sportconnect.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import sit.cp23ms2.sportconnect.entities.idclass.RequestId;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "request")
@IdClass(RequestId.class)
public class Request implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "fromUserId")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "activityId")
    private Activity activity;


    @Column(name = "message")
    private String message;

    @CreationTimestamp
    @Column(name = "requestedAt")
    private Instant requestedAt;
}
