package com.examples.challenges.solution2_optimized_simplified;

public class WaterHistogram {


    /* Go through each bar and compute the volume of water above it.
     * Volume of water at a bar =
     *   height - min(tallest bar on left, tallest bar on right).
     *   [where above equation is positive]
     * Compute the left max in the first sweep, then sweep again to
     * compute the right max, minimum of the bar heights and the delta.
     */
    public int computeHistogramVolume(int[] histo) {

        // get left max
        int[] leftMaxes = new int[histo.length];
        int leftMax = histo[0];

        for (int i = 0; i < histo.length; i++) {
            leftMax = Math.max(leftMax, histo[i]);
            leftMaxes[i] = leftMax;
            //System.out.println(leftMax);
        }

        int sum = 0;

        // get right max
        int rightMax = histo[histo.length - 1];

        for (int i = histo.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, histo[i]);
            int secondTallest = Math.min(rightMax, leftMaxes[i]);

            /* If there are taller things on the left and right
             * side, then there is water above this bar. Compute
             * the volume and add to the sum.
             */
            if (secondTallest > histo[i]) {
                sum += secondTallest - histo[i];
            }
        }

        return sum;

    }
}
