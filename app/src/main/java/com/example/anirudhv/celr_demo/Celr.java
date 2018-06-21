package com.example.anirudhv.celr_demo;

public class Celr {


    private  String videoUrl;
    private  String imageUrl;
    private  String id;

    public Celr(String videoUrl, String imageUrl, String id) {
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getId() {
        return id;
    }
}
