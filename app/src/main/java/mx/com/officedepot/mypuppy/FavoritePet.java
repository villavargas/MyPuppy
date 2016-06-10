package mx.com.officedepot.mypuppy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

import mx.com.officedepot.mypuppy.adapter.MyAdapter;
import mx.com.officedepot.mypuppy.pojo.Mascota;

/**
 * Created by VillaVargas on 04/06/16.
 */
public class FavoritePet extends AppCompatActivity {

        ImageButton ib;
        ImageButton ratear;
        ImageView iv;
        private RecyclerView listaMascotas;
        private ArrayList<Mascota> pets;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_favorite);

            Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
          //  setSupportActionBar(miActionBar);
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            ib = (ImageButton) findViewById(R.id.estrellita);
            ib.setAlpha(0f);


            iv = (ImageView)findViewById(R.id.patita);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            listaMascotas = (RecyclerView) findViewById(R.id.miRV);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            listaMascotas.setLayoutManager(llm);
            inicializarListaContactos();
            inicializarAdaptador();
        }

    public void inicializarAdaptador() {
        MyAdapter adapter = new MyAdapter(pets);
        listaMascotas.setAdapter(adapter);
    }

    public void inicializarListaContactos(){
        pets = new ArrayList<Mascota>();
        pets.add(new Mascota( R.drawable.cat, "Cat" , 7,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.dog, "Dog", 5,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.dog2, "Dog 2", 4,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota( R.drawable.fish, "Fish" , 3,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota( R.drawable.frog, "Frog" , 2,R.drawable.ic_bone,R.drawable.ic_rating));
    }
}
