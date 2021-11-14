package ru.sbt.javaschool.ventsko.booking.mapes;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

//    @Column(name = "dCreate")
//    private Data dCreate;

    @Column(name = "type")
    private int type;

    @Column(name = "description")
    private String description;
}
