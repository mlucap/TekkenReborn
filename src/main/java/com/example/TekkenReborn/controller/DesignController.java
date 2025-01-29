package com.example.TekkenReborn.controller;

import com.example.TekkenReborn.model.Anime;
import com.example.TekkenReborn.model.CharacterPool;
import com.example.TekkenReborn.model.Fighter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("characterPool")
public class DesignController {
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("characterPool", new CharacterPool());
        log.info("Add character pool");
    }

    @ModelAttribute
    public void addAnimes(Model model) {
        var anime = List.of(Anime.values()).stream().map(Anime::getName).collect(Collectors.toList());
        model.addAttribute("animes", anime);
        log.info("Add animes");
    }

    @ModelAttribute(name = "fighter")
    public Fighter fighter() {
        return new Fighter(null, 0, 0, 0, null);
    }

    @GetMapping
    public String showDesign() {
        return "design";
    }
}
