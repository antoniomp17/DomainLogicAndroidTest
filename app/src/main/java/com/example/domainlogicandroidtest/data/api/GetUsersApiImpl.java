package com.example.domainlogicandroidtest.data.api;

import com.example.domainlogicandroidtest.domain.model.User;
import com.example.domainlogicandroidtest.data.api.retrofit.GetUsersRetrofitRequest;
import com.example.domainlogicandroidtest.domain.usecase.GetUsers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetUsersApiImpl implements GetUsers, Callback<GetUsersResponse> {
    private static final String ENDPOINT = "https://api.github.com/";
    private String name;
    private Listener listener = new NullListener();

    public GetUsersApiImpl() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<User> get() {
        throw new IllegalStateException("Not implemented yet");
    }

    @Override
    public void getAsync(Listener listener) {
        if (listener != null) {
            this.listener = listener;
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetUsersRetrofitRequest request = retrofit.create(GetUsersRetrofitRequest.class);
        Call<GetUsersResponse> call = request.getUsers(name);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<GetUsersResponse> call, Response<GetUsersResponse> response) {
        if (response.isSuccessful()) {
            if (response.body() != null && response.body().getItems() != null) {
                List<User> users = new ArrayList<>();

                for (User entry : response.body().getItems()) {
                    users.add(entry);
                }

                listener.onUsersReceived(users, false);
            } else {
                // Manejo de caso cuando la respuesta es exitosa pero el cuerpo está vacío o items es nulo
                listener.onError(new Exception("Received empty response or items list is null"));
            }
        } else {
            // Manejo de errores HTTP específicos
            String errorMessage = "Failed to fetch users. HTTP code: " + response.code();
            if (response.code() >= 400 && response.code() < 500) {
                errorMessage = "Client error: " + response.code() + " " + response.message();
            } else if (response.code() >= 500) {
                errorMessage = "Server error: " + response.code() + " " + response.message();
            }
            listener.onError(new Exception(errorMessage));
        }
    }

    @Override
    public void onFailure(Call<GetUsersResponse> call, Throwable t) {
        if (t instanceof java.net.UnknownHostException || t instanceof java.net.ConnectException) {
            // Manejo de errores de red, como la falta de conexión a Internet
            listener.onNoInternetAvailable();
        } else {
            // Manejo de otros tipos de errores
            listener.onError(new Exception("Failed to fetch users. Error: " + t.getMessage()));
        }
    }

    public static class NullListener implements Listener {
        @Override
        public void onUsersReceived(List<User> users, boolean isCached) {

        }

        @Override
        public void onError(Exception e) {

        }

        @Override
        public void onNoInternetAvailable() {

        }
    }
}
