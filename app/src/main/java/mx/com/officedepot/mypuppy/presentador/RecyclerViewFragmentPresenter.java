package mx.com.officedepot.mypuppy.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.com.officedepot.mypuppy.adapter.MyAdapter;
import mx.com.officedepot.mypuppy.db.ConstructorMascotas;
import mx.com.officedepot.mypuppy.pojo.Mascota;
import mx.com.officedepot.mypuppy.vista.IFragment_recyclerview;

/**
 * Created by VillaVargas on 08/06/16.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IFragment_recyclerview iFragment_recyclerview;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> pets;


    public RecyclerViewFragmentPresenter(IFragment_recyclerview iFragment_recyclerview, Context context) {
        this.iFragment_recyclerview = iFragment_recyclerview;
        this.context = context;
        obtenerContactosBaseDatos();
    }




    @Override
    public void obtenerContactosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        pets = constructorMascotas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
       iFragment_recyclerview.inicializarAdaptadorRV(iFragment_recyclerview.crearAdaptador(pets));
        iFragment_recyclerview.generarLinerLayoutVertical();
    }
}
