package com.example.uchamaria.retrofitsample;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * @author Umang Chamaria
 */
public class NetworkHandler {

    private final String TAG = NetworkHandler.class.getSimpleName();
    RestAdapter mRestAdapter;
    CivicApi mCivicApi;
    List<PoliticianModel> mPoliticianList;


    public void init(){

        if (mCivicApi == null)
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.ENDPOINT).build();
        mCivicApi = mRestAdapter.create(CivicApi.class);
    }

    public List<PoliticianModel> getPoliticianByLatLong(LatLng latLng){
        init();
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                mPoliticianList = (List<PoliticianModel>)o;
                for (PoliticianModel politicianModel : mPoliticianList){
                    Log.d(TAG, politicianModel.getPoliticianName());
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        };
        mCivicApi.getPoliticiansByLatLong(latLng.latitude, latLng.longitude, callback);

        return mPoliticianList;
    }

    public List<PoliticianModel> getAllPoliticianList(){
        init();
        mCivicApi.getAllPoliticianInfo(new Callback<List<PoliticianModel>>() {
            @Override
            public void success(List<PoliticianModel> politicianModels, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return mPoliticianList;
    }
}
