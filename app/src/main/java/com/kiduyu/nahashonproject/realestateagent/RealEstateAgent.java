package com.kiduyu.nahashonproject.realestateagent;

import android.app.Application;
import android.util.Log;

import com.kiduyu.nahashonproject.realestateagent.data.AppDatabase;
import com.kiduyu.nahashonproject.realestateagent.data.AppExecutors;
import com.kiduyu.nahashonproject.realestateagent.data.DataRepository;
import com.snatik.storage.Storage;

import java.io.File;
import java.util.List;

public class RealEstateAgent extends Application {

    private static final String TAG = RealEstateAgent.class.getSimpleName();

    private Storage internalStorage;

    private String mainPath;
    private String imagesDir;
    private String temporaryDir;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: called!");

        this.setDirectories();

        this.getAllFiles();
        this.getInternalStorageTemporaryFiles();
        this.getInternalStorageImageFiles();

        int BITMAP_CACHE_SIZE = (int) Runtime.getRuntime().maxMemory() / 1024 / 8;
        Log.w(TAG, "onCreate: BITMAP_CACHE_SIZE application = " + BITMAP_CACHE_SIZE);
        Log.w(TAG, "onCreate: MAX_MEMORY application = " + Runtime.getRuntime().maxMemory() / 1048576L);
        Log.w(TAG, "onCreate: FREE_MEMORY application = " + Runtime.getRuntime().freeMemory() / 1048576L);
        Log.w(TAG, "onCreate: AVAILABLE application = " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) / 1048576L);
    }

    /**
     * Method to get an entry point to the internal storage.
     */
    public Storage getInternalStorage() {
        Log.d(TAG, "getInternalStorage: called!");

        if (internalStorage == null) {
            internalStorage = new Storage(getApplicationContext());
            return internalStorage;
        } else return internalStorage;
    }
    /**
     * Method to set the directories of the internal storage.
     */
    private void setDirectories() {
        Log.d(TAG, "setDirectories: called!");
        mainPath = getInternalStorage().getInternalFilesDirectory() + File.separator;
        temporaryDir = getMainPath() + Constants.TEMPORARY_DIRECTORY + File.separator;
        imagesDir = getMainPath() + Constants.IMAGES_DIRECTORY + File.separator;
    }
    /**
     * Method to get an entry point to AppExecutors.
     */
    public AppExecutors getAppExecutors() {
        Log.d(TAG, "getAppExecutors: called!");
        return AppExecutors.getInstance();
    }

    /**
     * Method to get an entry point to the DataRepository.
     */
    public DataRepository getRepository() {
        Log.d(TAG, "getRepository: called!");
        return DataRepository.getInstance(getDatabase(), Runtime.getRuntime().maxMemory());
    }

    /**
     * Method to get an entry point to the App Database.
     */
    public AppDatabase getDatabase() {
        Log.d(TAG, "getDatabase: called!");
        return AppDatabase.getInstance(this, getAppExecutors());
    }

    /**
     * Method to get the mainPath of the internal storage.
     */
    public String getMainPath() {
        Log.d(TAG, "getMainPath: called!");
        return mainPath;
    }
    public void getAllFiles() {
        Log.d(TAG, "getAllFiles: called!");

        List<File> listOfFiles = getInternalStorage().getFiles(getFilesDir().getPath());
        Log.i(TAG, "getAllFiles: listOfFiles = " + listOfFiles);
        Log.i(TAG, "getAllFiles: mainPath = " + getFilesDir().getPath());

    }

    /**
     * Method to get all the temporary files of the internal storage.
     */
    public void getInternalStorageTemporaryFiles() {
        Log.d(TAG, "getInternalStorageTemporaryFiles: called!");

        List<File> listOfFiles = getInternalStorage().getFiles("/data/user/0/com.kiduyu.nahashonproject.realestateagent/files/temporary_directory");

        if (listOfFiles == null) {
            Log.i(TAG, "getInternalStorageTemporaryFiles: null");

        } else if (listOfFiles.size() == 0) {
            Log.i(TAG, "getInternalStorageTemporaryFiles: 0");

        } else {
            for (File item : listOfFiles) {
                Log.i(TAG, "onCreate Image: " + item);
            }
        }
    }

    /**
     * Method to get all the image files of the internal storage.
     */
    public void getInternalStorageImageFiles() {
        Log.d(TAG, "getInternalStorageImageFiles: called!");

        List<File> listOfFiles = getInternalStorage().getFiles("/data/user/0/com.kiduyu.nahashonproject.realestateagent/files/images_directory");

        if (listOfFiles == null) {
            Log.i(TAG, "getInternalStorageImageFiles: null ");

        } else if (listOfFiles.size() == 0) {
            Log.i(TAG, "getInternalStorageImageFiles: 0");

        } else {
            for (File item : listOfFiles) {
                Log.i(TAG, "onCreate Image: " + item);
            }
        }
    }
}
