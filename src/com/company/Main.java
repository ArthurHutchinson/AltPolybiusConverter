package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Will try to encapsulate all of these later.

        String test = "a1c3b2 a1b2c3 a1b2c3";

        // Why do I need to /2 to prevent getting nulls?
        // Why do I need to do i/2 on testString[i]??
        // Is there a better way to write this w/o using a list?
        String[] testString = new String[test.length() / 2];
        for (int i = 0; i < test.length(); i += 2) {
            testString[i / 2] = test.substring(i, i + 2);
        }
        System.out.println("Test String 1 " + Arrays.toString(testString));

        // This works really well.
        List<String> testList = new ArrayList<>();
        for (int i = 0; i < test.length(); i += 2) {
            testList.add(test.substring(i, i + 2));
        }

        System.out.println("Test String 2 " + testList);


        Scanner input = new Scanner(System.in);

        System.out.println("Are we (e)ncoding or (d)ecoding?");
        String inputED = input.nextLine();

        System.out.println("Please enter your string text: ");
        String inputString = input.nextLine();
        String lowerInputString = inputString.toLowerCase();


        Map<Character, String> encoding = new HashMap<>();
        encoding.put('a', "a1");
        encoding.put('b', "b1");
        encoding.put('c', "c1");
        encoding.put('d', "d1");
        encoding.put('e', "e1");
        encoding.put('f', "a2");
        encoding.put('g', "b2");
        encoding.put('h', "c2");
        encoding.put('i', "d2");
        encoding.put('j', "d2");
        encoding.put('k', "e2");
        encoding.put('l', "a3");
        encoding.put('m', "b3");
        encoding.put('n', "c3");
        encoding.put('o', "d3");
        encoding.put('p', "e3");
        encoding.put('q', "a4");
        encoding.put('r', "b4");
        encoding.put('s', "c4");
        encoding.put('t', "d4");
        encoding.put('u', "e4");
        encoding.put('v', "a5");
        encoding.put('w', "b5");
        encoding.put('x', "c5");
        encoding.put('y', "d5");
        encoding.put('z', "e5");
        encoding.put(' ', "**");

        Map<String, String> decoding = new HashMap<>();
        decoding.put("a1", "a");
        decoding.put("b1", "b");
        decoding.put("c1", "c");
        decoding.put("d1", "d");
        decoding.put("e1", "e");
        decoding.put("a2", "f");
        decoding.put("b2", "g");
        decoding.put("c2", "h");
        decoding.put("d2", "(i/j)");
        decoding.put("e2", "k");
        decoding.put("a3", "l");
        decoding.put("b3", "m");
        decoding.put("c3", "n");
        decoding.put("d3", "o");
        decoding.put("e3", "p");
        decoding.put("a4", "q");
        decoding.put("b4", "r");
        decoding.put("c4", "s");
        decoding.put("d4", "t");
        decoding.put("e4", "u");
        decoding.put("a5", "v");
        decoding.put("b5", "w");
        decoding.put("c5", "x");
        decoding.put("d5", "y");
        decoding.put("e5", "z");
        decoding.put("**", " ");


        StringBuilder doneConverting = new StringBuilder();

        if (inputED.equalsIgnoreCase("E")) {
            for (char eachChar : lowerInputString.toCharArray()) {
                if (encoding.containsKey(eachChar)) {
                    doneConverting.append(encoding.get(eachChar));
                } else {
                    doneConverting.append(eachChar);
                }
            }
        }

        if (inputED.equalsIgnoreCase("D")) {
            String removeSpaces = lowerInputString.replace(" ", "  "); // keep this incase of spaces.
            List<String> stringList = new ArrayList<>();
            for (int i = 0; i < removeSpaces.length(); i+=2) {
                stringList.add(removeSpaces.substring(i,i+2));
            }

            for (String currentString : stringList) {
                if (decoding.containsKey(currentString)) {
                    doneConverting.append(decoding.get(currentString));
                } else {
                    doneConverting.append(currentString);
                }
            }
        }

        System.out.println(doneConverting);

    }
}
