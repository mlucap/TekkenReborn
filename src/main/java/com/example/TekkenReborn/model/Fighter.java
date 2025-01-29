package com.example.TekkenReborn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fighter {
    private final String name;
    private final int damagePerHit;
    private final int health;
    private final double resistance;
    private final Anime animeFrom;
}
