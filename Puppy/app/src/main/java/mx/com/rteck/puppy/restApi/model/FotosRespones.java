package mx.com.rteck.puppy.restApi.model;

import java.util.ArrayList;

import mx.com.rteck.puppy.pojo.FotosMiPerro;

/**
 * Created by Gerardo Monreal J on 15/09/2016.
 */

public class FotosRespones {
    ArrayList<FotosMiPerro> fotos;

    public ArrayList<FotosMiPerro> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<FotosMiPerro> fotos) {
        this.fotos = fotos;
    }
}
