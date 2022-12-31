package com.garanti.FirstSpringWeb.model;

public class Ders_OgrenciDTO
{
    private Integer ID;

    private String OGRETMEN_NAME;

    private String KONU;

    private String OGRENCI_NAME;

    private Integer NOTE;

    private Integer DEVAMSIZLIK;

    public Ders_OgrenciDTO(Integer ID, String OGRETMEN_NAME, String KONU, String OGRENCI_NAME, Integer NOTE, Integer DEVAMSIZLIK) {
        this.ID = ID;
        this.OGRETMEN_NAME = OGRETMEN_NAME;
        this.KONU = KONU;
        this.OGRENCI_NAME = OGRENCI_NAME;
        this.NOTE = NOTE;
        this.DEVAMSIZLIK = DEVAMSIZLIK;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setOGRETMEN_NAME(String OGRETMEN_NAME) {
        this.OGRETMEN_NAME = OGRETMEN_NAME;
    }

    public void setKONU(String KONU) {
        this.KONU = KONU;
    }

    public void setOGRENCI_NAME(String OGRENCI_NAME) {
        this.OGRENCI_NAME = OGRENCI_NAME;
    }

    public void setNOTE(Integer NOTE) {
        this.NOTE = NOTE;
    }

    public void setDEVAMSIZLIK(Integer DEVAMSIZLIK) {
        this.DEVAMSIZLIK = DEVAMSIZLIK;
    }

    public Integer getID() {
        return ID;
    }

    public String getOGRETMEN_NAME() {
        return OGRETMEN_NAME;
    }

    public String getKONU() {
        return KONU;
    }

    public String getOGRENCI_NAME() {
        return OGRENCI_NAME;
    }

    public Integer getNOTE() {
        return NOTE;
    }

    public Integer getDEVAMSIZLIK() {
        return DEVAMSIZLIK;
    }
}
