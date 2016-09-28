package mx.com.rteck.puppy.presentador;

import android.content.Context;

import java.security.AccessControlContext;
import java.util.ArrayList;

import mx.com.rteck.puppy.ITopActivity;
import mx.com.rteck.puppy.pojo.ConstructorPerro;
import mx.com.rteck.puppy.pojo.Perro;

/**
 * Created by Gerardo Monreal J on 01/09/2016.
 */

public class TopActivityPresentador implements ITopActivityPresentador{

    private ITopActivity iTopActivity;
    private Context context;
    private ConstructorPerro constructorPerro;
    private ArrayList<Perro>perros;

    public TopActivityPresentador(ITopActivity iTopActivity, Context context)
    {
        this.iTopActivity=iTopActivity;
        this.context=context;
        obtenerPerros();
    }


    @Override
    public void obtenerPerros() {
        constructorPerro = new ConstructorPerro(context);
        perros=constructorPerro.obtenerTop();
        mostrarPerrosRV();
    }

    @Override
    public void mostrarPerrosRV() {
        iTopActivity.inicializarAdaptador(iTopActivity.crearAdaptador(perros));
        iTopActivity.generarLinearLayoutVertical();
    }
}
