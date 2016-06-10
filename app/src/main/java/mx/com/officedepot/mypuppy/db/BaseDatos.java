package mx.com.officedepot.mypuppy.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.com.officedepot.mypuppy.pojo.Mascota;

/**
 * Created by VillaVargas on 08/06/16.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE  "+ ConstantesBaseDatos.TABLE_MASCOTA +" (" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_BONE1+ " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_BONE2 + " INTEGER " +
                " )";

        String queryCrearTablaRatingMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_RATING_MASCOTA + " ("+
                ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_RATING_MASCOTA_NUMERO_RATING + " INTEGER, " +
                " FOREIGN KEY (" + ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA + ") " +
                " REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + "("+ ConstantesBaseDatos.TABLE_MASCOTA_ID +")" +
                " )";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaRatingMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_RATING_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasMascotas(){
        ArrayList<Mascota> pets = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;

        // Abrir la base de datos en forma de lectura o escritura

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros  = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota petActual  = new Mascota();
            petActual.setId(registros.getInt(0));
            petActual.setNombre_mascota(registros.getString(1));
            petActual.setFoto(registros.getInt(2));
            petActual.setBone(registros.getInt(3));
            petActual.setBone2(registros.getInt(4));

            pets.add(petActual);
        }

        db.close();

        return pets;
    }


    public void insertarMascotas(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }


    public void insertarRatingMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(ConstantesBaseDatos.TABLE_RATING_MASCOTA, null, contentValues);
        db.close();
    }


    public int obtenerRatingMascota (Mascota pet){
       int rating = 0;

        String sql = "SELECT " + ConstantesBaseDatos.TABLE_RATING_MASCOTA_NUMERO_RATING +
                " FROM " + ConstantesBaseDatos.TABLE_RATING_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA + " = " + pet.getId();

       SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(sql, null);

        if (registros.moveToNext()){
            rating = registros.getInt(0);
        }

        db.close();

        return rating;

    }
}
