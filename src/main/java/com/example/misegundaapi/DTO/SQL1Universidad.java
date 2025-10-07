package com.example.misegundaapi.DTO;

import java.util.Objects;

public class SQL1Universidad {
    private String nombre;
    private Float puntuacion;

    public SQL1Universidad() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Float puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SQL1Universidad that = (SQL1Universidad) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(puntuacion, that.puntuacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, puntuacion);
    }

    @Override
    public String toString() {
        return "SQL1Universidad{" +
                "nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
