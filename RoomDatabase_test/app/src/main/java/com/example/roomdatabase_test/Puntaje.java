package com.example.roomdatabase_test;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "puntaje")
public class Puntaje {
    @PrimaryKey
    @NonNull
    private String Id;
    @ColumnInfo(name = "contenido")
    private String Mensaje;

    public Puntaje() {
        Id = UUID.randomUUID().toString();
    }

    @NonNull
    public String getId() {
        return Id;
    }

    public void setId(@NonNull String id) {
        Id = id;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }
}