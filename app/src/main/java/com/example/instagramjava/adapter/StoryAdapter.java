package com.example.instagramjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramjava.R;
import com.example.instagramjava.model.Story;

import java.util.ArrayList;

/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Instagram java
 * eldorturgunov777@gmail.com
 */
public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Story> items;

    public StoryAdapter(Context context, ArrayList<Story> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_story_view, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Story data = items.get(position);
        if (holder instanceof StoryViewHolder) {

            ((StoryViewHolder) holder).iv_profile.setImageResource(data.getProfile());
            ((StoryViewHolder) holder).tv_fullname.setText(data.getFullname());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private static class StoryViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_fullname;

        public StoryViewHolder(View view) {
            super(view);
            iv_profile = view.findViewById(R.id.iv_profile);
            tv_fullname = view.findViewById(R.id.tv_fullname);
        }
    }
}
