package mx.com.rteck.puppy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import java.util.ArrayList;

import mx.com.rteck.puppy.adapter.PerroAdaptador;
import mx.com.rteck.puppy.pojo.Perro;
import mx.com.rteck.puppy.presentador.ITopActivityPresentador;
import mx.com.rteck.puppy.presentador.TopActivityPresentador;

import static android.app.PendingIntent.getActivity;



public class TopActivity extends AppCompatActivity implements ITopActivity{
    ArrayList<Perro> perros;
    private RecyclerView listaPerros;

    private ITopActivityPresentador presentador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        Toolbar miAccionBar = (Toolbar) findViewById(R.id.miAccionBar);
        setSupportActionBar(miAccionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaPerros =   (RecyclerView)  findViewById(R.id.rvPerros);
        presentador=new TopActivityPresentador(this, getApplicationContext());
        //inicializarPerros();
        //inicializarAdaptador();

    }

   /* public void inicializarPerros()
    {
        perros =    new ArrayList<Perro>();
        perros.add(new Perro("Lobo",3,R.drawable.perro1));
        perros.add(new Perro("Charlie",4,R.drawable.perro2));
        perros.add(new Perro("Puppy",5,R.drawable.perro3));
        perros.add(new Perro("Cookie",2,R.drawable.perro4));
        perros.add(new Perro("Woody",3,R.drawable.perro5));
    }

    public void inicializarAdaptador()
    {
        PerroAdaptador adaptador = new PerroAdaptador(perros,this);
        listaPerros.setAdapter(adaptador);
    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayout.VERTICAL);
        listaPerros.setLayoutManager(llm);
    }

    @Override
    public PerroAdaptador crearAdaptador(ArrayList<Perro> perros) {
         PerroAdaptador adaptador;adaptador= new PerroAdaptador(perros,this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(PerroAdaptador perroAdaptador) {
        listaPerros.setAdapter(perroAdaptador);
    }
}
