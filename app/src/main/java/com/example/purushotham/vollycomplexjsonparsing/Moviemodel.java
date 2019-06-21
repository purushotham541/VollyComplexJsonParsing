package com.example.purushotham.vollycomplexjsonparsing;

import java.util.ArrayList;
import java.util.List;

public class Moviemodel
{
    private String movie;
    private String duration;
    private String director;
    private String tagline;
    String image;
    private String story;
    private int year;
    private float rating;
    private List<cast> castArrayList;
    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<cast> getCastArrayList() {
        return castArrayList;
    }

    public void setCastArrayList(List<cast> castArrayList) {
        this.castArrayList = castArrayList;
    }




    static class cast
    {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
