package mx.com.rteck.puppy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.com.rteck.puppy.pojo.Perro;

/**
 * Created by Gerardo Monreal J on 01/09/2016.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context)
    {
        super(context, ConstantesBasesDatos.DATA_BASE_NAME, null,ConstantesBasesDatos.DATA_BASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaPerro="CREATE TABLE "+ConstantesBasesDatos.TABLE_PERRO  +  "("
                +ConstantesBasesDatos.TABLE_PERRO_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +ConstantesBasesDatos.TABLE_PERRO_NOMBRE+" TEXT, "
                +ConstantesBasesDatos.TABLE_PERRO_NUMERO_LIKES+" INTEGER, "
                +ConstantesBasesDatos.TABLE_PERRO_FOTO+" INTEGER, "
                +ConstantesBasesDatos.TABLE_PERRO_PERRO_ID+" INTEGER, "
                +ConstantesBasesDatos.TABLE_PERRO_TOP+" INTEGER"
                + ")";

        db.execSQL(queryCrearTablaPerro);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBasesDatos.TABLE_PERRO);
    }



    public int checarPerro(Perro perro)
    {
        String query = "SELECT * FROM "+ConstantesBasesDatos.TABLE_PERRO+" WHERE "+ConstantesBasesDatos.TABLE_PERRO_PERRO_ID
                        +"= "+perro.getId();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registro= db.rawQuery(query,null);

        if(registro.moveToNext())
        {
            return registro.getInt(5);
        }
        else
        {
            return 0;
        }
    }

    public void insertarPerro(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBasesDatos.TABLE_PERRO,null,contentValues);
        db.close();
    }

    public void mueveTopPerros(int i)
    {
        String query = "UPDATE "+ConstantesBasesDatos.TABLE_PERRO
                        +"  SET "+ConstantesBasesDatos.TABLE_PERRO_TOP+" = "+ConstantesBasesDatos.TABLE_PERRO_TOP+" +1"
                        +" WHERE "+ConstantesBasesDatos.TABLE_PERRO_TOP+" < "+i;
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery(query,null);
        db.close();
    }

    public void mueveTodosPerros()
    {
        String query = "UPDATE "+ConstantesBasesDatos.TABLE_PERRO
                +" SET "+ConstantesBasesDatos.TABLE_PERRO_TOP+" ="+ConstantesBasesDatos.TABLE_PERRO_TOP+" +1";
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery(query,null);
        db.close();
    }

    public  void primerLugarTop(Perro perro)
    {
        String query = "UPDATE "+ConstantesBasesDatos.TABLE_PERRO
                +" SET "+ConstantesBasesDatos.TABLE_PERRO_TOP+" = 1"
                +" WHERE "+ConstantesBasesDatos.TABLE_PERRO_PERRO_ID+ " = "+ perro.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery(query,null);
        db.close();
    }

    public ArrayList<Perro> obtenerTop()
    {
        ArrayList<Perro>perros = new ArrayList<>();
        String query = "SELECT * FROM "+ConstantesBasesDatos.TABLE_PERRO+
                        " ORDER BY "+ConstantesBasesDatos.TABLE_PERRO_TOP+" DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);

        while (registros.moveToNext())
        {
            Perro perro = new Perro();
            perro.setNombre(registros.getString(1));
            perro.setLikes(registros.getInt(2));
            perro.setFoto(registros.getInt(3));
            perro.setId(registros.getInt(4));
            perros.add(perro);
        }
        db.close();
        return perros;

    }
}
