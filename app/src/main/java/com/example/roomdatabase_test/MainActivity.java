package com.example.roomdatabase_test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mTextoNota;
    private Button mGuardar;
    private Button mBorrar;

    private PuntajeLab PuntajeLab;
    private Puntaje puntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextoNota = findViewById(R.id.texto_nota);

        PuntajeLab = PuntajeLab.get(this);
        List<Puntaje> notas = PuntajeLab.getPuntaje();
        if(notas.size() > 0) {
            puntaje = notas.get(0);
            mTextoNota.setText(puntaje.getMensaje());
        }

        mGuardar = findViewById(R.id.boton_guardar);
        mGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        mBorrar = findViewById(R.id.boton_borrar);
        mBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrar();
            }
        });

    }

    /**
     * Borra la nota si existe (si mNota no es null).
     */
    private void borrar() {
        if(puntaje != null) {
            PuntajeLab.deletePuntaje(puntaje);
            puntaje = null;
            mTextoNota.setText("");
            Toast.makeText(this, getString(R.string.puntaje_borrado),
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.puntaje_no_existe),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Guarda la nota si no existe (mNota es null), o la actualiza si existe.
     */
    private void guardar() {
        String textoPuntaje = mTextoNota.getText().toString();
        if(!textoPuntaje.equals("")) {
            if(puntaje == null) {
                puntaje = new Puntaje();
                puntaje.setMensaje(textoPuntaje);
                PuntajeLab.addPuntaje(puntaje);
                Toast.makeText(this, getString(R.string.puntaje_creado),
                        Toast.LENGTH_SHORT).show();
            } else {
                puntaje.setMensaje(textoPuntaje);
                PuntajeLab.updatePuntaje(puntaje);
                Toast.makeText(this, getString(R.string.puntaje_actualizada),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, getString(R.string.crea_puntaje_primero),
                    Toast.LENGTH_SHORT).show();
        }
    }
}