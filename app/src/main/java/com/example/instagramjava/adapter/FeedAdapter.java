package com.example.instagramjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramjava.R;
import com.example.instagramjava.model.Feed;
import com.example.instagramjava.model.Story;

import java.util.ArrayList;

/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Instagram java
 * eldorturgunov777@gmail.com
 */
public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_ITEM_STORY = 0;
    private final int TYPE_ITEM_POST = 1;
    private final int TYPE_ITEM_ADS = 2;

    Context context;
    ArrayList<Feed> items;

    public FeedAdapter(Context context, ArrayList<Feed> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_STORY) {
            View view =
                    LayoutInflater.from(context).inflate(R.layout.item_feed_story, parent, false);
            return new StoryViewHolder(view);
        }
        if (viewType == TYPE_ITEM_ADS) {
            View header =
                    LayoutInflater.from(context).inflate(R.layout.item_feed_ads, parent, false);
            return new FeedAdsViewHolder(header);
        }
        View view =
                LayoutInflater.from(context).inflate(R.layout.item_feed_post, parent, false);
        return new PosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Feed data = items.get(position);

        if (holder instanceof StoryViewHolder) {
            RecyclerView recyclerView = ((StoryViewHolder) holder).recyclerView;
            refreshAdapter(data.getStories(), recyclerView);
        }
        if (holder instanceof PosterViewHolder) {
            ((PosterViewHolder) holder).iv_profile.setImageResource(data.getPost().getProfile());
            ((PosterViewHolder) holder).iv_photo.setImageResource(data.getPost().getPhoto());
            ((PosterViewHolder) holder).tv_fullName.setText(data.getPost().getFullname());
        }
    }

    void refreshAdapter(ArrayList<Story> stories, RecyclerView recyclerView) {
        StoryAdapter storyAdapter = new StoryAdapter(context, stories);
        recyclerView.setAdapter(storyAdapter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position))
            return TYPE_ITEM_ADS;
        if (items.get(position).getStories().size() > 0)
            return TYPE_ITEM_STORY;
        else return TYPE_ITEM_POST;
    }

    public boolean isHeader(int position) {
        return position == 2;
    }

    private static class PosterViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        ImageView iv_photo;
        ImageView iv_like;
        ImageView iv_comment;
        ImageView iv_send;
        ImageView iv_save;
        TextView tv_fullName;
        TextView tv_caption;

        public PosterViewHolder(View view) {
            super(view);
            iv_profile = view.findViewById(R.id.iv_profile);
            tv_fullName = view.findViewById(R.id.tv_fullname);
            iv_photo = view.findViewById(R.id.iv_photo);
            iv_like = view.findViewById(R.id.iv_like);
            iv_comment = view.findViewById(R.id.iv_comment);
            iv_send = view.findViewById(R.id.iv_send);
            iv_save = view.findViewById(R.id.iv_save);
            tv_caption = view.findViewById(R.id.tv_caption);
        }
    }

    private static class StoryViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public StoryViewHolder(View view) {
            super(view);
            recyclerView = view.findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(manager);
        }
    }

    private static class FeedAdsViewHolder extends RecyclerView.ViewHolder {
        public FeedAdsViewHolder(View view) {
            super(view);
        }
    }
}
