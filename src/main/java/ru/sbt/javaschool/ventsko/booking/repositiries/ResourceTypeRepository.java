package ru.sbt.javaschool.ventsko.booking.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.javaschool.ventsko.booking.mapes.ResourceType;

public interface ResourceTypeRepository  extends JpaRepository<ResourceType,Long> {
}
