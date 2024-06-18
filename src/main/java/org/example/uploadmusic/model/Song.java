package org.example.uploadmusic.model;

public class Song {
    private int id;
    private String name;
    private String artist;
    private String album;
    private String fileSong;

    public Song() {
    }

    public Song(int id, String name, String artist, String album, String fileSong) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.fileSong = fileSong;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }


    public String getFileSong() {
        return fileSong;
    }

    public void setFileSong(String fileSong) {
        this.fileSong = fileSong;
    }
}
