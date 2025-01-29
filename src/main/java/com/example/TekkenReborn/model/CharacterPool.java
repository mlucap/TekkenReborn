package com.example.TekkenReborn.model;

import lombok.Data;
import java.util.List;

@Data
public class CharacterPool {
    private List<Fighter> fighters;
    public void addHero(Fighter fighter) {
        fighters.add(fighter);
    }
}
