package com.example.misegundaapi.sevices;

import com.example.misegundaapi.entity.UniversidadEntity;

import java.util.List;

public interface IUniversidadService {

    public List<UniversidadEntity>findALL();
    public UniversidadEntity findById(Long id);
    public List<UniversidadEntity> findByDir(String dir, Double puntuacion);
    public UniversidadEntity findByNit(String nit);
    public List<Object[]> findByAtributes();

    //post
    public void save(UniversidadEntity universidad );
}
