package com.example.gfa.myapplication.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    static final String OPEN_LIBRARY_URL = "https://openlibrary.org/";

    public static OpenLibraryApi getOpenLibraryApiImpl() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OPEN_LIBRARY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(OpenLibraryApi.class);
    }

}