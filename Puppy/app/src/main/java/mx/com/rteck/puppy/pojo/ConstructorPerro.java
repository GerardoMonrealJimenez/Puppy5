package mx.com.rteck.puppy.pojo;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.com.rteck.puppy.db.BaseDatos;
import mx.com.rteck.puppy.db.ConstantesBasesDatos;

/**
 * Created by Gerardo Monreal J on 06/09/2016.
 */

public class ConstructorPerro {

    private Context context;
    private static final int TOP = 1;

    public ConstructorPerro(Context context)
    {
        this.context = context;
    }

    public ArrayList<Perro>obtenerTop()
    {
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerTop();
    }

    public void insertarPerro(Perro perro)
    {
        BaseDatos bd = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBasesDatos.TABLE_PERRO_NOMBRE,perro.getNombre());
        contentValues.put(ConstantesBasesDatos.TABLE_PERRO_NUMERO_LIKES,perro.getLikes());
        contentValues.put(ConstantesBasesDatos.TABLE_PERRO_FOTO,perro.getFoto());
        contentValues.put(ConstantesBasesDatos.TABLE_PERRO_PERRO_ID,perro.getId());
        contentValues.put(ConstantesBasesDatos.TABLE_PERRO_TOP,TOP);
        bd.insertarPerro(contentValues);
    }

    public void checarPerro(Perro perro)
    {
        BaseDatos bd = new BaseDatos(context);
        int i = bd.checarPerro(perro);
        if(i>0)
        {
            bd.mueveTopPerros(i);
            bd.primerLugarTop(perro);
        }
        else
        {
            bd.mueveTodosPerros();
            insertarPerro(perro);
        }
        bd.close();
    }
}
