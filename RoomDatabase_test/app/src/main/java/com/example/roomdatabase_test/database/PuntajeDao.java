package com.example.roomdatabase_test.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase_test.Puntaje;

import java.util.List;

@Dao
public interface PuntajeDao {

    @Query("SELECT * FROM puntaje")
    List<Puntaje> getPuntajes();

    @Query("SELECT * FROM puntaje WHERE Id LIKE :uuid")
    Puntaje getPuntaje(String uuid);

    @Insert
    void addPuntaje(Puntaje book);

    @Delete
    void deletePuntaje(Puntaje book);

    @Update
    void updatePuntaje(Puntaje book);
}