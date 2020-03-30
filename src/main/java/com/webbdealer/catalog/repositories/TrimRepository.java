package com.webbdealer.catalog.repositories;

import com.webbdealer.catalog.entities.Trim;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TrimRepository extends CrudRepository<Trim, Long> {

    Optional<Trim> findByName(String name);
}
