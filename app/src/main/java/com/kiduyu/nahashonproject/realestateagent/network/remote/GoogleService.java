package com.kiduyu.nahashonproject.realestateagent.network.remote;




import com.kiduyu.nahashonproject.realestateagent.network.models.placebynearby.LatLngForRetrofit;
import com.kiduyu.nahashonproject.realestateagent.network.models.placebynearby.PlacesByNearby;
import com.kiduyu.nahashonproject.realestateagent.network.models.placedetails.PlaceDetails;
import com.kiduyu.nahashonproject.realestateagent.network.models.placefindplacefromtext.PlaceFromText;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Diego Fajardo on 19/08/2018.
 */
public interface GoogleService {

    /**
     * Method to get Places using Text (It uses a URL).
     */
    @GET("json")
    Observable<PlaceFromText> fetchPlaceFromText(
            @Query("input") String input,
            @Query("inputtype") String inputType,
            @Query("key") String key
    );

    /**
     * Method to get Details from a Place (It uses a URL).
     */
    @GET("json")
    Observable<PlaceDetails> fetchPlaceId(
            @Query("placeid") String placeId,
            @Query("key") String key
    );

    /**
     * Method to get Nearby Places (It uses a URL).
     */
    @GET("json")
    Observable<PlacesByNearby> fetchNearbyPlaces(
            @Query("location") LatLngForRetrofit latLngForRetrofit,
            @Query("rankby") String rankby,
            @Query("key") String key
    );


}