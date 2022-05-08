package com.company;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        List<String> listDocOpen = new ArrayList<>();

        File finFile = new File("C:\\Users\\katerina\\IdeaProjects\\" +
                "dz_les14\\src\\com\\company\\FileDocs\\doc3");
        FileWriter writer = new FileWriter(finFile);
        List<String> listDocControl = new ArrayList<>();
        HashSet<String> finControl = new HashSet<>();




        System.out.println("\nInsert Path of package ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();


        while (true) {
            HashSet<String> set = new HashSet<>();
            HashMap<Integer, String> map = new HashMap<>();

            System.out.println("\nInsert name of document ");
            String fileName = sc.nextLine();

            listDocOpen.add(fileName);

            File file = new File(path + "\\\\" + fileName);

            Scanner read = new Scanner(file);
            String value = "";
            int num = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                num++;
                if (!line.startsWith("docNum") && !line.startsWith("contract")) {
                    value = line + " -no start docNum / no start contract";
                    map.put(num, value);

                } else if (line.length() > 15) {
                    value = line + " -after 15 characters";
                    map.put(num, value);

                } else {
                    set.add(line);
                    value = line + " Correct";
                    map.put(num, value);
                    set.add(line);
                }
            }
            read.close();


            for (String i : set) {
                if (i.length() <= 15 &&(i.startsWith("docNum") || i.startsWith("contract"))) {
                    listDocControl.add(i);
                }
            }

            for (Map.Entry<Integer, String> item : map.entrySet()) {
                System.out.printf("Key: %d  Doc num: %s \n", item.getKey(), item.getValue());
            }


            System.out.println("\nfinish (0) /continue select doc pres enter any character :");
            Scanner result = new Scanner(System.in);
            int a = result.nextInt();
            switch (a) {
                case 0 :
                    System.out.println("\nFile open : ");
                    for (String doc : listDocOpen) {
                        System.out.println(" - "+doc);
                    }
                    for (String document : listDocControl) {
                        finControl.add(document);
                    }
                    for (String is : finControl) {
                            writer.write(is + "\n");
                    }
                    writer.close();

                    System.out.println("\nfile save in doc3! result (duplicate delete) : ");
                    Scanner rider = new Scanner(finFile);
                    int counter = 0;
                    while (rider.hasNextLine()) {
                        counter++;
                        String lines = rider.nextLine();
                        System.out.println(counter + " " + lines);
                    }
                    rider.close();
                    return;
            }
        }
//        List<String> listDocOp = new ArrayList<>();
//        File finFile = new File("C:\\Users\\katerina\\IdeaProjects\\" +
//                "dz_les14\\src\\com\\company\\FileDocs\\doc3");
//        List<String> listDoc = new ArrayList<>();
//        FileWriter writer = new FileWriter(finFile);
//        HashSet<String> set = new HashSet<>();
//        HashMap<Integer, String> map = new HashMap<>();
//
//        System.out.println("\nInsert Path of package ");
//        Scanner sc = new Scanner(System.in);
//        String path = sc.nextLine();
//
//    System.out.println("\nInsert name of document");
//    String fileName = sc.nextLine();
//    listDocOp.add(fileName);
//    File file = new File(path + "\\\\" + fileName);
//
//        Scanner read = new Scanner(file);
//        while (read.hasNextLine()) {
//            String line = read.nextLine();
//            listDoc.add(line);
//        }
//        read.close();
//        set.addAll(listDoc);
//            int num=0;
//        String value = "";
//        for(String sets : set){
//            num++;
//            if (!sets.startsWith("docNum") && !sets.startsWith("contract")) {
//                value = sets + "---no start docNum / no start contract";
//                map.put(num, value);
//            } else if (sets.length() > 15) {
//                value = sets + "---after 15 characters";
//                map.put(num, value);
//            } else {
//                value = sets + "--Correct";
//                map.put(num, value);
//                writer.write(sets + "\n");
//            }
//        }
//
//
//        for (Map.Entry<Integer, String> item : map.entrySet()) {
//            System.out.printf("Key: %d  Doc num: %s \n", item.getKey(), item.getValue());
//        }
//        Scanner reader = new Scanner(finFile);
//        while (reader.hasNextLine()) {
//            String line = reader.nextLine();
//            System.out.println(line);
//        }
//        reader.close();
//        writer.close();

    }
    }


