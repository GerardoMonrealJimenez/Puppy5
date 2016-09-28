package mx.com.rteck.puppy.restApi.model;

import mx.com.rteck.puppy.pojo.MiPerro;
import mx.com.rteck.puppy.pojo.Perfil;

/**
 * Created by Gerardo Monreal J on 15/09/2016.
 */

public class MiperroResponse {

    private Perfil miPerfil;

    public Perfil getMiPerfil() {
        return miPerfil;
    }

    public void setMiPerfil(Perfil miPerfil) {
        this.miPerfil = miPerfil;
    }
}
