package com.kiduyu.nahashonproject.realestateagent.data.typeconverters;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kiduyu.nahashonproject.realestateagent.data.datamodels.AddressRealEstate;

import java.lang.reflect.Type;

/**
 * Created by Diego Fajardo on 24/08/2018.
 */

public class AddressTypeConverter {

    private static final String TAG = AddressTypeConverter.class.getSimpleName();

    @TypeConverter
    public static AddressRealEstate fromString (String value) {
        Type listType = new TypeToken<AddressRealEstate>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromAddress (AddressRealEstate addressRealEstate) {
        Gson gson = new Gson();
        return gson.toJson(addressRealEstate);
    }


}
