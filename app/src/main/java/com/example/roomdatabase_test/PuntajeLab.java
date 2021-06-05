package com.example.roomdatabase_test;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import com.example.roomdatabase_test.database.PuntajeDao;
import com.example.roomdatabase_test.database.PuntajeDatabase;

import java.util.List;

public class PuntajeLab {
    @SuppressLint("StaticFieldLeak")
    private static PuntajeLab sPuntajeLab;

    private PuntajeDao PuntajeDao;

    private PuntajeLab(Context context) {
        Context appContext = context.getApplicationContext();
        PuntajeDatabase database = Room.databaseBuilder(appContext, PuntajeDatabase.class, "puntaje")
                .allowMainThreadQueries().build();
        PuntajeDao = database.getPuntajeDao();
    }

    public static PuntajeLab get(Context context) {
        if (sPuntajeLab == null) {
            sPuntajeLab = new PuntajeLab(context);
        }
        return sPuntajeLab;
    }

    public List<Puntaje> getPuntaje() {
        return PuntajeDao.getPuntajes();
    }

    public Puntaje getPuntaje(String id) {
        return PuntajeDao.getPuntaje(id);
    }

    public void addPuntaje(Puntaje puntaje) {
        PuntajeDao.addPuntaje(puntaje);
    }

    public void updatePuntaje(Puntaje puntaje) {
        PuntajeDao.updatePuntaje(puntaje);
    }

    public void deletePuntaje(Puntaje puntaje) {
        PuntajeDao.deletePuntaje(puntaje);
    }
}