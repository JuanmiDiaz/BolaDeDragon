package com.example.boladedragon;

public class Jugadores {
    String id;
    String nombre;
    String mensaje;
    String tiempo;

    //Contructor para cuando empieza la partida el jugador
    public Jugadores(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Jugadores(String id, String nombre, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.mensaje = mensaje;
    }

    //Contructor para cuando se añadan los datos al ranking
    public Jugadores(String id, String nombre, String mensaje,String tiempo) {
        this.id = id;
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.tiempo = tiempo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}



