package ru.sbt.javaschool.ventsko.booking.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.javaschool.ventsko.booking.mapes.Resource;

public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
