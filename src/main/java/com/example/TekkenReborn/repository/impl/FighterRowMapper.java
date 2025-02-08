package com.example.TekkenReborn.repository.impl;

import com.example.TekkenReborn.model.Anime;
import com.example.TekkenReborn.model.Fighter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FighterRowMapper implements RowMapper<Fighter> {
    @Override
    public Fighter mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Fighter.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .damagePerHit(rs.getInt("damage_per_hit"))
                .health(rs.getInt("health"))
                .resistance(rs.getDouble("resistance"))
                .animeFrom(Anime.valueOf(rs.getString("anime_from")))
                .build();
    }
}
