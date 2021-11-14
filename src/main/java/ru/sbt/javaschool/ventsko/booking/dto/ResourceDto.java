package ru.sbt.javaschool.ventsko.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDto {
    private Long id;
    private String name;
    private String type;
    private String description;
}
