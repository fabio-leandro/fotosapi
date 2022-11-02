package com.fabio.fotosapi.model;

import com.fabio.fotosapi.enums.ClotheType;
import com.fabio.fotosapi.enums.PlaceType;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_fotos")
public class FotoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    private String caracter;
    private ClotheType clothe;
    private PlaceType place;
    private Boolean done;

    public FotoModel(){

    }

    public FotoModel(Integer id, String code, String caracter, ClotheType clothe, PlaceType place, Boolean done) {
        this.id = id;
        this.code = code;
        this.caracter = caracter;
        this.clothe = clothe;
        this.place = place;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public ClotheType getClothe() {
        return clothe;
    }

    public void setClothe(ClotheType clothe) {
        this.clothe = clothe;
    }

    public PlaceType getPlace() {
        return place;
    }

    public void setPlace(PlaceType place) {
        this.place = place;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
