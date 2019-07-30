package com.examples.challenges.solution1;

public class TrappedWater {

    private int[] elevationMap;
    private int waterVolumeInElevationMap;

    public TrappedWater(int[] elevationMap) {
        this.elevationMap = elevationMap;
    }

    /*

    1. Find the starting index (n) and iterate through the array to
    find an end index (m). The end index has the same/greater element
    value as the starting element.

    2. If an end index is found, calculate volume difference between
    starting (n) and end (m) indexes across the range (i.e. between
    n+1 and m-1).

    3. The end index (m) then becomes the next starting index (n) and
    the process is repeated.

    4. If an end index is not found, the next index in the array becomes
     the starting index.

     */


    // find the first index that has a value greater
    // than both its previous and next elements (this
    // will be the start of a dam).
    public int getStartIndex() {

        for (int i = 1; i < elevationMap.length - 1; i++) {

            if (elevationMap[i - 1] > elevationMap[i])
                return i - 1;

            if ((elevationMap[i - 1] <= elevationMap[i]) && (elevationMap[i] > elevationMap[i + 1]))
                return i;
        }

        return -1;
    }


    // find the next index that has a value greater
    // than its previous element. This index will
    // create a dam.
    public int getEndIndex(int startIndex) {

        int endIndex = -1;

        for (int i = startIndex; i < elevationMap.length - 1; i++) {

            if (elevationMap[i + 1] > elevationMap[i]) {
                endIndex = i + 1;
            }

            if (elevationMap[i + 1] >= elevationMap[startIndex]) {
                endIndex = i + 1;
                return endIndex;
            }
        }

        return endIndex;
    }

    // find the volume of water between the start and end index (this is a dam)
    public int getWaterVolumeBetweenIndexes(int startIndex, int endIndex) {

        int topValue = elevationMap[startIndex];
        int waterVolumeBetweenIndexes = 0;

        for (int i = startIndex + 1; i < endIndex; i++) {

            if (elevationMap[endIndex] < elevationMap[startIndex]) {
                waterVolumeBetweenIndexes += (elevationMap[endIndex] - elevationMap[i]);
            } else {
                waterVolumeBetweenIndexes += (topValue - elevationMap[i]);
            }
        }

        return waterVolumeBetweenIndexes;
    }


    public int getWaterVolumeInElevationMap(int startIndex) {

        int endIndex = getEndIndex(startIndex);
        int trappedWaterVolumeBetweenIndexes;

        if (endIndex != -1) {

            trappedWaterVolumeBetweenIndexes = getWaterVolumeBetweenIndexes(startIndex, endIndex);
            waterVolumeInElevationMap += trappedWaterVolumeBetweenIndexes;
            getWaterVolumeInElevationMap(endIndex);
        }

        return waterVolumeInElevationMap;
    }

}
