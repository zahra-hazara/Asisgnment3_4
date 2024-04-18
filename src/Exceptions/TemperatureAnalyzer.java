package Exceptions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TemperatureAnalyzer {

    public static void main(String[] args) {
        try {
            // Define the URL of the CSV file
            String url = "https://users.metropolia.fi/~jarkkov/temploki.csv";

            // Read the CSV file from the network
            List<String> lines = readCSVFromURL(url);

            // Filter data for the 1st day of January 2023
            List<Double> temperatures = filterData(lines);

            // Calculate the average temperature
            double averageTemperature = calculateAverage(temperatures);

            // Print the average temperature
            System.out.println("Average temperature on January 1, 2023: " + averageTemperature);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read CSV file from URL
    private static List<String> readCSVFromURL(String url) throws IOException {
        List<String> lines = new ArrayList<>();
        URL csvUrl = new URL(url);
        BufferedReader reader = new BufferedReader(new InputStreamReader(csvUrl.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    // Method to filter data for January 1, 2023
    private static List<Double> filterData(List<String> lines) {
        List<Double> temperatures = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 2 && parts[0].equals("2023-01-01")) {
                temperatures.add(Double.parseDouble(parts[1]));
            }
        }
        return temperatures;
    }

    // Method to calculate average temperature
    private static double calculateAverage(List<Double> temperatures) {
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }
        return temperatures.isEmpty() ? 0 : sum / temperatures.size();
    }

}
