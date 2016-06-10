package mx.com.officedepot.mypuppy.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.ArrayList;
import android.widget.ImageButton;

import mx.com.officedepot.mypuppy.R;
import mx.com.officedepot.mypuppy.db.ConstructorMascotas;
import mx.com.officedepot.mypuppy.pojo.Mascota;


/**
 * Created by VillaVargas on 29/05/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.PetViewHolder> {

    ArrayList<Mascota> pets;

    Activity activity;



    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Mascota> pets, Activity activity){
        this.pets = pets;
        this.activity = activity;

    }

    public MyAdapter(ArrayList<Mascota> pets){
        this.pets = pets;

    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class PetViewHolder extends RecyclerView.ViewHolder {
        TextView petName;
        TextView countRating;
        ImageView petPhoto;
        private ImageButton ib,ib2;

        PetViewHolder(View itemView) {
            super(itemView);
            petName = (TextView)itemView.findViewById(R.id.namePet);
            countRating = (TextView)itemView.findViewById(R.id.countRating);
            petPhoto = (ImageView)itemView.findViewById(R.id.photoPet);
            ib = (ImageButton) itemView.findViewById(R.id.ratear);
            ib2 = (ImageButton) itemView.findViewById(R.id.rating);
        }
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pets_item, viewGroup, false);
        PetViewHolder pvh = new PetViewHolder(v);
        return pvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final PetViewHolder holder, final int i) {
        final Mascota pet = pets.get(i);
        holder.petName.setText(pets.get(i).getNombre_mascota());
        holder.countRating.setText(String.valueOf(pets.get(i).rait));
        holder.petPhoto.setImageResource(pets.get(i).foto);
        holder.ib.setImageResource(pets.get(i).bone);
        holder.ib2.setImageResource(pets.get(i).bone2);

        holder.ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pets.get(i).setRait(pets.get(i).rait + 1);

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darRatingMascota(pets.get(i));

                //holder.countRating.setText(String.valueOf(pets.get(i).rait));
                holder.countRating.setText(String.valueOf(constructorMascotas.obtenerRatingMascota(pets.get(i))));

            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return pets.size();
    }

}
