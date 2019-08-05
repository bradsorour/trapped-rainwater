package com.examples.challenges.solution1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

    static int[] ReadWithBufferedRead(String fileName) {

        List<List<String>> records = new ArrayList<>();
        int[] elevationMap;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                count += values.length;
                records.add(Arrays.asList(values));
            }

            elevationMap = new int[count];
            int i = 0;

            for (List<String> record : records) {
                for (String s : record) {
                    elevationMap[i] = Integer.parseInt(s);
                    i++;
                }
            }

            return elevationMap;

        } catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " not found.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
