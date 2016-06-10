package mx.com.officedepot.mypuppy.vista;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

import mx.com.officedepot.mypuppy.pojo.Mascota;
import mx.com.officedepot.mypuppy.adapter.MyAdapter;
import mx.com.officedepot.mypuppy.R;
import mx.com.officedepot.mypuppy.presentador.IRecyclerViewFragmentPresenter;
import mx.com.officedepot.mypuppy.presentador.RecyclerViewFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_recyclerview extends Fragment implements IFragment_recyclerview{

    private ArrayList<Mascota> pets;
    private RecyclerView listaMascotas;
    MyAdapter adapter;
    private IRecyclerViewFragmentPresenter presenter;

    public Fragment_recyclerview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);


        listaMascotas = (RecyclerView) v.findViewById(R.id.list);


        //initializeData();
        //initializeAdapter();
        // Inflate the layout for this fragment
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }



/*
    private void initializeData(){
        pets = new ArrayList<Mascota>();
        pets.add(new Mascota( R.drawable.cat, "Cat" , 0,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.dog, "Dog", 0,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.dog2, "Dog 2", 0,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota( R.drawable.fish, "Fish" , 0,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.frog, "Frog", 0, R.drawable.ic_bone, R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.guinea, "Guinea", 0, R.drawable.ic_bone, R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.horse, "Horse", 0, R.drawable.ic_bone, R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.pet, "Pet 1", 0, R.drawable.ic_bone, R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.pet3, "Pet 3", 0,R.drawable.ic_bone,R.drawable.ic_rating));
    }

    */

    @Override
    public void generarLinerLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MyAdapter crearAdaptador(ArrayList<Mascota> pets) {
         adapter = new MyAdapter(pets, getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MyAdapter adaptador) {
        listaMascotas.setAdapter(adapter);

    }
}
