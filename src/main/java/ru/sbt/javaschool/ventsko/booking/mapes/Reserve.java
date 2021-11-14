package ru.sbt.javaschool.ventsko.booking.mapes;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reserves")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "service_id")
    private long serviceId;

    @Column(name = "date_from")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateFrom;

    @Column(name = "date_to")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateTo;

    @Column(name = "user_id")
    private long userId;
}
