package org.example.uploadmusic.service;

import org.example.uploadmusic.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void addMusic(Song song);
    void update(int id, Song song);
    void delete(int id);
    Song findById(int id);

    void save(Song song);
}
