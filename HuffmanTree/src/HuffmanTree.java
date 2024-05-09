/*
The HuffmanTree class is used to construct the Huffman Tree
from information given by the nodes.
*/

import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanTree {
    private Node root;

    public HuffmanTree(HashMap<Character, Integer> frequency) {
        // Priority queue constructed in ascending order with lower frequency characters
        // first
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Character c : frequency.keySet()) {
            pq.offer(new Node(c, frequency.get(c)));
        }
        while (pq.size() > 1) {
            Node leftNode = pq.poll();
            Node rightNode = pq.poll();
            pq.offer(new Node(leftNode, rightNode));
        }

        root = pq.poll();
    }

    // Turns the encoded hashmap and appends it to a string to print to console
    public String encode(String inputString) {
        HashMap<Character, String> binaryCode = new HashMap<>();
        codeGeneration(root, "", binaryCode);

        StringBuilder encodedString = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            encodedString.append(binaryCode.get(c));
        }
        return encodedString.toString();
    }

    private void codeGeneration(Node node, String code, HashMap<Character, String> binaryCode) {
        // Traverses the huffmanTree recursively in order to generate the huffman code
        if (node.isLeaf()) {
            binaryCode.put(node.getCharacter(), code);
        } else {
            codeGeneration(node.getLeft(), code + "0", binaryCode);
            codeGeneration(node.getRight(), code + "1", binaryCode);
        }
    }
}