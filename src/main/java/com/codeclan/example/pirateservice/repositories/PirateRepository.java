package com.codeclan.example.pirateservice.repositories;

import com.codeclan.example.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//JPA repository sits between the controller and the db.
public interface PirateRepository extends JpaRepository<Pirate, Long> {
}
