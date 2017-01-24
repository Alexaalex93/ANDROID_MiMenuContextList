package com.example.alex.mimenucontextlist;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] info = {"Carlos Marx", "Aristoteles", "Ortega", "Kant", "Descartes", "Sócrates"};
    private String[] info2 = {"Carlos Marx", "Ortega", "Sócrates"};


    int pos_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    /*
        ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.fila, info);
        ListView lv = (ListView) findViewById(R.id.lista_pensadores);

        lv.setAdapter(listAdapter);

        registerForContextMenu(lv);
*/
        Button button = (Button) findViewById(R.id.accede);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Dialog ad = new Dialog(MainActivity.this);
                ad.setContentView(R.layout.alert_dialog);
                ad.show();*/

                //ESTAMOS CREANDO UN LAYOUT SOBRE LA MARCHA
                //////////////
                //Creo el layout que quiero ponerle al toast
                LinearLayout ll = new LinearLayout(MainActivity.this);

                TextView tv = new TextView(MainActivity.this);
                tv.setText("Hola hola");

                ll.addView(tv);
                ///////////////

                //CREO EL TOAST Y LO SOBREESCRIBO CON EL LAYOUT
                Toast toast = Toast.makeText(MainActivity.this, "Chao", Toast.LENGTH_LONG);
                toast.setView(ll); //ASOCIADO EL LINEAR LAYOUT AL TOAST

                toast.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, 1, 1, "01");
        menu.add(Menu.NONE, 2, 2, "02");
        menu.add(Menu.NONE, 3, 3, "03");

        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;//Para ver que posicion del menu se ha tocado
        pos_selected = acmi.position;//Posicion del listView


    }
    /*
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Log.d(getClass().getCanonicalName(),"ITEM MENU = " + item.getItemId() + " seleccionado "); //Posicion del menu seleccionable

        ListView lv = (ListView) findViewById(R.id.lista_pensadores);

        String filosofo = (String) lv.getItemAtPosition(pos_selected);
        Log.d(getClass().getCanonicalName(),"FILOSOFO = " + filosofo + " seleccionado ");

        ListAdapter listAdapter2 = new ArrayAdapter<String>(this, R.layout.fila, info2);
        lv.setAdapter(listAdapter2);

        return super.onContextItemSelected(item);
    }

*/
    @Override
    public void onBackPressed() {
        //CREAR MENU DE SEGURIDAD -DIALOGO
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Salir");
        alertDialog.setMessage("¿Desea salir?");

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();

            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                MainActivity.this.finish();//context es MainActivity,this!

            }
        });

        alertDialog.show();

    }
}


