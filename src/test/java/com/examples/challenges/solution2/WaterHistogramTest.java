package com.examples.challenges.solution2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class WaterHistogramTest {

    @Test
    public void simpleTest1() {
        int[] histogram = {0, 0, 2, 0, 2, 0, 1};
        int histogramVolume = new WaterHistogram().computeHistogramVolume(histogram);
        assertThat(histogramVolume, is(3));
    }

    @Test
    public void simpleTest2() {
        int[] histogram = {0, 0, 1, 0, 1, 0, 1};
        int histogramVolume = new WaterHistogram().computeHistogramVolume(histogram);
        assertThat(histogramVolume, is(2));
    }

    @Test
    public void simpleTest3() {
        int[] histogram = {2, 0, 2, 0, 2 ,1 ,0};
        int histogramVolume = new WaterHistogram().computeHistogramVolume(histogram);
        assertThat(histogramVolume, is(4));
    }

    @Test
    public void simpleTest4() {
        int[] histogram = {0, 2, 0, 2, 3, 0, 1, 3, 0, 1, 0, 1};
        int histogramVolume = new WaterHistogram().computeHistogramVolume(histogram);
        assertThat(histogramVolume, is(9));
    }

}