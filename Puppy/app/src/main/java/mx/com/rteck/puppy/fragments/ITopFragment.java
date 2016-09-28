package mx.com.rteck.puppy.fragments;

import java.util.ArrayList;

import mx.com.rteck.puppy.adapter.MiPerroAdaptador;
import mx.com.rteck.puppy.pojo.FotosMiPerro;
import mx.com.rteck.puppy.pojo.MiPerro;

/**
 * Created by Gerardo Monreal J on 15/09/2016.
 */

public interface ITopFragment {
    public void generarGridLayout();
    public MiPerroAdaptador crearAdaptador(ArrayList<FotosMiPerro>fotos);
    public void inicializarAdaptarodRV(MiPerroAdaptador adaptador);
    public void inicializarPerfil(String nombre,String url);
}
