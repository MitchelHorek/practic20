package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("War.txt");
        Scanner scan = new Scanner(reader);
        String text = "";
        String rezerv;
        while (scan.hasNextLine()) {
            text += scan.nextLine() + " ";
        }
        rezerv = text.replace(" ","#");
        text = text.replace(".", " ");
        text = text.replace(",", " ");
        text = text.replace(":", " ");
        text = text.replace("!", " ");
        text = text.replace("?", " ");
        text = text.replace("—", " ");
        text = text.replace("«", " ");
        text = text.replace(";", " ");
        text = text.replace("“", " ");
        text = text.replace("(", " ");
        text = text.replace(")", " ");
        text = text.replace("/", " ");
        text = text.replace("[", " ");
        text = text.replace("]", " ");
        text = text.replace("<", " ");
        text = text.replace(">", " ");
        text = text.replace(" –", " ");
        text = text.replace("\n", " ");
        text = text.trim().replaceAll("\\s+", " ");
        text = text.toLowerCase();
        String[] arr = text.split(" ");
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("")) {
                dictionary.put(arr[i], dictionary.get(arr[i]) == null ? 1 : dictionary.get(arr[i]) + 1);
            }
        }
        Stream<Map.Entry<String, Integer>> sorted = dictionary.entrySet().stream().sorted(Map.Entry.comparingByValue());
        Object[] result = sorted.toArray();
        for (int i = result.length - 1; i > result.length - 11; i--) {
            System.out.println(result[i].toString());
        }
        FileWriter myWriter = new FileWriter("NewWar.txt");
        myWriter.write(rezerv);
        myWriter.close();
        reader.close();
    }
}
