package com.example.instagramjava.model;

import java.util.ArrayList;

/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Instagram java
 * eldorturgunov777@gmail.com
 */
public class Feed {
    Post post = null;
    ArrayList<Story> stories;

    public Feed(ArrayList<Story> stories) {
        this.stories = stories;
    }

    public Feed(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public ArrayList<Story> getStories() {
        return stories;
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }
}
