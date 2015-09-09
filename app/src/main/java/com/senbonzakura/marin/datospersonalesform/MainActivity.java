package com.senbonzakura.marin.datospersonalesform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText Nombre;
    private NumberPicker pickerday;
    private NumberPicker pickermonth;
    private NumberPicker pickeryear;
    private RadioButton Man;
    private RadioButton Woman;
    private Button send;
    private String[] years;
     private String[] months;
    private String[]  days;
    private String fecha;
    private String fecha1;
    private String fecha2;
    private String fecha3;
    String genero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         months = new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
         years = new String[] {"1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995",
                "1995","1996","1998","1999","2000","2001","2002","2003","2004","2005",};
        days=new String[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16",
                "17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

        Nombre = (EditText) findViewById(R.id.edt1) ;
        send = (Button) findViewById(R.id.button);
        Man = (RadioButton) findViewById(R.id.radioButton);
        Woman = (RadioButton) findViewById(R.id.radioButton2);
        pickermonth = (NumberPicker)findViewById(R.id.numberPicker);
        pickerday = (NumberPicker)findViewById(R.id.numberPicker3);
        pickeryear = (NumberPicker)findViewById(R.id.numberPicker2);

        pickermonth.setMinValue(0);
        pickermonth.setMaxValue(11);
        pickerday.setMinValue(0);
        pickerday.setMaxValue(30);
        pickeryear.setMinValue(0);
        pickeryear.setMaxValue(19);
        pickerday.setDisplayedValues(days);
        pickeryear.setDisplayedValues(years);
        pickermonth.setDisplayedValues(months);
        pickerday.setWrapSelectorWheel(true);
        pickermonth.setWrapSelectorWheel(true);
        pickeryear.setWrapSelectorWheel(true);

        pickerday.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String pikday = days[newVal];
                fecha1 =pikday;
            }
        });
        pickermonth.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String pikmonth = months[newVal];
                fecha2=pikmonth;
            }
        });
        pickeryear.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String pikyear = years[newVal];
                fecha3 = pikyear;
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                String nombre = Nombre.getText().toString();

                fecha = fecha1 +"/" +fecha2+"/"+fecha3;
                System.out.println("prueba "+nombre+" "+genero + " "+ fecha);
                i.putExtra("Nombre",nombre);
                i.putExtra("Fecha",fecha);
                i.putExtra("Genre",genero);
                startActivity(i);
            }
        });

    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    // Pirates are the best
                genero="Hombre";
                    break;
            case R.id.radioButton2:
                if (checked)
                    genero = "Mujer";
                    // Ninjas rule
                    break;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
