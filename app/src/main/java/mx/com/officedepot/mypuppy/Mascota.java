package mx.com.officedepot.mypuppy;

/**
 * Created by VillaVargas on 29/05/16.
 */
public class Mascota {

    int foto;
    String nombre_mascota;
    String rait;
    int bone;
    int bone2;

    public Mascota(int foto, String nombre_mascota, String rait, int bone, int bone2) {
        this.foto = foto;
        this.nombre_mascota = nombre_mascota;
        this.rait = rait;
        this.bone = bone;
        this.bone2 = bone2;
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

    public String getRait() {
        return rait;
    }

    public void setRait(String rait) {
        this.rait = rait;
    }

    public int getBone() {
        return bone;
    }

    public void setBone(int bone) {
        this.bone = bone;
    }

    public int getBone2() {
        return bone2;
    }

    public void setBone2(int bone2) {
        this.bone2 = bone2;
    }
}
