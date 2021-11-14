package ru.sbt.javaschool.ventsko.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReserveDto {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long serviceId;

    private String serviceName;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateFrom;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateTo;

    private long userId;
}