package org.example.uploadmusic.service;

import org.example.uploadmusic.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService implements ISongService{
    List<Song> songs = new ArrayList<Song>();

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void addMusic(Song song) {
        songs.add(song);
    }

    @Override
    public void update(int id, Song song) {
        int index = songs.indexOf(findById(id));
        songs.set(index, song);

    }

    @Override
    public void delete(int id) {
        songs.removeIf(customer -> customer.getId() == id);
    }

    @Override
    public Song findById(int id) {
        return songs.get(id);
    }
}
