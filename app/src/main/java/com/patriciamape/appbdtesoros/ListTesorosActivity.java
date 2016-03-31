package com.patriciamape.appbdtesoros;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

//Lista con los tesoros de la BD
public class ListTesorosActivity extends ListActivity {
    private TesoroDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list_tesoros);

        datasource = new TesoroDataSource(this);
        datasource.open();

        //Rellena la lista con los objetos de la BD
        populateTesoroList();

        //Metodo onClick de la lista
        final ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Tesoro tesoro = (Tesoro) (listView.getItemAtPosition(position));
                Intent mapaIntent = new Intent(ListTesorosActivity.this, MapaItem.class);
                mapaIntent.putExtra("tesoroID", tesoro.getId());
                mapaIntent.putExtra("tesoroNombre", tesoro.getNombre());
                startActivity(mapaIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_tesoros, menu);
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


    @Override
    protected void onResume() {
        super.onResume();
        datasource.open();
    }

    @Override
    protected void onStop() {
        super.onStop();
        datasource.close();
    }

    private void populateTesoroList() {
        // Creamos un array con todos los objetos de la BD
        ArrayList<Tesoro> arrayTesoros = new ArrayList<>(datasource.getAllTesoros());
        // Creamos el adaptador para convertir los objetos del array en vistas
        CustomAdapter adapter = new CustomAdapter(this, arrayTesoros);
        // Incluimos el adaptador en el ListView
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
    }
}
