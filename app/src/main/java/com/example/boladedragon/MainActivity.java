package com.example.boladedragon;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnEntrar).setOnClickListener(this);

        //Cancion que suena durante el juego
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.themebd);
        mediaPlayer.start();

    }
    public void  onClick(View v){
        //Para conectarnos con la siguiente pantalla.
        Intent intent = new Intent(v.getContext(), MainActivity2.class);
        startActivity(intent);

    }
}