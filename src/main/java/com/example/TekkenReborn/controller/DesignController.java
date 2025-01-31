package com.example.TekkenReborn.controller;

import com.example.TekkenReborn.model.Anime;
import com.example.TekkenReborn.model.CharacterPool;
import com.example.TekkenReborn.model.Fighter;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        var animes = Stream.of(Anime.values()).map(Anime::getName).collect(Collectors.toList());
        model.addAttribute("animes", animes);
        log.info("Add animes");
    }

    @ModelAttribute
    public Fighter fighter() {
        return Fighter.builder().build();
    }

    @GetMapping
    public String showDesign() {
        return "design";
    }

    @PostMapping
    public String processHero(@Valid Fighter fighter, BindingResult bindingResult, @ModelAttribute("characterPool") CharacterPool characterPool) {
        if(bindingResult.hasErrors() ){
            log.warn("Validation errors found: {}", bindingResult.getAllErrors());
            return "design";
        }

        characterPool.addHero(fighter);
        log.info("Added new fighter: {}", fighter);
        return "redirect:/design";
    }
}
