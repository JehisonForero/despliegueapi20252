package com.example.misegundaapi.rest;

import com.example.misegundaapi.DTO.EstudianteDTO;
import com.example.misegundaapi.entity.EstudianteEntity;
import com.example.misegundaapi.entity.UniversidadEntity;
import com.example.misegundaapi.repository.EstudianteRepository;
import com.example.misegundaapi.sevices.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/estudiante")
public class EstudianteRest {

    @Autowired
    private IEstudianteService estudianteService;
    @Autowired
    private IEstudianteService iEstudianteService;


    @GetMapping("listar")
    public ResponseEntity<List<EstudianteEntity>> findAll() {
        return ResponseEntity.ok(estudianteService.findALL());
    }

    @GetMapping("listarby/{id}")
    public ResponseEntity <EstudianteEntity> findById(@PathVariable ("id") String id) {
        return ResponseEntity.ok(estudianteService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<EstudianteEntity> create(@RequestBody @Validated EstudianteDTO estudianteDTO) {

        try {
            EstudianteEntity miestudiante = iEstudianteService.save(estudianteDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miestudiante);
        } catch (Exception e) {
            System.out.printf("ERROR: ", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

}
