package com.kiduyu.nahashonproject.realestateagent.data.dao;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kiduyu.nahashonproject.realestateagent.data.entities.PlaceRealEstate;

import java.util.List;



/**
 * Created by Diego Fajardo on 05/08/2018.
 */

@Dao
public interface PlaceRealEstateDao {

    // -------------------
    // READ

    @Query("SELECT * FROM place ORDER BY id")
    LiveData<List<PlaceRealEstate>> getAllPlacesRealEstateLiveData();

    @Query("SELECT * FROM place ORDER BY id")
    List<PlaceRealEstate> getAllPlacesRealEstate();

    // -------------------
    // INSERT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertListOfPlaceRealEstate(List<PlaceRealEstate> listOfImagesRealEstate);

    ;

    // -------------------
    // UPDATE


    // -------------------
    // DELETE

}
