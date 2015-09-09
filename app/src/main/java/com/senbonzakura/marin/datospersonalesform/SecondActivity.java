package com.senbonzakura.marin.datospersonalesform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText edt_nombre;
    EditText edt_fechanat;
    EditText edt_genresel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edt_nombre = (EditText) findViewById(R.id.edt2);
        edt_fechanat = (EditText) findViewById(R.id.edt3);
        edt_genresel = (EditText) findViewById(R.id.edt4);
        Intent i = getIntent();
        Bundle bundle=i.getExtras();
        if(bundle !=null){
            String name = (String) bundle.get("Nombre");
            String nacido = (String) bundle.get("Fecha");
            String genero = (String) bundle.get("Genre");
            edt_nombre.setText(name);
            edt_fechanat.setText(nacido);
            edt_genresel.setText(genero);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
