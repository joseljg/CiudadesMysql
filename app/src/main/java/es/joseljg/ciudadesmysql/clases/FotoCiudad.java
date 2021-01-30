package es.joseljg.ciudadesmysql.clases;

import android.graphics.Bitmap;

import java.util.Objects;

public class FotoCiudad {
    private int idfoto;
    private Bitmap foto;
    private int idciudad;

    public FotoCiudad(int idfoto, Bitmap foto, int idciudad) {
        this.idfoto = idfoto;
        this.foto = foto;
        this.idciudad = idciudad;
    }

    public int getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(int idfoto) {
        this.idfoto = idfoto;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoCiudad that = (FotoCiudad) o;
        return idfoto == that.idfoto &&
                idciudad == that.idciudad &&
                foto.equals(that.foto);
    }

    @Override
    public String toString() {
        return "FotoCiudad{" +
                "idfoto=" + idfoto +
                ", idciudad=" + idciudad +
                '}';
    }
}
