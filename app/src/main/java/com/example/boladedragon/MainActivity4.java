package com.example.boladedragon;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {
    EditText txtNombre;
    EditText txtMensaje;
    private TextView cajaTiempo;

    Button botonGuardar;

    private DatabaseReference Jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //SALIR findViewById(R.id.btnJugar).setOnClickListener(this);

        //Recinimos los datos del jugador
        Bundle extras = getIntent().getExtras();
        String s = extras.getString("jugador");
        Double tiempo = extras.getDouble("tiempo");

        final String tiempoTexto = String.valueOf(tiempo);

        cajaTiempo = (TextView) findViewById(R.id.tvTiempo);
        cajaTiempo.setText(tiempoTexto);
        //Obtenemos los datos del jugador
        Jugadores = FirebaseDatabase.getInstance().getReference("Jugadores");
        txtNombre =(EditText) findViewById(R.id.etNombre);
        txtMensaje =(EditText) findViewById(R.id.etMensaje);
        botonGuardar =(Button) findViewById(R.id.btnguardar);

        botonGuardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                registrarPuntuacion();
            }

            //Enviamos los datos a la base de datos
            public void registrarPuntuacion(){
                String nombre = txtNombre.getText().toString();
                String mensaje = txtMensaje.getText().toString();
                String tiempo = cajaTiempo.getText().toString();
                if(!TextUtils.isEmpty(nombre)){
                    String id = Jugadores.push().getKey();
                    Jugadores jugador = new Jugadores(id, nombre, mensaje, tiempo);

                    System.out.println("Envio a la base de datos");
                    System.out.println(tiempo);

                    Jugadores.child("Puntuaciones").child(id).setValue(jugador);

                }else{
                    //Toast.makeText(this,"Debe introducir un nombre", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    public void  onClick(View v){

    }
}