package com.example.tpsqlpolshu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.tpsqlpolshu.fragments.InsertarFragment;


public class MainActivity extends AppCompatActivity {

    InsertarFragment insertarFragment;
    //ListadoFragment listadoFragment;
    Button btnListado;
    Button btnInsertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        obtenerReferencias();
        CrearFragments();
        setearListeners();
        //irAFragmentListado();
    }

    private void obtenerReferencias(){
        btnListado  = (Button) findViewById(R.id.btnListado);
        btnInsertar = (Button) findViewById(R.id.btnInsertar);
    }

    private void CrearFragments() {
        insertarFragment = new InsertarFragment();
        //listadoFragment  = new ListadoFragment();
    }

    private void setearListeners() {
        //btnListado.setOnClickListener(v -> { irAFragmentListado(); });
        btnInsertar.setOnClickListener(v -> { irAFragmentInsertar(); });
    }

    //public void irAFragmentListado() { ReemplazarFragment(listadoFragment);}

    public void irAFragmentInsertar() {ReemplazarFragment(insertarFragment);}

    public void ReemplazarFragment (Fragment fragmento){
        ReemplazarFragment(fragmento,true);
    }

    public void ReemplazarFragment (Fragment fragmento, boolean blnAddBackToStack){
        FragmentManager manager;
        FragmentTransaction transaction;

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        transaction.replace(R.id.framecontenedor,fragmento,null);
        if (blnAddBackToStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}