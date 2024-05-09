/*
Jackson D. Poyner
04/24/2023
The following program is a Huffman Tree designed to compress a string into binary,
and show information such as the 7-bit and 8-bit ASCII to the user.
*/
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initial input
        System.out.print("Welcome to HuffmanCoding please enter a word: ");
        Scanner scan = new Scanner(System.in);
        String inputString;
        while (true) {
            inputString = scan.nextLine();
            if (inputString == "") {
                System.out.println("Please input a real value");
            } else {
                break;
            }
        }
        char[] StrToCharArray = stringToCharacter(inputString);

        /*
         * Places every unique word from a character array into a hashmap with its
         * frequency
         */
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for (char c : stringToCharacter(inputString)) {
            if (charFrequency.containsKey(c)) {
                charFrequency.put(c, charFrequency.get(c) + 1);
            } else {
                charFrequency.put(c, 1);
            }
        }
        // Output information
        if (charFrequency.size() < 2) {
            // Edge case for if a single character is inputted
            System.out.println("Total Characters In Word: " + StrToCharArray.length);
            System.out.println("Encoded String: " + "0".repeat(StrToCharArray.length));
            System.out.println("7-bit ASCII: " + inputString.length() * 7);
            System.out.println("8-bit ASCII: " + inputString.length() * 8);
        } else {
            // Construct HuffmanTree from Hashmap
            HuffmanTree huffmanTree = new HuffmanTree(charFrequency);

            // Encoded String using HuffmanTree
            String encodedString = huffmanTree.encode(inputString);

            System.out.println("Total Characters In Word: " + StrToCharArray.length);
            System.out.println("Encoded String: " + encodedString);
            System.out.println("7-bit ASCII: " + inputString.length() * 7);
            System.out.println("8-bit ASCII: " + inputString.length() * 8);
        }
    }

    // method that converts given string to an array of characters
    public static char[] stringToCharacter(String str) {
        char[] charArray = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }
}