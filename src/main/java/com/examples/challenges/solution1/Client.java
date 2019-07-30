package com.examples.challenges.solution1;

public class Client {

    static int[] elevationMap = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    public static void main(String[] args) {
        TrappedWater trappedWater = new TrappedWater(elevationMap);
        int startIndex = trappedWater.getStartIndex();
        System.out.println("Output: " + trappedWater.getWaterVolumeInElevationMap(startIndex));
    }
}
