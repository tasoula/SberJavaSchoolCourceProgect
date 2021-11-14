package ru.sbt.javaschool.ventsko.booking.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.javaschool.ventsko.booking.mapes.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
