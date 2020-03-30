package com.webbdealer.catalog.repositories;

import com.webbdealer.catalog.entities.Make;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MakeRepository extends CrudRepository<Make, Long> {

    Optional<Make> findByName(String name);

    List<Make> findAll();
}
