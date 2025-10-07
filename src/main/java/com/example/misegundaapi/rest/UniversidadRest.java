package com.example.misegundaapi.rest;

import com.example.misegundaapi.DTO.SQL1Universidad;
import com.example.misegundaapi.entity.UniversidadEntity;
import com.example.misegundaapi.sevices.IUniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/universidad")
public class UniversidadRest {

    @Autowired
    private IUniversidadService universidadService;

    @GetMapping("listar")
    public ResponseEntity<List<UniversidadEntity>> findALL() {
        return ResponseEntity.ok(universidadService.findALL());
    }

    @GetMapping("listarby/{id}")
    public ResponseEntity<UniversidadEntity> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(universidadService.findById(id));
    }

    @GetMapping("/listarbyidparam")
    public ResponseEntity<UniversidadEntity> findAllByParam(@RequestParam(value = "id") Long id) {
        return ResponseEntity.ok(universidadService.findById(id));
    }

    @GetMapping("listarbynit/{nit}")
    public ResponseEntity<UniversidadEntity> findBy(@PathVariable("nit") String nit) {
        return ResponseEntity.ok(universidadService.findByNit(nit));
    }

    @GetMapping("listarbyDir/{dir}/{punt}")
    public ResponseEntity<List<UniversidadEntity>> findBy(@PathVariable("dir") String dir, @PathVariable("punt") Double punt) {
        return ResponseEntity.ok(universidadService.findByDir(dir, punt));
    }

    @GetMapping("/sql1")
    public ResponseEntity<List<SQL1Universidad>> findByAtributes() {
        //Recuperar datos del servicio
        List<Object[]> results = universidadService.findByAtributes();

        //Crear Lista para almacenar objetos
        List<SQL1Universidad> consultas = new ArrayList<>();

        for (Object[] recorrido : results) {
            SQL1Universidad sql1Universidad = new SQL1Universidad();

            //verificar si tiene datos
            if (recorrido.length >= 2) {
                sql1Universidad.setNombre(recorrido[0] != null ? recorrido[0].toString() : null);
                sql1Universidad.setPuntuacion(recorrido[1] != null ? Float.parseFloat(recorrido[1].toString()) : null);
            }
            System.out.println("Datos: " + recorrido[0] + " " + recorrido[1]);
            consultas.add(sql1Universidad);
        }
        return ResponseEntity.ok(consultas);
    }

    @PostMapping("/crear")
    public ResponseEntity<UniversidadEntity> create(@RequestBody @Validated UniversidadEntity universidad) {
        try {
            universidadService.save(universidad);
            ResponseEntity.status(200);
            return ResponseEntity.ok(universidad);
        } catch (Exception e) {
            System.out.printf("ERROR: ", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
