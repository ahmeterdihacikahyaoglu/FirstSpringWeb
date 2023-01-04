package com.garanti.FirstSpringWeb.repo;

import com.garanti.FirstSpringWeb.model.Ogrenci;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class OgrenciRepo {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Ogrenci> getAll() {
        return jdbcTemplate.query("select * from BILGE.OGRENCI", BeanPropertyRowMapper.newInstance(Ogrenci.class));
    }

    public Ogrenci getById(int id) {
        Ogrenci ogrenci = null;
        String sql = "select * from BILGE.OGRENCI where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        ogrenci = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Ogrenci.class));
        return ogrenci;
    }

    public boolean deleteById(int id) {
        String sql = "delete from BILGE.OGRENCI where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
    }

    public boolean save(Ogrenci ogrenci) {
        String sql = "Insert into BILGE.OGRENCI (NAME,OGR_NUMBER,YEAR) values (:NAME, :OGR_NUMBER, :YEAR )";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("NAME", ogrenci.getNAME());
        paramMap.put("OGR_NUMBER", ogrenci.getOGR_NUMBER());
        paramMap.put("YEAR", ogrenci.getYEAR());
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;

    }


}
