package com.example.gfa.myapplication.http;

import com.example.gfa.myapplication.model.WorksBySubjectResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface OpenLibraryApi {

  @Headers({"Content-Type: application/json", "Accept: application/json"})
  @GET("subjects/{subject}")
  Call<WorksBySubjectResponse> getWorksBySubject(@Path("subject") String subject);

}