package org.example.uploadmusic.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ListService {
    List<ListMusic> listMusics = new ArrayList<>();

    public ListService() {
        listMusics.add(new ListMusic(1,"J-Pop"));
        listMusics.add(new ListMusic(1,"Co phong"));
        listMusics.add(new ListMusic(1,"US-UK"));
    }

    public List<ListMusic> getListMusics() {
        return listMusics;
    }
}
