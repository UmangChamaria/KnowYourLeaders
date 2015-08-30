package com.example.uchamaria.retrofitsample;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * @author Umang Chamaria
 */
public class NetworkHandler {

    private final String TAG = NetworkHandler.class.getSimpleName();
    private Context mContext;
    private RestAdapter mRestAdapter;
    private CivicApi mCivicApi;
    private PoliticianModel mPolitician;


    public void init(){

        if (mCivicApi == null)
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.ENDPOINT).build();
        mCivicApi = mRestAdapter.create(CivicApi.class);
    }

    public PoliticianModel getPoliticianByLatLong(LatLng latLng){
        init();
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                mPolitician = (PoliticianModel)o;
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        };
        mCivicApi.getPoliticiansByLatLong(latLng.latitude, latLng.longitude, callback);

        return mPolitician;
    }

 /*   public List<PoliticianModel> getAllPoliticianList(){
        init();
        mCivicApi.getAllPoliticianInfo(new Callback<List<PoliticianModel>>() {
            @Override
            public void success(List<PoliticianModel> politicianModels, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return mPolitician;
    }*/
}
