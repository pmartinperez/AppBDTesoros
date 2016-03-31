package com.patriciamape.appbdtesoros;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patri on 07/02/2016.
 */
public class MapaItem extends AppCompatActivity {
    private TesoroDataSource datasource;
    private int idIntent;
    private String nombreIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa_item);

        Intent mapaIntent = getIntent();
        // parametros: String mensaje, int valor por defecto
        idIntent = mapaIntent.getIntExtra("tesoroID", 1);
        nombreIntent = mapaIntent.getStringExtra("tesoroNombre");

        datasource = new TesoroDataSource(this);
        datasource.open();

        // Creamos un array con todos los objetos de la BD
        ArrayList<Pista> arrayPistas = new ArrayList<>(datasource.getAllPistasByID(idIntent));
        // Creamos un boton para cada pista del tesoro

        for(int i=0; i<arrayPistas.size(); i++) {
            Button button = new Button(this);
            Pista pista = arrayPistas.get(i);
            button.setText(pista.getNombrePista());
            button.setId(pista.getIdPista());

            int visible = pista.getRespuesta();
            /*if(visible == 0){
                button.setEnabled(false);
            }*/

            // Introducimos el boton en el layout
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutLinear);

            linearLayout.addView(button);

            // Metodo onClick del boton. Muestra la pista.
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (view.isEnabled()) {
                        //Intent pistaIntent = new Intent(MapaItem.this, PistaItem.class);
                        //pistaIntent.putExtra("pistaID", view.getId());
                        //startActivity(pistaIntent);
                        Toast.makeText(MapaItem.this, "Pista" + view.getId(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MapaItem.this, "Pista" + view.getId(), Toast.LENGTH_SHORT).show();

                    }
                }
            });



        }

    }


}
