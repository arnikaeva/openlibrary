package com.example.gfa.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gfa.myapplication.R;
import com.example.gfa.myapplication.model.Work;

import java.util.ArrayList;
import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {

    private List<Work> works;

    public WorkAdapter() {
        works = new ArrayList<>();
    }

    public void updateData(List<Work> works) {
        this.works = works;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public WorkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.work, parent, false);
        WorkAdapter.ViewHolder viewHolder = new WorkAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkAdapter.ViewHolder holder, int position) {
        Work work = works.get(position);
        String authorName = work.getAuthors().get(0).getName();

        holder.title.setText(work.getTitle());
        holder.authorName.setText(authorName);
    }

    @Override
    public int getItemCount() {
        return works.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView authorName;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.workTitle);
            authorName = itemView.findViewById(R.id.workAuthor);
        }
    }
}
