package com.oop;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> finallist = new ArrayList<String>();
        int limit = 0;


        int n = 3;

        int[] arr = new int[n];
        Random random = new Random();
        int rand = random.nextInt(2);
        System.out.println("this is rand =" + rand);


        String input = "accb";
        String compar = "S";


        Map<String, List<String>> Rules = new HashMap<String, List<String>>();
        Rules.put("S", new ArrayList<String>(Arrays.asList("aB")));
        Rules.put("B", new ArrayList<String>(Arrays.asList("bB", "cL")));
        Rules.put("L", new ArrayList<String>(Arrays.asList("cL", "aS", "b")));


        System.out.println(Arrays.asList(Rules));
        System.out.println(Rules.values());
        System.out.println(Arrays.toString(Rules.keySet().toArray()));


         do{

            for (int i = 0; i < input.length(); i++) {
                int j = random.nextInt(2);
                int k = random.nextInt(2);
                int l = random.nextInt(2);
//                j = arr[0]; k = arr[1]; l = arr[2];
                System.out.println("j = " + j);
                System.out.println("k = " + k);
                System.out.println("l = " + l);

                if (Arrays.toString(Rules.keySet().toArray()).contains("S")) {//0
                    compar = compar.replace("S", "aB");
                    System.out.println("\t" + compar);
                }
                if (Arrays.toString(Rules.keySet().toArray()).contains("B") && j == 1) {        //1
                    compar = compar.replace("B", "bB");
                    System.out.println("\t" + compar);
                } else compar = compar.replace("B", "cL");
                System.out.println("\t" + compar);
                if (Arrays.toString(Rules.keySet().toArray()).contains("L") && k == 1) {          //2
                    compar = compar.replace("L", "cL");
                    System.out.println("\t" + compar);
                } else if (Arrays.toString(Rules.keySet().toArray()).contains("L") && l == 1) {
                    compar = compar.replace("L", "aS");
                } else {
                    compar = compar.replace("L", "b");
                    System.out.println("\t" + compar);

                    finallist.add(compar);

//                if (compar == finallist.contains(input))
                    if (compar.equals(input)) {
                        System.out.println("True");
                        break;

                    }
                    if (!(compar.contains("L")) && !(compar.contains("B")) && !(compar.contains("S")) || compar.length() > input.length() + 3) {

                        System.out.println("\t" + "final language for this iteration is " + compar);
                        limit++;
                        if (limit > 100) {
                            break;
                        }
                        compar = "S";
                    } else break;

                }
                if (compar.equals(input)) {
                    System.out.println("True");
                    break;
                }

            }
//        System.out.println("True " + compar);
             if (compar.equals(input)) {
                 System.out.println("True");
                 break;
             }
             if(limit>30){
                 System.out.println("Parsed 100 times not found  such a language try again or check the introduced language");
                 break;}


        }
         while (compar != input);
    }
}








