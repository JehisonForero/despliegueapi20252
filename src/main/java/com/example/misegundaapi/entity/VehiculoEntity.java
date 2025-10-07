package com.example.misegundaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "vehiculo")
public class VehiculoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvehiculo")
    private Long idvehiculo;

    @Column(name = "placa", unique = true)
    private String placa;

    @Column(name = "color")
    private String color;

    @OneToOne
    @JoinColumn(name = "fkmiuniversidad")
    private UniversidadEntity universidad;

    @JsonIgnore
    //Getter personalizado
    @JsonProperty("fkmiuniversidad")
    public Long getUniversidadId() {
        return universidad != null ? universidad.getIduniversidad() : null;
    }

    public Long getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Long idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
    }
}
