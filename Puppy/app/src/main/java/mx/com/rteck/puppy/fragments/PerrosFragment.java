package mx.com.rteck.puppy.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import mx.com.rteck.puppy.R;
import mx.com.rteck.puppy.adapter.PerroAdaptador;
import mx.com.rteck.puppy.pojo.Perro;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerrosFragment extends Fragment {
    ArrayList<Perro> perros;
    private RecyclerView listaPerros;

    public PerrosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perros, container, false);
        listaPerros =   (RecyclerView)  v.findViewById(R.id.rvPerros);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayout.VERTICAL);
        listaPerros.setLayoutManager(llm);

        inicializarPerros();
        inicializarAdaptador();
        return v;
    }

    public void inicializarPerros()
    {
        perros =    new ArrayList<Perro>();
        perros.add(new Perro("Lobo",3,R.drawable.perro1,0));
        perros.add(new Perro("Charlie",4,R.drawable.perro2,1));
        perros.add(new Perro("Puppy",5,R.drawable.perro3,2));
        perros.add(new Perro("Cookie",2,R.drawable.perro4,3));
        perros.add(new Perro("Woody",3,R.drawable.perro5,4));
    }

    public PerroAdaptador adaptador;
    public void inicializarAdaptador()
    {
        adaptador = new PerroAdaptador(perros,getActivity());
        listaPerros.setAdapter(adaptador);
    }

}
