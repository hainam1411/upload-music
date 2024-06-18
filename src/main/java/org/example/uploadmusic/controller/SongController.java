package org.example.uploadmusic.controller;

import org.example.uploadmusic.model.Song;
import org.example.uploadmusic.model.SongForm;
import org.example.uploadmusic.service.ISongService;
import org.example.uploadmusic.service.SongService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class SongController {

    @Value("${file-upload}")
    private String fileUpload;

    private final ISongService songService = new SongService();
    @GetMapping
    public ModelAndView index() {
        List<Song> songs = songService.findAll();
        ModelAndView model = new ModelAndView("/index");
        model.addObject("songs", songs);
        return model;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("SongForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getFileSong();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getFileSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(), songForm.getArtist(), songForm.getAlbum(), fileName);
        songService.save(song);

        return "redirect:/music";
    }
}
