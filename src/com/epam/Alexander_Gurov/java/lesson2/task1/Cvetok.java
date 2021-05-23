package com.epam.Alexander_Gurov.java.lesson2.task1;

public class Cvetok {

    private String nazvanie;
    private String cvet;
    private int cena;

    public Cvetok(String nazvanie,String cvet,int cena){
        this.nazvanie = nazvanie;
        this.cvet = cvet;
        this.cena = cena;
    }

    public String getNazvanie(){
        return this.nazvanie;
    }

    public String getCvet(){
        return this.cvet;
    }

    public int getCena(){
        return this.cena;
    }
}
