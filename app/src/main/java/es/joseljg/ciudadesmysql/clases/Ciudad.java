package es.joseljg.ciudadesmysql.clases;

import java.io.Serializable;

public class Ciudad implements Serializable {
    private int idciudad;
    private String nombre;
    private int habitantes;
    private int idprovincia;

    public Ciudad(int idciudad, String nombre, int habitantes, int idprovincia) {
        this.idciudad = idciudad;
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.idprovincia = idprovincia;
    }
    //-------------------------------
    public Ciudad() {
        this.idciudad = 0;
        this.nombre = "";
        this.habitantes = 0;
        this.idprovincia = 1;
    }
    //------------------------------


    public Ciudad(String nombre, int habitantes, int idprovincia) {
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.idprovincia = idprovincia;
    }

    //--------------------------------


    @Override
    public String toString() {
        return "Ciudad [idciudad=" + idciudad + ", nombre=" + nombre + ", habitantes=" + habitantes + ", idprovincia="
                + idprovincia + "]";
    }
    public int getIdprovincia() {
        return idprovincia;
    }
    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idciudad;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
       Ciudad other = (Ciudad) obj;
        if (idciudad != other.idciudad)
            return false;
        return true;
    }

    public int getIdciudad() {
        return idciudad;
    }
    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getHabitantes() {
        return habitantes;
    }
    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

}
