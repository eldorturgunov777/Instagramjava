package com.example.instagramjava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.instagramjava.R;
import com.example.instagramjava.adapter.FeedAdapter;
import com.example.instagramjava.model.Feed;
import com.example.instagramjava.model.Post;
import com.example.instagramjava.model.Story;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Story> stories = new ArrayList<Story>();
    ArrayList<Feed> feeds = new ArrayList<Feed>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        refreshAdapter(getAllFeeds());
    }

    void refreshAdapter(ArrayList<Feed> feeds) {
        FeedAdapter feedAdapter = new FeedAdapter(this, feeds);
        recyclerView.setAdapter(feedAdapter);
    }

    ArrayList<Feed> getAllFeeds() {

        stories.add(new Story(R.drawable.im_user_1, "Xurshid"));
        stories.add(new Story(R.drawable.im_user_3, "Sherzod"));
        stories.add(new Story(R.drawable.im_user_2, "Begzod"));
        stories.add(new Story(R.drawable.im_user_1, "Firdavs"));
        stories.add(new Story(R.drawable.im_user_1, "Xurshid"));
        stories.add(new Story(R.drawable.im_user_3, "Sherzod"));
        stories.add(new Story(R.drawable.im_user_2, "Begzod"));
        stories.add(new Story(R.drawable.im_user_1, "Firdavs"));

        feeds.add(new Feed(new Post(R.drawable.im_user_1, "Xurshidbek", R.drawable.im_post_4)));
        feeds.add(new Feed(new Post(R.drawable.im_user_2, "Begzodbek", R.drawable.im_post_3)));
        feeds.add(new Feed(new Post(R.drawable.im_user_3, "Sherzodbek", R.drawable.im_post_2)));
        feeds.add(new Feed(new Post(R.drawable.im_user_1, "Firdavsbek", R.drawable.im_post_1)));
        return feeds;
    }
}