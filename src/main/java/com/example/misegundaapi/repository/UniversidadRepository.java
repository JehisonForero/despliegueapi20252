package com.example.misegundaapi.repository;

import com.example.misegundaapi.entity.UniversidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UniversidadRepository extends JpaRepository<UniversidadEntity, Long> {

    @Query("SELECT uni from UniversidadEntity uni where uni.nit = ?1")
    public  UniversidadEntity findByNit(String nit);

    @Query("SELECT dir from UniversidadEntity dir where dir.direccion = ?1 or dir.puntuacion = ?2")
    public List<UniversidadEntity> findByDir(String dir, Double puntuacion);

    @Query("SELECT unitres.nombre, unitres.puntuacion FROM UniversidadEntity unitres")
    public List<Object[]> findByAtributes();
}
