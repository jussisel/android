package com.example.anttieek.testi;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by anttieek on 7.5.2018.
 */
@Database(entities = {Taksi.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaksiIF taksiIF();
}
