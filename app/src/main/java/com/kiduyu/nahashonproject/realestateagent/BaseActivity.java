package com.kiduyu.nahashonproject.realestateagent;
import android.graphics.Bitmap;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.kiduyu.nahashonproject.realestateagent.data.AppDatabase;
import com.kiduyu.nahashonproject.realestateagent.data.DataRepository;
import com.kiduyu.nahashonproject.realestateagent.data.entities.ImageRealEstate;
import com.kiduyu.nahashonproject.realestateagent.data.entities.PlaceRealEstate;
import com.kiduyu.nahashonproject.realestateagent.data.entities.RealEstate;
import com.snatik.storage.Storage;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Diego Fajardo on 27/08/2018.
 */

/**
 * Activity that serves as base
 * for the other activities.
 */
public class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    ////////////////////////////////////////////////////////////////////////////////////////////////

    //SINGLETON GETTERS

    /**
     * Method to get a reference to the application.
     */
    protected RealEstateAgent getApp() {
        Log.d(TAG, "getApp: called");
        return (RealEstateAgent) getApplication();
    }

    /**
     * Method to get a reference to the Database.
     */
    protected AppDatabase getAppDatabase() {
        Log.d(TAG, "getAppDatabase: called!");
        return getApp().getDatabase();
    }

    /**
     * Method to get a reference to the DataRepository.
     */
    protected DataRepository getRepository() {
        Log.d(TAG, "getRepository: called!");
        return getApp().getRepository();
    }

    /**
     * Method to get a reference to the Internal Storage.
     */
    protected Storage getInternalStorage() {
        Log.d(TAG, "getInternalStorage: called!");
        return getApp().getInternalStorage();
    }

    /**
     * Getter of the real estate cache object.
     */
    protected RealEstate getRealEstateCache() {
        Log.d(TAG, "getRealEstateCache: called!");
        return getRepository().getRealEstateCache();
    }

    /**
     * Setter of the real estate cache object.
     */
    protected void setRealEstateCache(RealEstate realEstate) {
        Log.d(TAG, "setRealEstateCache: called!");
        getRepository().setRealEstateCache(realEstate);
    }

    /**
     * Getter of the list of images of the real estate cache object.
     */
    protected List<ImageRealEstate> getListOfImagesRealEstateCache() {
        Log.d(TAG, "getListOfImagesRealEstateCache: called!");
        return getRepository().getListOfImagesRealEstateCache();
    }

    /**
     * Getter of the list of places of the real estate cache object.
     */
    protected List<PlaceRealEstate> getListOfPlacesRealEstateCache() {
        Log.d(TAG, "getListOfPlacesRealEstateCache: called!");
        return getRepository().getListOfPlacesRealEstateCache();
    }

    /**
     * Getter of the list of bitmap keys of the real estate cache object.
     */
    protected List<String> getListOfBitmapKeys() {
        Log.d(TAG, "getListOfBitmapCacheKeys: called!");
        return getRepository().getListOfBitmapCacheKeys();
    }

    /**
     * Getter of the bitmap cache.
     */
    protected Map<String, Bitmap> getBitmapCache() {
        Log.d(TAG, "getBitmapCache: called!");
        return getRepository().getBitmapCache();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Getter of the Images Directory
     */
    protected String getImagesDir() {
        Log.d(TAG, "getImagesDir: called!");
        //mainPath = getInternalStorage().getInternalFilesDirectory() + File.separator;
        return getInternalStorage().getInternalFilesDirectory() + File.separator
                + Constants.IMAGES_DIRECTORY + File.separator;
    }

    /**
     * Getter of the Images Temporary Directory
     */
    protected String getTemporaryDir() {
        Log.d(TAG, "getTemporaryDir: called!");
        return getInternalStorage().getInternalFilesDirectory() + File.separator
                + Constants.TEMPORARY_DIRECTORY + File.separator;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Getter for Glide.
     */
    protected RequestManager getGlide() {
        Log.d(TAG, "getGlide: called!");
        return Glide.with(getApp());
    }

}
