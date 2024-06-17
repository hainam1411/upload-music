package org.example.uploadmusic.controller;

import org.example.uploadmusic.model.Song;
import org.example.uploadmusic.service.ISongService;
import org.example.uploadmusic.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/music")
public class SongController {
    private final ISongService songService = new SongService();
    @GetMapping
    public ModelAndView index() {
        List<Song> songs = songService.findAll();
        ModelAndView model = new ModelAndView("/index");
        model.addObject("songs", songs);
        return model;
    }
}
