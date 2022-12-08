package uta.fisei.matza_nunez_examen_01;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Pantalla1Activity_MJ_NS extends AppCompatActivity {


    String[] lstDatosRecibidos;



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
    }



    public void segundoActivity (View view) {
        Intent intent = new Intent(this,Pantalla2Activity_MJ_NS.class);
        activityResult.launch(intent);
    }
}