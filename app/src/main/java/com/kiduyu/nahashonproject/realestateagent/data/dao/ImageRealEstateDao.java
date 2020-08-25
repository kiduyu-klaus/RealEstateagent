package com.kiduyu.nahashonproject.realestateagent.data.dao;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kiduyu.nahashonproject.realestateagent.data.entities.ImageRealEstate;

import java.util.List;



/**
 * Created by Diego Fajardo on 05/08/2018.
 */

@Dao
public interface ImageRealEstateDao {

    // -------------------
    // READ

    @Query("SELECT * FROM image")
    LiveData<List<ImageRealEstate>> getAllImagesRealEstateLiveData();

    @Query("SELECT * FROM image")
    List<ImageRealEstate> getAllImagesRealEstate();

    // -------------------
    // INSERT
    @Insert
    long insertImageRealEstate(ImageRealEstate imageRealEstate);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertListOfImagesRealEstate(List<ImageRealEstate> listOfImagesRealEstate);



    // -------------------
    // UPDATE


    // -------------------
    // DELETE


}
