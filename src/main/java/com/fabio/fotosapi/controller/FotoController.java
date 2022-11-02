package com.fabio.fotosapi.controller;

import com.fabio.fotosapi.enums.ClotheType;
import com.fabio.fotosapi.enums.PlaceType;
import com.fabio.fotosapi.model.FotoModel;
import com.fabio.fotosapi.service.FotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/${api.version}/fotos")
@Api(tags = "Foto Controller")
public class FotoController {

    private final FotoService fotoService;

    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @GetMapping
    @ApiOperation(value = "Find all photos.")
    public ResponseEntity<List<FotoModel>> getAll(){
        return ResponseEntity.ok(fotoService.getAll());
    }

    @GetMapping("/{code}")
    @ApiOperation(value = "Find all photo by id.")
    public ResponseEntity<FotoModel> getByCode(@PathVariable String code){
        return ResponseEntity.ok(fotoService.getByCode(code));
    }

    @GetMapping("/caracter")
    @ApiOperation(value = "Find all photo by caractere.")
    public ResponseEntity<List<FotoModel>> getAllByCaracter(@RequestParam(name = "value") String caracter){
        return ResponseEntity.ok(fotoService.getAllByCaracter(caracter));
    }

    @PutMapping("/{code}/clothe")
    @ApiOperation(value = "Update clothe by code.")
    public ResponseEntity<FotoModel> updateClothe(@PathVariable String code,
                                                  @RequestParam(name = "value") ClotheType clotheType){
        return ResponseEntity.ok(fotoService.updateClothe(code,clotheType));
    }

    @PutMapping("/{code}/place")
    @ApiOperation(value = "Update place by code.")
    public ResponseEntity<FotoModel> updatePlace(@PathVariable String code,
                                                 @RequestParam(name = "value") PlaceType placeType){
        return ResponseEntity.ok(fotoService.updatePlace(code,placeType));
    }

    @PutMapping("/{code}")
    @ApiOperation(value = "Update done by code.")
    public ResponseEntity<FotoModel> updateDone(@PathVariable String code){
        return ResponseEntity.ok(fotoService.updateDone(code));
    }
}
