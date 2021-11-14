package ru.sbt.javaschool.ventsko.booking.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.javaschool.ventsko.booking.mapes.Reserve;

public interface ReserveRepository extends JpaRepository<Reserve,Long> {
}
