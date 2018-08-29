package com.mcdenny.musicalapp.model;

public class Song {
    private String songTitle;
    private String songDuration;
    private String songArtist;

    public Song(){

    }

    public Song(String songTitle, String songDuration, String songArtist) {
        this.songTitle = songTitle;
        this.songDuration = songDuration;
        this.songArtist = songArtist;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }
}
