package com.mcdenny.musicalapp.model;

public class Artist {
    private String artistName;
    private int artistPhoto;

    public Artist() {
    }

    public Artist(String artistName, int artistPhoto) {
        this.artistName = artistName;
        this.artistPhoto = artistPhoto;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getArtistPhoto() {
        return artistPhoto;
    }

    public void setArtistPhoto(int artistPhoto) {
        this.artistPhoto = artistPhoto;
    }
}
