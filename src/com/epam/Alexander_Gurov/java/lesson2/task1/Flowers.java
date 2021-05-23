package com.epam.Alexander_Gurov.java.lesson2.task1;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;

public class Flowers {

    public static void main(String[] args){
        Flowers app = new Flowers();
        app.Menu();
    }

    public void Menu(){
        ArrayList<Cvetok> masCvetok = new ArrayList<>();
        masCvetok.add(new Cvetok("Roza","Beliy",180));
        masCvetok.add(new Cvetok("Roza","Krasniy",150));
        masCvetok.add(new Cvetok("Roza","Zheltiy",160));
        masCvetok.add(new Cvetok("Tulpan","Beliy",190));
        masCvetok.add(new Cvetok("Tulpan","Krasniy",170));
        masCvetok.add(new Cvetok("Tulpan","Zheltiy",180));
        masCvetok.add(new Cvetok("Lilia","Beliy",240));
        masCvetok.add(new Cvetok("Lilia","Krasniy",230));
        masCvetok.add(new Cvetok("Lilia","Zheltiy",230));
        System.out.println("Cvety v nalichii:");
        for (int i=0;i< masCvetok.size();i++)
            System.out.println("Cvetok: "+masCvetok.get(i).getNazvanie()+", cvet: "+masCvetok.get(i).getCvet()+", cena: "+masCvetok.get(i).getCena());
        ArrayList<Buket> masBuket = new ArrayList<>();
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try{
            boolean cikl=false;
            boolean zavershenie;
            boolean nalichie;
            while (cikl == false) {
                nalichie=false;
                zavershenie=false;
                System.out.print("Viberite cvetok: Roza, Tulpan, Lilia. Libo napishite - 'Zavershit': ");
                String viborCvetok = bufferedReader.readLine();
                if (viborCvetok.intern() == "Zavershit")
                    break;
                for (int i = 0; i < masCvetok.size(); i++) {
                    if (viborCvetok.intern() == masCvetok.get(i).getNazvanie().intern()) {
                        nalichie=true;
                        break;
                    }
                }
                if (nalichie == true){
                    while (zavershenie == false) {
                        nalichie=false;
                        System.out.print("Viberite cvet: Beliy, Krasniy, Zheltiy. Libo napishite - 'Otmena': ");
                        String viborCvet = bufferedReader.readLine();
                        if (viborCvet.intern() == "Otmena")
                            break;
                        for (int j = 0; j < masCvetok.size(); j++) {
                            if (viborCvet.intern() == masCvetok.get(j).getCvet().intern()) {
                                nalichie=true;
                                break;
                            }
                        }
                        if (nalichie == true){
                            while (zavershenie == false) {
                                System.out.print("Viberite kolichestvo. Libo napishite - 'Otmena': ");
                                String stringKolichestvo = bufferedReader.readLine();
                                if (stringKolichestvo.intern() == "Otmena"){
                                    zavershenie=true;
                                    break;
                                }
                                byte viborKolichestvo = stringToByte(stringKolichestvo);//preobrazovanie simvolov v chislo
                                if (viborKolichestvo < 1){
                                    System.out.println("Neverno vvedeno kolichestvo cvetov!");
                                }
                                else {
                                    masBuket.add(new Buket(viborCvetok, viborCvet, viborKolichestvo));
                                    zavershenie=true;
                                }
                            }
                        }
                        else
                            System.out.println("Takogo cveta v nalichii net!");
                    }
                }
                else
                    System.out.println("Takih cvetov v nalichii net!");
            }
            System.out.println("Vibran buket:");
            int StoimostBuketa = 0;
            for (int i=0;i < masBuket.size();i++){
                masBuket.get(i).Display();
                for (int j=0;j < masCvetok.size();j++){
                    if (masCvetok.get(j).getNazvanie().intern()==masBuket.get(i).getViborCvetok().intern() && masCvetok.get(j).getCvet().intern()==masBuket.get(i).getViborCvet().intern()){
                        StoimostBuketa += masBuket.get(i).Stoimost(masBuket.get(i),masCvetok.get(j));
                        System.out.println("Stoimost cvetov: "+masBuket.get(i).Stoimost(masBuket.get(i),masCvetok.get(j)));
                    }
                }
            }
            System.out.println("Stoimost buketa sostavlyaet: "+StoimostBuketa);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static byte stringToByte(String s) {//preobrazovanie simvolov v chislo
        try {
            return Byte.parseByte(s.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
