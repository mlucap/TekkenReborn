package com.example.TekkenReborn.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class CharacterPool {
    private List<Fighter> fighters = new ArrayList<>();
    public void addHero(Fighter fighter) {
        fighters.add(fighter);
    }
}
