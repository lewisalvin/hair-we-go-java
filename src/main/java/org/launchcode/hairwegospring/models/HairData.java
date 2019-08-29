package org.launchcode.hairwegospring.models;

import java.util.ArrayList;

public class HairData {

    String threeA;
    String threeB;
    String threeC;
    String fourA;
    String fourB;
    String fourC;






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
