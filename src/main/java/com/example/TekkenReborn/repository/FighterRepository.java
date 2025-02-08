package com.example.TekkenReborn.repository;

import com.example.TekkenReborn.model.Fighter;

import java.util.Optional;

public interface FighterRepository {
    Iterable<Fighter> findAll();
    Optional<Fighter> findById(long id);

    void save(Fighter fighter);
}
