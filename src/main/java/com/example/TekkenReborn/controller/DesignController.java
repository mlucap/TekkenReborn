package com.example.TekkenReborn.controller;

import com.example.TekkenReborn.model.Anime;
import com.example.TekkenReborn.model.Fighter;
import com.example.TekkenReborn.repository.impl.JDBCFighterRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignController {

    @Autowired
    private JDBCFighterRepository jdbcFighterRepository;

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
    public String processHero(@Valid Fighter fighter, BindingResult bindingResult) {
        if(bindingResult.hasErrors() ){
            log.warn("Validation errors found: {}", bindingResult.getAllErrors());
            return "design";
        }

        jdbcFighterRepository.save(fighter);
        log.info("Added new fighter: {}", fighter.getName());
        return "redirect:/design";
    }
}
