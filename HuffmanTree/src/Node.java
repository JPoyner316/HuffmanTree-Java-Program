/*
The Node class gathers the required information about a single node 
used to build the huffman tree.
*/

public class Node implements Comparable<Node> {
    private char character;
    private int frequency;
    private Node leftNode;
    private Node rightNode;

    // One node object for isLeaf true and one for isLeaf false
    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public Node(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
    }

    /*
     * The following methods in the node class are used to gather information for
     * the node to be used in the priority queue and the encoder
     */
    public int getFrequency() {
        return frequency;
    }

    public Character getCharacter() {
        return character;
    }

    public Node getLeft() {
        return leftNode;
    }

    public Node getRight() {
        return rightNode;
    }

    public boolean isLeaf() {
        return leftNode == null && rightNode == null;
    }

    /*
     * Compares two frequencies to eachother to find which characters nodes
     * have higher frequencies
     */
    @Override
    public int compareTo(Node node) {
        return Integer.compare(frequency, node.frequency);
    }
}