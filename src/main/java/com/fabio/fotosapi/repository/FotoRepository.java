package com.fabio.fotosapi.repository;

import com.fabio.fotosapi.model.FotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FotoRepository extends JpaRepository<FotoModel, Integer> {

    Optional<FotoModel> findByCode(String code);

    List<FotoModel> findAllByCaracter(String caracter);

}
