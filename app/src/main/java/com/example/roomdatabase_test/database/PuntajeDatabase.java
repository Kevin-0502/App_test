package com.example.roomdatabase_test.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdatabase_test.Puntaje;

@Database(entities = {Puntaje.class}, version = 1)
public abstract class PuntajeDatabase  extends RoomDatabase {

    public abstract PuntajeDao getPuntajeDao();

}
