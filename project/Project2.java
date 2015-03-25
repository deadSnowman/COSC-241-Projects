package project;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author seththomas
 * @version 10/27/2012
 */
public class Project2 {

    public static void test() throws IOException {
        
        boolean flag = true;
        ArrayList<String> dict = new ArrayList<String>(); // the text document stored into an array
        ArrayList[] letter = new ArrayList[7]; // each array element contains an array possible characters
        ArrayList<String> combinations = new ArrayList<String>(); // every possible letter combination of number input
        // what words from the document can be found in the number input (don't allow duplicates
        HashSet<String> wordsContained = new HashSet<String>();
        
        
        // READ VALID USER INPUT
        BufferedReader brUserInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter a 7 digit phone number with no 0's or 1's: ");
        
        String input = "";
        while(flag){
            flag = false;
            input = "";
            input = brUserInput.readLine();
            
            for(int i = 0; i < input.length(); i++)
            {
                try{
                    if(Integer.parseInt(input.substring(i, i+1)) == 1 || Integer.parseInt(input.substring(i, i+1)) == 0)
                        flag = true;
                } catch(NumberFormatException nu){
                    flag = true;
                }
            }
            
            if(input.length() != 7)
                flag = true;
            
            // If the entry is illegal, try again
            if(flag)
                System.out.println("Enter another number. The entry either has letters, a 1 or 0, or isn't 7 digits in length.");
        }
        
        
        
        // ADD EACH LETTER TO AN ARRAY AS AN ELEMENT
        for(int i = 0; i < input.length(); i++)
            letter[i] = numToLetters(Integer.parseInt(input.substring(i, i+1)));
        
        // FORM AN ARRAY OF ALL POSSIBLE combinations
        combinations = allCombinations(letter);

        // READ AND STORE TEXT DOCUMENT INTO AN ARRAY
        dict = fileToArray("../EnglishWordList.txt");
        dict.remove(40505); //removes funny entry in the document (I couldn't figure out what caused it)
        
        // COMPARE EVERY COMBINATIONS TO THE TEXT DOCUMENT
        
        for(int i = 0; i < combinations.size(); i++)
        {
            for(int j = 0; j < dict.size(); j++)
            {
                //if(dict.get(j).contains(combinations.get(i))) //reverse this
                if(combinations.get(i).contains(dict.get(j).trim()))
                {
                    //System.out.println(dict.get(j) + "\t --> \t \""+ combinations.get(i) + "\""); //testing
                    wordsContained.add(dict.get(j));
                }
            }
        }
        
        // DISPLAY
        System.out.println("There are " + wordsContained.size() + " possible words from the document that are in the phone number: " + input);
        
        Iterator it = wordsContained.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }

    
    /**
     * Generate an array from a selected file
     * @param file the file to be used
     * @return an array where each line of the file is an element
     */
    public static ArrayList fileToArray(String file) {
        BufferedReader br = null;
        ArrayList dict = new ArrayList();
        
        // closes if empty, or reads each line into the dict ArrayList as forced lowercase words
        try {
            if(br != null)
                br.close();
            else
            {
                String line;
                br = new BufferedReader(new FileReader(file));
                while((line = br.readLine()) != null) {
                    dict.add((String)line.toLowerCase().trim());
                }
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return dict;
    }
    
    /**
     * Generate a list of all possible words combinations based on the entered phone number
     * @param letter a broken up letter representation of the number input to be converted
     * @return all word combinations
     */
    public static ArrayList allCombinations(ArrayList[] letter) {
        ArrayList<String> combinations = new ArrayList<String>();
        int index = 0;
        
        // Take and itterate over all 7 numbers to collect every combination
        for(Object n0: (ArrayList)letter[0])
            for(Object n1: (ArrayList)letter[1])
                for(Object n2: (ArrayList)letter[2])
                    for(Object n3: (ArrayList)letter[3])
                        for(Object n4: (ArrayList)letter[4])
                            for(Object n5: (ArrayList)letter[5])
                                for(Object n6: (ArrayList)letter[6]) {
                                    combinations.add(index, (String)n0 + n1 + n2 + n3 + n4 + n5 + n6);
        }
        
        return combinations;
    }
    
    /**
     * Get a number from the phone input, and convert it to it's letter representations
     * @param num the number to be converted
     * @return an ArrayList of possible characters
     */
    public static ArrayList numToLetters(int num) {
        
        ArrayList letters = new ArrayList();
        
        switch(num) {
            case 2:     letters.add("a");
                        letters.add("b");
                        letters.add("c");
                        break;
            case 3:     letters.add("d");
                        letters.add("e");
                        letters.add("f");
                        break;
            case 4:     letters.add("g");
                        letters.add("h");
                        letters.add("i");
                        break;
            case 5:     letters.add("j");
                        letters.add("k");
                        letters.add("l");
                        break;
            case 6:     letters.add("m");
                        letters.add("n");
                        letters.add("o");
                        break;
            case 7:     letters.add("p");
                        letters.add("q");
                        letters.add("r");
                        letters.add("s");
                        break;
            case 8:     letters.add("t");
                        letters.add("u");
                        letters.add("v");
                        break;
            case 9:     letters.add("w");
                        letters.add("x");
                        letters.add("y");
                        letters.add("z");
                        break;
        }
        
        return letters;
    }
    
}
