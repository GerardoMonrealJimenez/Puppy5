package mx.com.rteck.puppy.pojo;

/**
 * Created by Gerardo Monreal J on 27/09/2016.
 */

public class Perfil {
    private String nombre;
    private String urlFotoPerfil;
    private long id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFotoPerfil() {
        return urlFotoPerfil;
    }

    public void setUrlFotoPerfil(String urlFotoPerfil) {
        this.urlFotoPerfil = urlFotoPerfil;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
