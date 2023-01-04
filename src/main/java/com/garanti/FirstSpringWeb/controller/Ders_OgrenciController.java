package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.Ders_Ogrenci;
import com.garanti.FirstSpringWeb.repo.Ders_OgrenciRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "ders_ogrenci")
public class Ders_OgrenciController {
    private Ders_OgrenciRepo repo;

    public Ders_OgrenciController(Ders_OgrenciRepo repo) {
        this.repo = repo;
    }

    @GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ders_Ogrenci>> getAll() {
        // localhost:9090/FirstSpringWeb/ders_ogrenci/getAll
        List<Ders_Ogrenci> res = repo.getAll();
        if (res == null || res.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping(path = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ders_Ogrenci> getByIdHeader(@RequestHeader(name = "id") Integer id) {
        // localhost:9090/FirstSpringWeb/ders_ogrenci/getById?id=1
        Ders_Ogrenci res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(path = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ders_Ogrenci> getByIdQueryParam(@RequestParam(value = "id", required = true) Integer id) {
        // localhost:9090/FirstSpringWeb/ders_ogrenci/getById?id=1
        Ders_Ogrenci res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ders_Ogrenci> getByIdPathParam(@PathVariable(value = "id") Integer id) {
        // localhost:9090/FirstSpringWeb/ders_ogrenci/getById/1
        Ders_Ogrenci res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Ders_Ogrenci ders_ogrenci) {
        // localhost:9090/FirstSpringWeb/ders_ogrenci/save
        if (repo.save(ders_ogrenci)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Başarı ile kaydedildi");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Başarı ile kaydedilemedi");
        }
    }

    @DeleteMapping(path = "deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Integer id) {
        // localhost:9090/FirstSpringWeb/ders_ogrenci/deleteById/1
        if (repo.deleteById(id)) {
            return ResponseEntity.ok("Başarı ile silindi");
        } else {
            return ResponseEntity.internalServerError().body("Başarı ile silinemedi");
        }
    }

    @DeleteMapping(path = "deleteByIdHeader")
    public ResponseEntity<String> deleteByIdHeader(@RequestHeader(value = "id") Integer id) {
        // localhost:9090/FirstSpringWeb/ders_ogrenci/deleteById/1
        if (repo.deleteById(id)) {
            return ResponseEntity.ok("Başarı ile silindi");
        } else {
            return ResponseEntity.internalServerError().body("Başarı ile silinemedi");
        }
    }
}
