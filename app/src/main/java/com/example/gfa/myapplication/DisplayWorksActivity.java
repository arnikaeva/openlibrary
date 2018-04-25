package com.example.gfa.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.gfa.myapplication.adapter.WorkAdapter;
import com.example.gfa.myapplication.http.RetrofitClient;
import com.example.gfa.myapplication.model.WorksBySubjectResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayWorksActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    //private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private WorkAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_works);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        adapter = new WorkAdapter();
        mRecyclerView.setAdapter(adapter);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String subject = intent.getStringExtra(MainActivity.SUBJECT);

        loadData(subject);



    }

    private void loadData(String subject) {

        RetrofitClient.getOpenLibraryApiImpl().getWorksBySubject(subject).enqueue(new Callback<WorksBySubjectResponse>() {
            @Override
            public void onResponse(Call<WorksBySubjectResponse> call, Response<WorksBySubjectResponse> response) {
                WorksBySubjectResponse worksBySubjectResponse = response.body();
                adapter.updateData(worksBySubjectResponse.getWorks());

            }

            @Override
            public void onFailure(Call<WorksBySubjectResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
