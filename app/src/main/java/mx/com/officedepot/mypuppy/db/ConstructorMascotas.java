package mx.com.officedepot.mypuppy.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.com.officedepot.mypuppy.R;
import mx.com.officedepot.mypuppy.pojo.Mascota;

/**
 * Created by VillaVargas on 08/06/16.
 *
 * Clase Interactor. Que es una clase intermedia con la clase que consulta la BD
 *
 */


public class ConstructorMascotas {

    private Context contex;

    public ConstructorMascotas(Context contex) {
            this.contex = contex;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /* ArrayList<Mascota> pets = new ArrayList<Mascota>();
        pets.add(new Mascota(R.drawable.cat, "Cat" , 0,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.dog, "Dog", 0,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.dog2, "Dog 2", 0,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota( R.drawable.fish, "Fish" , 0,R.drawable.ic_bone,R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.frog, "Frog", 0, R.drawable.ic_bone, R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.guinea, "Guinea", 0, R.drawable.ic_bone, R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.horse, "Horse", 0, R.drawable.ic_bone, R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.pet, "Pet 1", 0, R.drawable.ic_bone, R.drawable.ic_rating));
        pets.add(new Mascota(R.drawable.pet3, "Pet 3", 0,R.drawable.ic_bone,R.drawable.ic_rating));*/

        BaseDatos db = new BaseDatos(contex);
        insertarDiezMascotas(db);

      return db.obtenerTodasMascotas();
    }


    public void insertarDiezMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Cat");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.cat);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_BONE1, R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_BONE2, R.drawable.ic_rating);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Dog");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_BONE1, R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_BONE2, R.drawable.ic_rating);

        db.insertarMascotas(contentValues);


        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Fish");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.fish);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_BONE1, R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_BONE2, R.drawable.ic_rating);

        db.insertarMascotas(contentValues);
    }


    public void darRatingMascota(Mascota pet){

        BaseDatos db = new BaseDatos(contex);
        ContentValues contentValues = new ContentValues();

        System.out.println("rait: " + pet.getRait() );
        contentValues.put(ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA, pet.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RATING_MASCOTA_NUMERO_RATING, pet.getRait());

        db.insertarRatingMascota(contentValues);

    }


    public int obtenerRatingMascota(Mascota pet){

      BaseDatos db = new BaseDatos(contex);

        return  db.obtenerRatingMascota(pet);
    }
}
