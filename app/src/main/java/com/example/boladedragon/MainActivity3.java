package com.example.boladedragon;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity3 extends AppCompatActivity {
    private ArrayList permissionsToRequest;
    private ArrayList permissionsRejected = new ArrayList();
    private ArrayList permissions = new ArrayList();
    private final static int ALL_PERMISSIONS_RESULT = 101;
    LocationTrack locationTrack;
    private TextView caja;
    ImageView ImageViewBolas;
    private int contadorBolas=0;
    private boolean bola1=false;
    private boolean bola2=false;
    private boolean bola3=false;
    private boolean bola4=false;
    private boolean bola5=false;
    private boolean bola6=false;
    private boolean bola7=false;
    private int tiempo=0;
    public int bolaCogida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle extras = getIntent().getExtras();
        String s = extras.getString("jugador");

        //Sacamos por pantalla el nombre en el tvNombre
        caja = (TextView) findViewById(R.id.tvNombre);
        caja.setText(s);

        View b = findViewById(R.id.btncaptura);
        b.setVisibility(View.INVISIBLE);


        //Se conecta al manifiesto y crea estos dos permisos
        permissions.add(ACCESS_FINE_LOCATION);
        permissions.add(ACCESS_COARSE_LOCATION);

        permissionsToRequest = findUnAskedPermissions(permissions);
        //get the permissions we have asked for before but are not granted..
        //we will store this in a global list to access later.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permissionsToRequest.size() > 0)
                requestPermissions((String[]) permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
        }

        //Empezamos a contar el tiempo de busqueda nada mas abrir este activity
        final long inicioTiempoBusqueda = System.currentTimeMillis();

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)


            @Override

            public void onClick(View view) {

                locationTrack = new LocationTrack(MainActivity3.this);
                if (locationTrack.canGetLocation()) {
                    double longitude = locationTrack.getLongitude();
                    double latitude = locationTrack.getLatitude();

                    //AQUI VA EL CODIGO DE COGER BOLAS POR LOCALIZACIÓN
                    //Lo primero que hace es recoger los datos de geolocalización, y en base a eso detecta en si está o no cerca de una bola.
                    //Luego mira si esa bola ya se ha cogido o no, si ya la tenemos nos dirá que ya no hay mas bolas en la zona
                    //Si la bola no la tenemos, nos avisará que estamos cerca de la bola que corresponda y sacará el botón oculto para cogerla
                    //Una vez la cogamos, la bola se añade al inventario y se pone como true para que no salga mas.

                    if (latitude > 40.374200 & latitude < 40.378000 & longitude < -3.611100 & longitude > -3.61400) {
                        //LOCALIZACION BOLA 1
                        if (!bola1){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Estas cerca de la bola de 1 estrella", Toast.LENGTH_SHORT);
                        toast1.show();
                        View b = findViewById(R.id.btncaptura);
                        b.setVisibility(View.VISIBLE);
                        bolaCogida = 1;
                        bola1=true;
                        contadorBolas++;
                        }else{
                            Toast toast1 = Toast.makeText(getApplicationContext(),
                                            "Sigue buscando, aquí no hay más bolas", Toast.LENGTH_SHORT);
                            toast1.show();

                        }
                    } else if (latitude > 40.3757 & latitude < 40.3772 & longitude < -3.6033 & longitude > -3.6062) {
                        //LOCALIZACION BOLA 2
                        if (!bola2){
                            Toast toast2 =
                                Toast.makeText(getApplicationContext(),
                                        "Estas cerca de la bola de 2 estrella", Toast.LENGTH_SHORT);
                        toast2.show();
                        View b = findViewById(R.id.btncaptura);
                        b.setVisibility(View.VISIBLE);
                        bolaCogida = 2;
                        bola2=true;
                        contadorBolas++;
                        }else{
                            Toast toast1 = Toast.makeText(getApplicationContext(),
                                    "Sigue buscando, aquí no hay más bolas", Toast.LENGTH_SHORT);
                            toast1.show();
                        }
                    } else if (latitude > 40.3686 & latitude < 40.3714 & longitude < -3.5941 & longitude > -3.5997) {
                        //LOCALIZACION BOLA 3
                        if (!bola3){
                        Toast toast3 =
                                Toast.makeText(getApplicationContext(),
                                        "Estas cerca de la bola de 3 estrella", Toast.LENGTH_SHORT);
                        toast3.show();
                        View b = findViewById(R.id.btncaptura);
                        b.setVisibility(View.VISIBLE);
                        bolaCogida = 3;
                        bola3=true;
                        contadorBolas++;
                        }else{
                            Toast toast1 = Toast.makeText(getApplicationContext(),
                                    "Sigue buscando, aquí no hay más bolas", Toast.LENGTH_SHORT);
                            toast1.show();
                        }
                    } else if (latitude > 40.3636 & latitude < 40.3665 & longitude < -3.6118 & longitude > -3.6158) {
                        //LOCALIZACION BOLA 4
                        if (!bola4){

                            Toast toast4 =
                                Toast.makeText(getApplicationContext(),
                                        "Estas cerca de la bola de 4 estrella", Toast.LENGTH_SHORT);
                        toast4.show();
                        View b = findViewById(R.id.btncaptura);
                        b.setVisibility(View.VISIBLE);
                        bolaCogida = 4;
                        bola4=true;
                        contadorBolas++;
                        }else{
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "Sigue buscando, aquí no hay más bolas", Toast.LENGTH_SHORT);
                        toast1.show();
                        }
                    } else if (latitude > 40.371000 & latitude < 40.372000 & longitude < -3.6131 & longitude > -3.6135) {
                        //LOCALIZACION BOLA 5
                        if (!bola5){

                            Toast toast5 =
                                Toast.makeText(getApplicationContext(),
                                        "Estas cerca de la bola de 5 estrella", Toast.LENGTH_SHORT);
                        toast5.show();
                        View b = findViewById(R.id.btncaptura);
                        b.setVisibility(View.VISIBLE);
                        bolaCogida = 5;
                        bola5=true;
                        contadorBolas++;
                        }else{
                            Toast toast1 = Toast.makeText(getApplicationContext(),
                                    "Sigue buscando, aquí no hay más bolas", Toast.LENGTH_SHORT);
                            toast1.show();
                        }
                    } else if (latitude > 40.3704 & latitude < 40.3720 & longitude < -3.6056 & longitude > -3.608) {
                        //LOCALIZACION BOLA 6
                        if (!bola6){

                            Toast toast6 =
                                Toast.makeText(getApplicationContext(),
                                        "Estas cerca de la bola de 6 estrella", Toast.LENGTH_SHORT);
                        toast6.show();
                        View b = findViewById(R.id.btncaptura);
                        b.setVisibility(View.VISIBLE);
                        bolaCogida = 6;
                        bola6=true;
                        contadorBolas++;
                        }else{
                            Toast toast1 = Toast.makeText(getApplicationContext(),
                                    "Sigue buscando, aquí no hay más bolas", Toast.LENGTH_SHORT);
                            toast1.show();
                        }
                    } else if (latitude > 40.3650 & latitude < 40.3675 & longitude < -3.598 & longitude > -3.6013) {
                        //LOCALIZACION BOLA 7
                        if (!bola7){
                            Toast toast7 =
                                Toast.makeText(getApplicationContext(),
                                        "Estas cerca de la bola de 7 estrella", Toast.LENGTH_SHORT);
                        toast7.show();
                        View b = findViewById(R.id.btncaptura);
                        b.setVisibility(View.VISIBLE);
                        bolaCogida = 7;
                        bola7=true;
                        contadorBolas++;
                        }else{
                            Toast toast1 = Toast.makeText(getApplicationContext(),
                                    "Sigue buscando, aquí no hay más bolas", Toast.LENGTH_SHORT);
                            toast1.show();
                        }
                    } else {
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Sigue buscando las bolas por otra zona", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                } else {
                    locationTrack.showSettingsAlert();
                }

                //Por último, si conseguimos reunir las 7 bolas de dragón nos pasará a la pantalla final del juego
                //llevandonos el nombre del jugador
                if(contadorBolas==7){

                    //Capturamos el tiempo en el que coge la última bola de dragón
                    long finTiempoBusqueda = System.currentTimeMillis();

                    double totalTiempoBusqueda = (double) (((finTiempoBusqueda - inicioTiempoBusqueda)/1000));
                    // Este será el original porque se tardará mas de un minuto en encontrarlas, pero para las pruebas dejaremos el tiempo en segundos.
                    //double totalTiempoBusqueda = (double) (((finTiempoBusqueda - inicioTiempoBusqueda)/1000)/60);

                    System.out.println(totalTiempoBusqueda +" segundos");
                    TextView textView = (TextView) findViewById(R.id.tvNombre);
                    System.out.println("Vamos a la pantalla final");
                    String jugador = textView.getText().toString();
                    Intent intent = new Intent(view.getContext(), MainActivity4.class);
                    intent.putExtra("jugador", jugador);
                    intent.putExtra("tiempo", totalTiempoBusqueda);
                    startActivity(intent);

                }
            }

        });

    }

    private ArrayList findUnAskedPermissions(ArrayList wanted) {
        ArrayList result = new ArrayList();
        for (Object perm : wanted) {
            if (!hasPermission((String) perm)) {
                result.add(perm);
            }
        }
        return result;
    }

    private boolean hasPermission(String permission) {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case ALL_PERMISSIONS_RESULT:
                for (Object perms : permissionsToRequest) {
                    if (!hasPermission((String) perms)) {
                        permissionsRejected.add(perms);
                    }
                }
                if (permissionsRejected.size() > 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale((String) permissionsRejected.get(0))) {
                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions((String[]) permissionsRejected.toArray(new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
                                            }
                                        }
                                    });
                            return;
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity3.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationTrack.stopListener();
    }

    public void cogerBola(View v) {
        if (bolaCogida == 1) {
            ImageViewBolas = (ImageView) findViewById(R.id.imageView1);
            ImageViewBolas.setImageResource(R.drawable.bola1);
            View b = findViewById(R.id.btncaptura);
            b.setVisibility(View.INVISIBLE);
        } else if (bolaCogida == 2) {
            ImageViewBolas = (ImageView) findViewById(R.id.imageView2);
            ImageViewBolas.setImageResource(R.drawable.bola2);
            View b = findViewById(R.id.btncaptura);
            b.setVisibility(View.INVISIBLE);
        }else if (bolaCogida == 3) {
            ImageViewBolas = (ImageView) findViewById(R.id.imageView3);
            ImageViewBolas.setImageResource(R.drawable.bola3);
            View b = findViewById(R.id.btncaptura);
            b.setVisibility(View.INVISIBLE);
        }else if (bolaCogida == 4) {
            ImageViewBolas = (ImageView) findViewById(R.id.imageView4);
            ImageViewBolas.setImageResource(R.drawable.bola4);
            View b = findViewById(R.id.btncaptura);
            b.setVisibility(View.INVISIBLE);
        }else if (bolaCogida == 5) {
            ImageViewBolas = (ImageView) findViewById(R.id.imageView5);
            ImageViewBolas.setImageResource(R.drawable.bola5);
            View b = findViewById(R.id.btncaptura);
            b.setVisibility(View.INVISIBLE);
        }else if (bolaCogida == 6) {
            ImageViewBolas = (ImageView) findViewById(R.id.imageView6);
            ImageViewBolas.setImageResource(R.drawable.bola6);
            View b = findViewById(R.id.btncaptura);
            b.setVisibility(View.INVISIBLE);
        }else if (bolaCogida == 7) {
            ImageViewBolas = (ImageView) findViewById(R.id.imageView7);
            ImageViewBolas.setImageResource(R.drawable.bola7);
            View b = findViewById(R.id.btncaptura);
            b.setVisibility(View.INVISIBLE);
        }
    }
}