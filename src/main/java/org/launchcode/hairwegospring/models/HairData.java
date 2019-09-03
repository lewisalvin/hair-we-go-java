package org.launchcode.hairwegospring.models;



import java.util.ArrayList;



public class HairData {




    String typeHair;


    String hair;



    public HairData(String typeHair, String hair){
        this.typeHair = typeHair;
        this.hair = hair;

    }



    public String getHair() {
        return hair;
    }
    public void setHair(String hair) {
        this.hair = hair;

    }
    public String getTypeHair(){
        return typeHair;
    }

    public void setTypeHair(String typeHair){

        this.typeHair = typeHair;
    }






    static ArrayList<String> hairTypes = new ArrayList<>();
    public static ArrayList<String> getAll(){
        hairTypes.add("3A");
        hairTypes.add("3B");
        hairTypes.add("3C");
        hairTypes.add("4A");
        hairTypes.add("4B");
        hairTypes.add("4C");


        return hairTypes;
    }



}
