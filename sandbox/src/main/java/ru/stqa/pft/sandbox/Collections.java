package ru.stqa.pft.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main (String[] args) {
//        String[] langs = new String[4];
//        langs[0] = "Java";
//        langs[1] = "C#";
//        langs[2] = "Python";
//        langs[3] = "PHP";



//        for (int i = 0; i < langs.length; i++) {
//            System.out.println("Я хочу выучить " + langs[i]);
//        }

//        List<String> languages = new ArrayList<String>();
//        languages.add("Java");
//        languages.add("C#");
//        languages.add("Python");
//        languages.add("PHP");


//        String[] langs = {"Java", "C#", "Python", "PHP"};
        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

//        for (int i = 0; i < languages.size(); i++) {
//            System.out.println("Я хояу выучить " + languages.get(i));
//        }

        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}
