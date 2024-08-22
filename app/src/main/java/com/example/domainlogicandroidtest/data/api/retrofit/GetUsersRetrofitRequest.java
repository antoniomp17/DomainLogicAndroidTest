package com.example.domainlogicandroidtest.data.api.retrofit;

import com.example.domainlogicandroidtest.data.api.GetUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GetUsersRetrofitRequest {
    @Headers("Accept: application/vnd.github.v3+json")
    @GET("search/users")
    Call<GetUsersResponse> getUsers(@Query("q") String name);
}