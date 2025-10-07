package com.example.misegundaapi.sevices.implement;

import com.example.misegundaapi.DTO.EstudianteDTO;
import com.example.misegundaapi.entity.EstudianteEntity;
import com.example.misegundaapi.entity.UniversidadEntity;
import com.example.misegundaapi.repository.EstudianteRepository;
import com.example.misegundaapi.repository.UniversidadRepository;
import com.example.misegundaapi.sevices.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EstudianteServiceImplement implements  IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private UniversidadRepository universidadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteEntity> findALL() {
        return estudianteRepository.findAll();
    }

    @Override
    public EstudianteEntity findById(String id) {
        return  estudianteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public EstudianteEntity save(EstudianteDTO estudianteDTO) {
        UniversidadEntity unifk= universidadRepository.findById(estudianteDTO.getFkuniversidad()).orElse(null);

        EstudianteEntity estudiantesave = new EstudianteEntity();
        estudiantesave.setDocumento(estudianteDTO.getDocumento());
        estudiantesave.setNombre(estudianteDTO.getNombre());
        estudiantesave.setTelefono(estudianteDTO.getTelefono());
        estudiantesave.setTipoDocumento(estudianteDTO.getTipoDocumento());
        estudiantesave.setUniversidad(unifk);

        return estudianteRepository.save(estudiantesave);

    }
}
