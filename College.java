package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class College{

    public static void main(String[] args) {
        // Sample email
        String email = "kalyani@gmail.com";
        
        // Create a random number generator using the email's hash code
        Random random = new Random(email.hashCode());

        // Generate nodes and edges
        List<String> nodes = generateNodes(random);
        List<Edge> edges = generateEdges(nodes, random);

        // Print nodes and edges
        System.out.println("Nodes: " + nodes);
        System.out.println("Edges: " + edges);
    }

    // Generate nodes based on random
    private static List<String> generateNodes(Random random) {
        // Generate a random number of nodes between 5 and 9
        int numNodes = random.nextInt(5) + 5;
        List<String> nodes = new ArrayList<>();
        
        // Generate node names
        for (int i = 0; i < numNodes; i++) {
            nodes.add(generateNode());
        }
        return nodes;
    }

    // Generate a random node name (two characters uppercase alphabets)
    private static String generateNode() {
        // Generate two random uppercase characters
        char first = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
        char second = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
        // Concatenate characters to form a node name
        return String.valueOf(first) + second;
    }

    // Generate edges based on nodes and random seed
    private static List<Edge> generateEdges(List<String> nodes, Random random) {
        List<Edge> edges = new ArrayList<>();
        
        // Generate edges between nodes
        for (String from : nodes) {
            // Randomly select a 'to' node (can be the same as 'from')
            String to = nodes.get(random.nextInt(nodes.size()));
            // Ensure 'from' and 'to' nodes are different
            if (!from.equals(to)) {
                // Generate a random cost between 0 and 5
                double cost = random.nextDouble() * 5;
                // Create an edge and add it to the list
                edges.add(new Edge(from, to, cost));
            }
        }
        return edges;
    }

    // Edge class representing a connection between two nodes with a cost
    static class Edge {
        String from; // Starting node
        String to;   // Ending node
        double cost; // Cost of traversal

        // Constructor for Edge class
        Edge(String from, String to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        // String representation of Edge object
        @Override
        public String toString() {
            return "{\"from\": \"" + from + "\", \"to\": \"" + to + "\", \"cost\": " + cost + "}";
        }
    }
}

