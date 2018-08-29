package com.mcdenny.musicalapp.model;

public class Album {
    private String albumTitle;
    private String albumArtist;
    private int albumCover;

    public Album() {
    }

    public Album(String albumTitle, String albumArtist, int albumCover) {
        this.albumTitle = albumTitle;
        this.albumArtist = albumArtist;
        this.albumCover = albumCover;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public int getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(int albumCover) {
        this.albumCover = albumCover;
    }
}
