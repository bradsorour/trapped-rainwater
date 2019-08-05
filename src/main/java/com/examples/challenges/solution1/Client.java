package com.examples.challenges.solution1;

public class Client {

    private static int[] elevationMap;

    public static void main(String[] args) {

        if (args == null || args.length < 1)
            elevationMap = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        else
            elevationMap = CsvReader.ReadWithBufferedRead(args[0]);

        TrappedWater trappedWater = new TrappedWater(elevationMap);
        int startIndex = trappedWater.getStartIndex();
        System.out.println("Water volume: " + trappedWater.getWaterVolumeInElevationMap(startIndex));
    }
}
