package com.webbdealer.catalog.repositories;

import com.webbdealer.catalog.entities.Make;
import com.webbdealer.catalog.entities.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends CrudRepository<Model, Long> {

    Optional<List<Model>> findAllByName(String name);

    Optional<Model> findFirstByName(String name);

    Optional<Model> findByNameContaining(String name);

    Optional<Model> findByNameLike(String name);

    Optional<Model> findByNameStartingWith(String name);

    @Query("select model.name from Model model join model.make make where make.name = :makeName")
    List<String> findAllModelsByMake(@Param("makeName") String makeName);

    @Query("select model from Model model join model.make make where make.name = :makeName and model.name = :modelName")
    Optional<Model> findModelByMake(@Param("makeName") String makeName, @Param("modelName") String modelName);
}
