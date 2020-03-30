package com.webbdealer.catalog.repositories;

import com.webbdealer.catalog.entities.Model;
import com.webbdealer.catalog.entities.Trim;
import com.webbdealer.catalog.entities.YearModelTrim;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface YearModelTrimRepository extends CrudRepository<YearModelTrim, Long> {

//    @Query("select y.year, mk.name, md.name from YearMakeModel y join ymm.Make mk join ymm.Model md where y.year = :yar and mk.name = :make and md.name = :model")
    Optional<YearModelTrim> findByYearAndModelAndTrim(String year, Model model, Trim trim);

//    @Query("select y.year, mk.name, md.name, t.name from YearModelTrim y join y.model md join md.make mk join y.trim t where y.year = :year and mk.name = :make and md.name = :model and t.name = :trim")
//    Optional<YearModelTrim> findByYearAndMakeAndModelAndTrim(String year, Make make, Model model, Trim trim);

//    @Query("select y.year, mk.name, md.name from YearMakeModel y join y.make mk join y.model md where y.year = :year and mk.name = :make and md.name = :model")
//    Optional<YmmModel> findByYearMakeModel(@Param("year") String year,
//                                                 @Param("make") String make,
//                                                 @Param("model") String model);

//    @Query("select y, mk, md, t from YearMakeModel y join y.make mk join y.model md join y.trims")
//    List<YearMakeModel> findAll();
}
