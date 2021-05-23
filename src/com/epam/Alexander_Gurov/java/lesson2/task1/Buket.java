package com.epam.Alexander_Gurov.java.lesson2.task1;

public class Buket {
    private String viborCvetok;
    private String viborCvet;
    private byte viborKolichestvo;
    static int stoimost;

    public Buket(String viborCvetok,String viborCvet,byte viborKolichestvo){
        this.viborCvetok = viborCvetok;
        this.viborCvet = viborCvet;
        this.viborKolichestvo = viborKolichestvo;
    }

    public String getViborCvetok(){
        return this.viborCvetok;
    }

    public String getViborCvet(){
        return this.viborCvet;
    }

    public int Stoimost(Buket buket,Cvetok cvetok) {
        stoimost=0;
        return stoimost = stoimost + buket.viborKolichestvo * cvetok.getCena();
    }

    void Display (){
       System.out.println("Cvetok: "+viborCvetok+", cvet: "+viborCvet+", kolichestvo: "+viborKolichestvo);
    }

}
