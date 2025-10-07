package com.example.misegundaapi.sevices.implement;

import com.example.misegundaapi.entity.UniversidadEntity;
import com.example.misegundaapi.repository.UniversidadRepository;
import com.example.misegundaapi.sevices.IUniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversidadServiceImplement implements IUniversidadService {

    @Autowired
    private UniversidadRepository universidadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UniversidadEntity> findALL() {
        return universidadRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UniversidadEntity findById(Long id) {
        return universidadRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UniversidadEntity> findByDir(String dir, Double puntuacion) {
        return universidadRepository.findByDir(dir,puntuacion);
    }


    @Override
    @Transactional(readOnly = true)
    public UniversidadEntity findByNit(String nit) {
        return universidadRepository.findByNit(nit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object[]> findByAtributes() {
        return universidadRepository.findByAtributes();
    }

    @Override
    @Transactional
    public void save(UniversidadEntity universidad) {
        universidadRepository.save(universidad);
    }
}
