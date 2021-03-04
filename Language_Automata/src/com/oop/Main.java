package com.oop;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;


public class Main {
    public static Map<String, List<String>> Rules = new HashMap<String, List<String>>();

    String compar = "S";
    String input = "aabcbb";


    public static void main(String[] args) {
        Rules.put("S", new ArrayList<String>(Arrays.asList("aB")));
        Rules.put("B", new ArrayList<String>(Arrays.asList("bB", "cL")));
        Rules.put("L", new ArrayList<String>(Arrays.asList("cL", "aS","b")));


        System.out.println(Arrays.asList(Rules));

        Main main = new Main();
        main.cycle();

    }


    public void cycle() {
        for (int i = 0; i < input.length(); i++) {
            while (i < input.length()) {

                if (!input.matches("[abc]+")) {       //look for characters that are NOT a or b or c
                    System.out.println("Incorrect string");
                    return;
                }

                if (Arrays.toString(Rules.keySet().toArray()).contains("S")&& compar.contains("S") && input.charAt(i) == 'a') {//0
                    compar = compar.replace("S", "aB");
                    i++;
                    System.out.println("\t" + compar);

                }
                System.out.println("\t" + compar);
                if (Arrays.toString(Rules.keySet().toArray()).contains("B") && compar.contains("B") && input.charAt(i) == 'b') {//2
                    compar = compar.replace("B", "bB");
                    i++;
                    System.out.println("\t" + compar);
                } else if(Arrays.toString(Rules.keySet().toArray()).contains("B") && compar.contains("B") && input.charAt(i) == 'c'){
                    compar = compar.replace("B", "cL");
                    i++;
                    System.out.println("\t" + compar);
                }
                if (Arrays.toString(Rules.keySet().toArray()).contains("L") && compar.contains("L") && input.charAt(i) == 'c') { //3
                    compar = compar.replace("L", "cL");
                    i++;
                    System.out.println("\t" + compar);
                } else if(Arrays.toString(Rules.keySet().toArray()).contains("L") && compar.contains("L") && input.charAt(i) == 'a'){
                    compar = compar.replace("L", "aS");
                    i++;
                    System.out.println("\t" + compar);
                }else if(Arrays.toString(Rules.keySet().toArray()).contains("L") && compar.contains("L") && input.charAt(i) == 'b'){
                    compar = compar.replace("L", "b");
                    i++;
                    System.out.println("\t" + compar);
                }
                if (compar.endsWith("S") ||  compar.endsWith("B") || compar.endsWith("L")) {
                    System.out.println("Neterminal at the final.");
                    return;
                }
                if (compar.equals(input)) {
                    System.out.println("String conforms to the rules.");
                    return;
                }else if(i==compar.length()) {
                    System.out.printf("String unbuildable.");
                    return;
                }
            }
        }
    }
}