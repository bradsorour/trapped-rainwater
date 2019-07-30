package com.examples.challenges.solution2_optimized_simplified;

public class Client {

    //static int[] histogram = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0};
    static int[] histogram = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    public static void main(String[] args) {
        WaterHistogram histogramVolume = new WaterHistogram();
        System.out.println("Water volume: " + histogramVolume.computeHistogramVolume(histogram));
    }
}
