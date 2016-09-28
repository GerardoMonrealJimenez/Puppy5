package mx.com.rteck.puppy.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.com.rteck.puppy.R;
import mx.com.rteck.puppy.adapter.MiPerroAdaptador;
import mx.com.rteck.puppy.adapter.PerroAdaptador;
import mx.com.rteck.puppy.pojo.FotosMiPerro;
import mx.com.rteck.puppy.pojo.MiPerro;
import mx.com.rteck.puppy.pojo.Perro;
import mx.com.rteck.puppy.presentador.ITopFragmentPresentador;
import mx.com.rteck.puppy.presentador.TopFragmentPresentador;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment implements ITopFragment{

    MiPerro miPerro;

    private RecyclerView listaPerros;
    private CircularImageView imgPerfil;
    private TextView nombrePerfil;
    private ITopFragmentPresentador presentador;
    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_top, container, false);
        listaPerros =(RecyclerView) v.findViewById(R.id.rvMiPerro);

        imgPerfil = (CircularImageView)v.findViewById(R.id.imgPerfil);
        nombrePerfil = (TextView)v.findViewById(R.id.tvNombrePerfil);

        presentador = new TopFragmentPresentador(this,getContext());

        return v;
    }

    public void inicializarPerros()
    {
        /*miPerros =    new ArrayList<MiPerro>();
        miPerros.add(new MiPerro(R.drawable.miperro,3));
        miPerros.add(new MiPerro(R.drawable.miperro,4));
        miPerros.add(new MiPerro(R.drawable.miperro,5));
        miPerros.add(new MiPerro(R.drawable.miperro,2));
        miPerros.add(new MiPerro(R.drawable.miperro,3));*/
    }

    public MiPerroAdaptador adaptador;
   /* public void inicializarAdaptador()
    {
        adaptador = new MiPerroAdaptador(miPerros,getActivity());
        listaPerros.setAdapter(adaptador);
    }*/

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);

        listaPerros.setLayoutManager(glm);
    }

    @Override
    public MiPerroAdaptador crearAdaptador(ArrayList<FotosMiPerro> fotos) {
        MiPerroAdaptador adaptador = new MiPerroAdaptador(fotos,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptarodRV(MiPerroAdaptador adaptador) {

        listaPerros.setAdapter(adaptador);
    }


    @Override
    public void inicializarPerfil(String nombre, String url) {
        Picasso.with(getContext())
                .load(url)
                .placeholder(R.drawable.bonec)
                .into(imgPerfil);

        nombrePerfil.setText(nombre);
    }


}
