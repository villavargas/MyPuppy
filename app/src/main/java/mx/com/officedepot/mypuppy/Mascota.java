package mx.com.officedepot.mypuppy;

/**
 * Created by VillaVargas on 29/05/16.
 */
public class Mascota {

    int foto;
    String nombre_mascota;
    int rait;

    public Mascota(int foto, String nombre_mascota, int rait) {
        this.foto = foto;
        this.nombre_mascota = nombre_mascota;
        this.rait = rait;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public int getRait() {
        return rait;
    }

    public void setRait(int rait) {
        this.rait = rait;
    }
}
