package mx.com.rteck.puppy;

import java.util.ArrayList;

import mx.com.rteck.puppy.adapter.PerroAdaptador;
import mx.com.rteck.puppy.pojo.Perro;

/**
 * Created by Gerardo Monreal J on 01/09/2016.
 */

public interface ITopActivity {
    public void generarLinearLayoutVertical();
    public PerroAdaptador crearAdaptador(ArrayList<Perro>perros);
    public void inicializarAdaptador(PerroAdaptador perroAdaptador);
}
