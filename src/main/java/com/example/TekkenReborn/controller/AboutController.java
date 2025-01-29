package com.example.TekkenReborn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

class Song {
    private String artist;
    private String title;

    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
}

@Controller
public class AboutController {
    @GetMapping("/about")
    public String about(Model model) {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Rose", "drinks or coffee"));
        songs.add(new Song("Rose", "toxic till the end"));
        songs.add(new Song("Kendrick Lamar", "heart pt.6"));
        songs.add(new Song("Kendrick Lamar", "dodger blue"));
        songs.add(new Song("The Marias", "Run your mouth"));
        songs.add(new Song("The Marias", "Ay No Puedo"));
        songs.add(new Song("The Marias", "Paranoia"));
        songs.add(new Song("Kali Uchis", "Igual Que Un Angel"));
        model.addAttribute("songs", songs);

        model.addAttribute("heading", "Tekken Reborn");
        model.addAttribute("about", "I am a student developer currently in my second of three semesters. I hope to find an internship this summer!");
        return "about";
    }
}
