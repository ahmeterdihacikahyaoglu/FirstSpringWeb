package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.Ders;
import com.garanti.FirstSpringWeb.repo.DersRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "ders")
public class DersController {
    private DersRepo repo;

    public DersController(DersRepo repo) {
        this.repo = repo;
    }

    @GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ders>> getAll() {
        // localhost:9090/FirstSpringWeb/ders/getAll
        List<Ders> res = repo.getAll();
        if (res == null || res.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping(path = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ders> getByIdHeader(@RequestHeader(name = "id") Integer id) {
        // localhost:9090/FirstSpringWeb/ders/getById?id=1
        Ders res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(path = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ders> getByIdQueryParam(@RequestParam(value = "id", required = true) Integer id) {
        // localhost:9090/FirstSpringWeb/ders/getById?id=1
        Ders res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ders> getByIdPathParam(@PathVariable(value = "id") Integer id) {
        // localhost:9090/FirstSpringWeb/ders/getById/1
        Ders res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Ders ders) {
        // localhost:9090/FirstSpringWeb/ders/save
        boolean res = false;
//        try
//        {
        res = repo.save(ders);
//        }
//        catch (CannotGetJdbcConnectionException e)
//        {
//            // mesaj önemli
//            System.err.println(e.getMessage());
//        }
        if (res) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Başarı ile kaydedildi");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Başarı ile kaydedilemedi");
        }
    }

    @DeleteMapping(path = "deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Integer id) {
        // localhost:9090/FirstSpringWeb/ders/deleteById/1
        if (repo.deleteById(id)) {
            return ResponseEntity.ok("Başarı ile silindi");
        } else {
            return ResponseEntity.internalServerError().body("Başarı ile silinemedi");
        }
    }

    @DeleteMapping(path = "deleteByIdHeader")
    public ResponseEntity<String> deleteByIdHeader(@RequestHeader(value = "id") Integer id) {
        // localhost:9090/FirstSpringWeb/ders/deleteById/1
        if (repo.deleteById(id)) {
            return ResponseEntity.ok("Başarı ile silindi");
        } else {
            return ResponseEntity.internalServerError().body("Başarı ile silinemedi");
        }
    }

}
