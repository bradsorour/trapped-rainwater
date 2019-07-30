package com.examples.challenges.solution2_optimized;

public class WaterHistogram {


    /* We've chosen a HistogramData object to store extra information,
     * but we could also use a two-dimensional array. */
    int computeHistogramVolume(int[] histogram) {

        int start = 0;
        int end = histogram.length - 1;

        HistogramData[] data = createHistogramData(histogram);

        int max = data[0].getRightMaxIndex(); // Get overall max
        int leftVolume = subgraphVolume(data, start, max, true);
        int rightVolume = subgraphVolume(data, max, end, false);

        return leftVolume + rightVolume;
    }


    HistogramData[] createHistogramData(int[] histo) {

        HistogramData[] histogram = new HistogramData[histo.length];

        for (int i = 0; i < histo.length; i++) {
            histogram[i] = new HistogramData(histo[i]);
        }

        /* Set left max index */
        int maxIndex = 0;
        for (int i = 0; i < histo.length; i++) {

            if (histo[maxIndex] < histo[i]) {
                maxIndex = i;
            }
            histogram[i].setLeftMaxIndex(maxIndex);
        }

        /* Set right max index */
        maxIndex = histogram.length - 1;
        for (int i = histogram.length - 1; i >= 0; i--) {

            if (histo[maxIndex] < histo[i]) {
                maxIndex = i;
            }
            histogram[i].setRightMaxIndex(maxIndex);
        }

        return histogram;
    }

    /* Compute the volume in a subgraph of the histogram. One max is at either
     * start or end (depending on isLeft). Find second tallest, then compute volume
     * between tallest and second tallest. Then compute volume od subgraph. */
    int subgraphVolume(HistogramData[] histogram, int start, int end, boolean isLeft) {

        if (start >= end) return 0;
        int sum = 0;

        if (isLeft) {
            int max = histogram[end - 1].getLeftMaxIndex();
            sum += borderedVolume(histogram, max, end);
            sum += subgraphVolume(histogram, start, max, isLeft);
        } else {
            int max = histogram[start + 1].getRightMaxIndex();
            sum += borderedVolume(histogram, start, max);
            sum += subgraphVolume(histogram, max, end, isLeft);
        }

        return sum;
    }

    /* Compute volume between start and end. Assumes that tallest bar is
     * at start and second tallest is at end. */
    private int borderedVolume(HistogramData[] data, int start, int end) {

        if (start >= end) return 0;

        int min = Math.min(data[start].getHeight(), data[end].getHeight());
        int sum = 0;

        for (int i = start + 1; i < end; i++) {
            sum += min - data[i].getHeight();
        }

        return sum;
    }

}
