package com.fabio.fotosapi.service;

import com.fabio.fotosapi.enums.ClotheType;
import com.fabio.fotosapi.enums.PlaceType;
import com.fabio.fotosapi.model.FotoModel;
import com.fabio.fotosapi.repository.FotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoServiceImpl implements FotoService{

    private final FotoRepository fotoRepository;

    public FotoServiceImpl(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    @Override
    public List<FotoModel> getAll() {
        return fotoRepository.findAll();
    }

    @Override
    public FotoModel getByCode(String code) {
        return fotoRepository.findByCode(code).orElseThrow(
                ()-> new RuntimeException("It was not found a photo with this code -> " + code));
    }

    @Override
    public List<FotoModel> getAllByCaracter(String caracter) {
        return fotoRepository.findAllByCaracter(caracter);
    }

    @Override
    public FotoModel updateClothe(String code, ClotheType clotheType) {
        FotoModel fotoModel = getByCode(code);
        try {
            fotoModel.setClothe(clotheType);
        }catch (RuntimeException e){
            throw new RuntimeException("It was not possible updating.");
        }
        return fotoRepository.save(fotoModel);
    }

    @Override
    public FotoModel updatePlace(String code, PlaceType placeType) {
        FotoModel fotoModel = getByCode(code);
        try {
            fotoModel.setPlace(placeType);
        }catch (RuntimeException e){
            throw new RuntimeException("It was not possible updating.");
        }

        return fotoRepository.save(fotoModel);
    }

    @Override
    public FotoModel updateDone(String code) {
        FotoModel fotoModel = getByCode(code);
        if(fotoModel.getDone()){
            fotoModel.setDone(false);
        }else {
            fotoModel.setDone(true);
        }
        return fotoRepository.save(fotoModel);
    }
}
