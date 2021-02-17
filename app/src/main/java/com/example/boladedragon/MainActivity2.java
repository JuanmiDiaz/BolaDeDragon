package com.example.boladedragon;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    //variables que se usan durante todo el activity
    EditText txtNombre;
    EditText txtMail;
    EditText txtPass;
    Button botonRegistrar;
    private DatabaseReference Jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Abrimos la conección a la base de datos
        Jugadores = FirebaseDatabase.getInstance().getReference("Jugadores");
        txtNombre =(EditText) findViewById(R.id.etNombre);
        botonRegistrar =(Button) findViewById(R.id.btnRegistro);
        //Botón para un primer guardado del nombre del jugador
        findViewById(R.id.btnJugar).setOnClickListener(this);
        botonRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                registrarJugador();
            }
        });
        //Botón para pasar a la siguiente pantalla e iniciar el juego
        findViewById(R.id.btnJugar).setOnClickListener(this);
    }

    //Función para guardar los datos de esta pantalla a la base de datos
   public void registrarJugador(){
        String nombre = txtNombre.getText().toString();

        //Condición para no dejar el campo nombre vacio
        if(!TextUtils.isEmpty(nombre)){
            String id = Jugadores.push().getKey();
            Jugadores jugador = new Jugadores(id, nombre);
            System.out.println("Envio a la base de datos");
            Jugadores.child("Jugadores").child(id).setValue(jugador);

        }else{
            Toast.makeText(this,"Debe introducir un nombre", Toast.LENGTH_LONG).show();
        }
    }


    //Función del boton de pasar de pantalla donde nos llevamos el nombre del jugador
    public void  onClick(View v){
        //Para conectarnos con la siguiente pantalla.
        EditText editText = (EditText)findViewById(R.id.etNombre);
        String jugador = editText.getText().toString();

        Intent intent = new Intent(v.getContext(), MainActivity3.class);
        intent.putExtra("jugador", jugador);
        startActivity(intent);
        startActivity(intent);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}




