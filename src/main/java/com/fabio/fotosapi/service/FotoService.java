package com.fabio.fotosapi.service;

import com.fabio.fotosapi.enums.ClotheType;
import com.fabio.fotosapi.enums.PlaceType;
import com.fabio.fotosapi.model.FotoModel;

import java.util.List;

public interface FotoService {

    List<FotoModel> getAll();
    FotoModel getByCode(String code);
    List<FotoModel> getAllByCaracter(String caracter);
    FotoModel updateClothe(String code, ClotheType clotheType);
    FotoModel updatePlace(String code, PlaceType placeType);
    FotoModel updateDone(String code);

}
