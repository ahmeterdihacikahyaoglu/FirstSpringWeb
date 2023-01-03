package com.garanti.FirstSpringWeb.repo;

import com.garanti.FirstSpringWeb.model.Ders;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class DersRepo {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Ders> getAll() {
        return jdbcTemplate.query("select * from BILGE.DERS", BeanPropertyRowMapper.newInstance(Ders.class));
    }

    public Ders getById(int id) {

        Ders ders = null;
        String sql = "select * from BILGE.DERS where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        ders = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Ders.class));
        return ders;
    }

    public boolean deleteById(int id) {
        String sql = "delete from BILGE.DERS where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
    }

    public boolean save(Ders ders) {
        String sql = "Insert into BILGE.DERS (OGR_ID, KONU_ID) values (:OGR_ID, :KONU_ID)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("OGR_ID", ders.getOGR_ID());
        paramMap.put("KONU_ID", ders.getKONU_ID());
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
    }
}
