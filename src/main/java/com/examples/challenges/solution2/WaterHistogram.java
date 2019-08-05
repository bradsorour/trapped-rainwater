package com.examples.challenges.solution2;

public class WaterHistogram {

    public int computeHistogramVolume(int[] histogram) {

        int start = 0;
        int end = histogram.length - 1;
        int max = findIndexOfMax(histogram, start, end);
        int leftVolume = subgraphVolume(histogram, start, max, true);
        int rightVolume = subgraphVolume(histogram, max, end, false);
        return leftVolume + rightVolume;
    }

    /* Compute the volume in a subgraph of the histogram. One max is at either
     * start or end (depending on isLeft). Find second tallest, then compute volume
     * between tallest and second tallest. Then compute volume of subgraph. */
    private int subgraphVolume(int[] histogram, int start, int end, boolean isLeft) {

        if (start >= end) return 0;
        int sum = 0;

        if (isLeft) {
            int max = findIndexOfMax(histogram, start, end - 1);
            sum += borderedVolume(histogram, max, end);
            sum += subgraphVolume(histogram, start, max, isLeft);
        } else {
            int max = findIndexOfMax(histogram, start + 1, end);
            sum += borderedVolume(histogram, start, max);
            sum += subgraphVolume(histogram, max, end, isLeft);
        }

        return sum;
    }

    /* Compute volume between start and end. Assumes that tallest bar is
     * at start and second tallest is at end. */
    public int borderedVolume(int[] histogram, int start, int end) {

        if (start >= end) return 0;

        int min = Math.min(histogram[start], histogram[end]);
        int sum = 0;

        for (int i = start + 1; i < end; i++) {
            sum += min - histogram[i];
        }

        return sum;
    }

    /* Find tallest bar in histogram between start and end */
    public int findIndexOfMax(int[] histogram, int start, int end) {

        int indexOfMax = start;

        for (int i = start + 1; i <= end; i++) {
            if (histogram[i] > histogram[indexOfMax]) {
                indexOfMax = i;
            }
        }

        return indexOfMax;
    }

}
