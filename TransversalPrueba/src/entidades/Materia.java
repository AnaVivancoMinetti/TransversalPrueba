
package Entidades;

import java.time.LocalDate;


public class Materia {
    
    private int IDmateria;
    private String nombreMat;
    private int anio;
    private boolean estado;

    public Materia() {
    }

    public Materia(int IDmateria, String nombreMat, int anio, boolean estado) {
        this.IDmateria = IDmateria;
        this.nombreMat = nombreMat;
        this.anio = anio;
        this.estado = estado;
    }

    public Materia(String nombreMat, int anio, boolean estado) {
        this.nombreMat = nombreMat;
        this.anio = anio;
        this.estado = estado;
    }

    public int getIDmateria() {
        return IDmateria;
    }

    public void setIDmateria(int IDmateria) {
        this.IDmateria = IDmateria;
    }

    public String getNombreMat() {
        return nombreMat;
    }

    public void setNombreMat(String nombreMat) {
        this.nombreMat = nombreMat;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
public String toString() {
    return nombreMat;
}
    }


   
