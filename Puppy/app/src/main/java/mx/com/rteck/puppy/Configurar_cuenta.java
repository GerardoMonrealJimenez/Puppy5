package mx.com.rteck.puppy;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Configurar_cuenta extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);
        Toolbar miAccionBar = (Toolbar) findViewById(R.id.miAccionBar);
        setSupportActionBar(miAccionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void guardarCuenta(View v)
    {
        SharedPreferences cuenta = getSharedPreferences("Cuenta", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = cuenta.edit();



        TextInputEditText inp = (TextInputEditText) findViewById(R.id.inp_cuenta);

        String nombre_cuenta = inp.getText().toString();

        editor.putString("cuenta",nombre_cuenta);

        editor.commit();

        Toast.makeText(Configurar_cuenta.this,"Se ha guardado la cuenta: "+nombre_cuenta,Toast.LENGTH_LONG);

        inp.setText("");
    }
}
