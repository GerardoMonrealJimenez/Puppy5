package mx.com.rteck.puppy.pojo;

import java.util.ArrayList;

/**
 * Created by Gerardo Monreal J on 23/08/2016.
 */

public class MiPerro {

    private Perfil miPerfil;
    private ArrayList<FotosMiPerro> fotos;

    public Perfil getMiPerfil() {
        return miPerfil;
    }

    public void setMiPerfil(Perfil miPerfil) {
        this.miPerfil = miPerfil;
    }

    public ArrayList<FotosMiPerro> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<FotosMiPerro> fotos) {
        this.fotos = fotos;
    }
}
