package com.example.misegundaapi.sevices;

import com.example.misegundaapi.DTO.EstudianteDTO;
import com.example.misegundaapi.entity.EstudianteEntity;
import com.example.misegundaapi.repository.EstudianteRepository;

import java.util.List;

public interface IEstudianteService {
    public List<EstudianteEntity> findALL();
    public EstudianteEntity findById(String id);

    //posts
    public EstudianteEntity save(EstudianteDTO estudianteDTO);
}
