package com.example.TekkenReborn.model;

public enum Anime {
    NARUTO("Naruto"), BLEACH("Bleach"), TEKKEN("Tekken");

    public final String name;

    private Anime(String name) {this.name = name;}

    public String getName() {return name.toUpperCase();}
}
