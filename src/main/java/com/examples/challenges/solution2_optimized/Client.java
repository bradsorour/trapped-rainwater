package com.examples.challenges.solution2_optimized;

public class Client {

    static int[] histogram = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    public static void main(String[] args) {
        WaterHistogram histogramVolume = new WaterHistogram();
        System.out.println("Water volume: " + histogramVolume.computeHistogramVolume(histogram));
    }
}
