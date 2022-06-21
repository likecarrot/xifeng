package com.example.xifeng2.ApiServers;

import com.example.xifeng2.RetClass.realtime;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServers {
    //base url https://api.caiyunapp.com/v2.5/
    @GET("{Token}/{long},{titude}/realtime.json")
    Call<realtime> GetRealTime(@Path("Token") String Token, @Path("long")float latitude, @Path("titude")float longtitude);

}
