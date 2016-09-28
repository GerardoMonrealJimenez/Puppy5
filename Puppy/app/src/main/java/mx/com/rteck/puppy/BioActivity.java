package mx.com.rteck.puppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class BioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        Toolbar miAccionBar = (Toolbar) findViewById(R.id.miAccionBar);
        setSupportActionBar(miAccionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
