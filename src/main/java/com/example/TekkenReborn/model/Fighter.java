package com.example.TekkenReborn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Character name must not be blank.")
    private String name;
    @Min(value = 1, message = "Damage must be at least 1.")
    @Max(value = 100, message = "Damage must not be greater than 100.")
    private int damagePerHit;
    @Min(value = 1000, message = "Health must be at least 1000")
    private int health;
    @DecimalMin(value = "0.1", message = "Resistance must be great than 0")
    @DecimalMax(value = "10.0", message = "Resistance cannot be greater than 10")
    private double resistance;
    @NotNull(message = "You must select an anime")
    private Anime animeFrom;
}
