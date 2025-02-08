package com.example.TekkenReborn.repository.impl;

import com.example.TekkenReborn.model.Fighter;
import com.example.TekkenReborn.repository.FighterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;

@Slf4j
@Repository
public class JDBCFighterRepository implements FighterRepository {

    private JdbcTemplate jdbcTemplate;

    public JDBCFighterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Fighter> findAll() {
        return jdbcTemplate.query("SELECT * FROM fighter", new FighterRowMapper());
    }

    @Override
    public Optional<Fighter> findById(long id) {
        Fighter fighter = jdbcTemplate.queryForObject("SELECT * FROM fighter WHERE id = ?", new FighterRowMapper(), id);
        return Optional.ofNullable(fighter);
    }

    @Override
    public void save(Fighter fighter) {
        var insertFighter = "INSERT INTO fighter (name, damage_per_hit, health, resistance, anime_from, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(connection -> {
                var ps = connection.prepareStatement(insertFighter, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, fighter.getName());
                ps.setInt(2, fighter.getDamagePerHit());
                ps.setInt(3, fighter.getHealth());
                ps.setDouble(4, fighter.getResistance());
                ps.setString(5, fighter.getAnimeFrom().name());
                ps.setTimestamp(6, new Timestamp(fighter.getCreatedAt().getTime()));
                return ps;
            }, keyHolder);
        } catch (DataAccessException e) {
            log.error("Failed to save fighter to database: {}", e.getMessage());
        }
    }
}
