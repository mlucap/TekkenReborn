package com.example.TekkenReborn.model;

public enum Anime {
    NARUTO("Naruto"), BLEACH("Bleach"), ONE_PIECE("One Piece"),
    VINLAND_SAGA("Vinland Saga"),;

    public final String name;

    private Anime(String name) {this.name = name;}

    public String getName() {return name;}
}
