package uta.fisei.matza_nunez_examen_01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Pantalla2Activity_MJ_NS extends AppCompatActivity {


    EditText editTextnumero ;
    int contador =0;
    List<String> lstDatos = new ArrayList<String>();
    ListView listViewDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2_mj_ns);


        editTextnumero = findViewById(R.id.editTextNumero);
        listViewDatos = findViewById(R.id.listViewDatos);
    }


    public void  ingresar (View view){

        String numero = editTextnumero.getText().toString();
        lstDatos.add(numero);
        contador++;

        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,lstDatos);
        listViewDatos.setAdapter(adapter);
        editTextnumero.setText("");
    }



    public void cerrar (View view) {


        String[] lstDatosSalida = new String[contador];
        for (int i=0; i<contador;i++){
            lstDatosSalida[i]=lstDatos.get(i);
        }

        Intent intent = new Intent();
        intent.putExtra("lstDatos", lstDatosSalida);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}