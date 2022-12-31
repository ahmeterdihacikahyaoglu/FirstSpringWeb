package com.garanti.FirstSpringWeb.model;

public class DersDTO
{
    private Integer ID;

    private String OGRETMEN;

    private String KONU;

    public Integer getID() {
        return ID;
    }

    public String getOGRETMEN() {
        return OGRETMEN;
    }

    public String getKONU() {
        return KONU;
    }

    public DersDTO(Integer ID, String OGRETMEN, String KONU)
    {
        this.ID = ID;
        this.OGRETMEN = OGRETMEN;
        this.KONU = KONU;
    }
}