package mx.com.officedepot.mypuppy.vista;

import java.util.ArrayList;

import mx.com.officedepot.mypuppy.adapter.MyAdapter;
import mx.com.officedepot.mypuppy.pojo.Mascota;

/**
 * Created by VillaVargas on 08/06/16.
 */
public interface IFragment_recyclerview {

    public void generarLinerLayoutVertical();

    public MyAdapter crearAdaptador(ArrayList<Mascota> pets);

    public void inicializarAdaptadorRV(MyAdapter adaptador);
}
