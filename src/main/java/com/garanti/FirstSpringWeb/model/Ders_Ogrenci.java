package com.garanti.FirstSpringWeb.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ders_Ogrenci {
    private Integer ID;

    private Integer DERS_ID;

    private Integer OGRENCI_ID;

    private Integer NOTE;

    private Integer DEVAMSIZLIK;

    public Ders_Ogrenci(Integer ID, Integer DERS_ID, Integer OGRENCI_ID) {
        this.ID = ID;
        this.DERS_ID = DERS_ID;
        this.OGRENCI_ID = OGRENCI_ID;
    }

    public Ders_Ogrenci(Integer DERS_ID, Integer OGRENCI_ID) {
        this.DERS_ID = DERS_ID;
        this.OGRENCI_ID = OGRENCI_ID;
    }
}
