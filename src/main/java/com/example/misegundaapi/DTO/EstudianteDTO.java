package com.example.misegundaapi.DTO;

public class EstudianteDTO {
    private String nombre;
    private String documento;
    private String tipoDocumento;
    private String telefono;
    private Long fkuniversidad;

    public EstudianteDTO() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public Long getFkuniversidad() {
        return fkuniversidad;
    }

    public void setFkuniversidad(Long fkuniversidad) {
        this.fkuniversidad = fkuniversidad;
    }
}
