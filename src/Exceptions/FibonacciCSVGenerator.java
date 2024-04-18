package Exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class FibonacciCSVGenerator {

    public static void main(String[] args) {
        // Generate Fibonacci sequence of 100 numbers
        long[] fibonacciSequence = generateFibonacciSequence(100);

        // Write Fibonacci sequence to CSV file
        String csvFilePath = "fibonacci_sequence.csv";
        writeFibonacciSequenceToCSV(fibonacciSequence, csvFilePath);

        System.out.println("Fibonacci sequence has been written to: " + csvFilePath);
    }

    // Method to generate Fibonacci sequence of n numbers
    private static long[] generateFibonacciSequence(int n) {
        long[] sequence = new long[n];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i < n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence;
    }

    // Method to write Fibonacci sequence to CSV file
    private static void writeFibonacciSequenceToCSV(long[] sequence, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < sequence.length; i++) {
                writer.append(i + 1 + "," + sequence[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
