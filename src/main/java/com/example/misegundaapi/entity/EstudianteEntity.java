package com.example.misegundaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;

@Entity
@Table(name = "ESTUDIANTES")
public class EstudianteEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "documento")
    private String documento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkuniversidad", referencedColumnName = "iduniversidad")
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore

    private UniversidadEntity universidad;

    //getter personalizado
    @JsonProperty("fkmiuniversidad")
    public Long getUniversidadId() {
        return universidad != null ? universidad.getIduniversidad() : null;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
    }


}
