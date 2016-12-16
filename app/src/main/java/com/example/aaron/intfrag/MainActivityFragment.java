package com.example.aaron.intfrag;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private EditText txtNombre;
    private Button btnAceptar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vistainflater = inflater.inflate(R.layout.fragment_main, container, false);
        Button boton = (Button) vistainflater.findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                startActivity(intent);

                //Obtenemos una referencia a los controles de la interfaz
                txtNombre = (EditText)findViewById(R.id.txtNombre);
                btnAceptar = (Button)findViewById(R.id.btnAceptar);

                //Implementamos el evento click del botón
                btnAceptar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //Creamos el Intent
                        Intent intent = new Intent(MainActivityFragment.this, Main2ActivityFragment.class);
                        //Creamos la información a pasar entre actividades
                        Bundle b = new Bundle();
                        b.putString("NOMBRE",txtNombre.getText().toString());
                        //añadimos la informacion al intent
                        intent.putExtras(b);
                        //iniciamos la nueva actividad
                        startActivity(intent);
                    }

                });
            }

        });


        return vistainflater;


    }
}
