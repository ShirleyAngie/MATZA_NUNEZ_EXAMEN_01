package uta.fisei.matza_nunez_examen_01;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Pantalla1Activity_MJ_NS extends AppCompatActivity {


    String[] lstDatosRecibidos;
    ListView listViewDatosOriginal;
    ListView listViewDatosIndice;
    List<String> lstDatos = new ArrayList<String>();

    List<String> lstDatosIndice = new ArrayList<String>();

    ActivityResultLauncher<Intent> activityResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {


                    if (result.getResultCode() == Activity.RESULT_OK)
                    {

                        Intent data = result.getData();

                        Bundle datos = result.getData().getExtras();
                        lstDatosRecibidos = datos.getStringArray("lstDatos");

                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1_mj_ns);
        listViewDatosOriginal = findViewById(R.id.listViewOriginal);
        listViewDatosIndice = findViewById(R.id.listViewIndice);
    }



    public void segundoActivity (View view) {
        Intent intent = new Intent(this,Pantalla2Activity_MJ_NS.class);
        activityResult.launch(intent);
    }



    public void mostrar(View view) {

        for (int i=0; i<lstDatosRecibidos.length;i++){
            //lstDatosSalida[i]=lstDatos.get(i);
            lstDatos.add(lstDatosRecibidos[i]);
        }

        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,lstDatos);

        listViewDatosOriginal.setAdapter(adapter);



        int[] lstnumeros = new int[lstDatosRecibidos.length];
        for (int j=0 ; j<lstDatosRecibidos.length;j++){
            lstnumeros[j]= Integer.valueOf(lstDatosRecibidos[j]);
        }


        int[] ordenados = mayorMenor(lstnumeros);

        for (int h=0; h<ordenados.length;h++){

            lstDatosIndice.add(String.valueOf(ordenados[h]));
        }

        ArrayAdapter<String> adapterIndice  = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,lstDatosIndice);

        listViewDatosIndice.setAdapter(adapterIndice);

    }




    int aux;
    public int[]  mayorMenor(int[] lst){
        int i=0;
        while (i<lst.length-1) {
            int j=i+1;
            while (j < lst.length){
                if (lst[i] < lst[j]){
                    aux = lst[i];
                    lst[i]=lst[j];
                    lst[j]=aux;
                }
                j++;
            };
            i++;
        } ;

        return lst;

    }


    public int[]  mayorMenorIndice(int[] ordenado, int[] lst2){


        for (int i = 0; i < lst2.length; i++)
        {
            Log.i("sasda", String.valueOf(lst2[i]));
        }



        return ordenado;

    }

    public static int buscar(int[] a, int target)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == target) {
                return i;
            }
        }

        return -1;
    }
}