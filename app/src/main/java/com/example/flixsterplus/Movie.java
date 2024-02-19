package com.example.flixsterplus;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String description;

    @SerializedName("poster_path")
    private String posterPath;

    // Getters

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPosterPath() {
        return posterPath;
    }
}

