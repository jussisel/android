package com.example.anttieek.testi;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by anttieek on 7.5.2018.
 */

@Dao
public interface TaksiIF {
    @Query("SELECT * FROM taksi")
    List<Taksi> getAll();

    @Insert
    void insertAll(Taksi... taksis);

    @Delete
    void delete(Taksi taksi);
}
