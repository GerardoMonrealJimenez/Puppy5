package mx.com.rteck.puppy.restApi;

import android.content.Context;
import android.content.SharedPreferences;



/**
 * Created by Gerardo Monreal J on 15/09/2016.
 */

public class ConstantesRestApi {

    public static final String VERSION ="/v1/";
    public static final String URL ="https://api.instagram.com"+VERSION;
    public static final String ACCES_TOKEN ="3903099767.9980a17.7244b2ce126e45d2bf11504f412bfc16";

    // fotos de mi perfil
    public static final String KEY_ACCES_TOKE ="?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER ="users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER =KEY_GET_RECENT_MEDIA_USER+KEY_ACCES_TOKE+ACCES_TOKEN;

    //perfil

    public static final String KEY_GET_SEARCH_USER = "users/search";
    public static final  String URL_GET_USER_INFOTMATION=KEY_GET_SEARCH_USER+KEY_ACCES_TOKE+ACCES_TOKEN;

    //fotos del perfil seleccionado

    public static final String KEY_GET_MEDIA_USER="users/{id}/media/recent/";
    public static final String URL_MEDIA_USER=KEY_GET_MEDIA_USER+KEY_ACCES_TOKE+ACCES_TOKEN;






}
