package mx.com.officedepot.mypuppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView personName;
    TextView personAge;
    ImageView personPhoto;

    private List<Mascota> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pets_item);


        personName = (TextView)findViewById(R.id.person_name);
        personAge = (TextView)findViewById(R.id.person_age);
        personPhoto = (ImageView)findViewById(R.id.person_photo);

        personName.setText("Emma Wilson");
        personAge.setText("23 years old");
        personPhoto.setImageResource(R.drawable.cat);
    }



    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Mascota( R.drawable.cat, "Cat" , 0));
        persons.add(new Mascota(R.drawable.dog, "Dog", 0));
        persons.add(new Mascota(R.drawable.dog2, "Dog 2", 0));
        persons.add(new Mascota( R.drawable.fish, "Fish" , 0));
        persons.add(new Mascota( R.drawable.frog, "Frog" , 0));
        persons.add(new Mascota( R.drawable.guinea, "Guinea" , 0));
        persons.add(new Mascota(R.drawable.horse, "Horse", 0));
        persons.add(new Mascota(R.drawable.pet, "Pet 1", 0));
        persons.add(new Mascota(R.drawable.pet3, "Pet 3", 0));
    }


    private void initializeAdapter(){
        MyAdapter adapter = new MyAdapter(persons);
        rv.setAdapter(adapter);
    }
}
