package com.examples.challenges.solution1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TrappedWaterTest {

    @Test
    public void check_that_START_index_is_0() {
        int[] elevationMap = {1, 0, 1, 2, 1};
        int startIndex = getStartIndex(elevationMap);
        assertThat(startIndex, is(0));
    }

    @Test
    public void check_that_START_index_is_1() {
        int[] elevationMap = {0, 1, 0, 2, 1};
        int startIndex = getStartIndex(elevationMap);
        assertThat(startIndex, is(1));
    }

    @Test
    public void check_that_START_index_is_2() {
        int[] elevationMap = {0, 1, 2, 1};
        int startIndex = getStartIndex(elevationMap);
        assertThat(startIndex, is(2));
    }

    @Test
    public void check_that_START_index_is_2_for_adjacent_numbers() {
        int[] elevationMap = {2, 2, 0, 1};
        int startIndex = getStartIndex(elevationMap);
        assertThat(startIndex, is(1));
    }

    @Test
    public void check_that_START_index_is_3() {
        int[] elevationMap = {0, 0, 0, 1, 0};
        int startIndex = getStartIndex(elevationMap);
        assertThat(startIndex, is(3));
    }

    @Test
    public void check_that_START_index_for_adjacent_numbers_is_3() {
        int[] elevationMap = {0, 0, 1, 1, 0};
        int startIndex = getStartIndex(elevationMap);
        assertThat(startIndex, is(3));
    }

    @Test
    public void check_that_END_index_is_2() {
        int[] elevationMap = {2, 1, 2};
        int endIndex = getEndIndex(elevationMap);
        assertThat(endIndex, is(2));
    }

    @Test
    public void check_that_END_index_is_3() {
        int[] elevationMap = {0, 1, 0, 2, 1};
        int endIndex = getEndIndex(elevationMap);
        assertThat(endIndex, is(3));
    }

    @Test
    public void check_that_END_index_is_4() {
        int[] elevationMap = {1, 2, 1, 0, 1, 1, 1};
        int endIndex = getEndIndex(elevationMap);
        assertThat(endIndex, is(4));
    }

    @Test
    public void check_that_END_index_is_4b() {
        int[] elevationMap = {1, 3, 2, 1, 2, 1};
        int endIndex = getEndIndex(elevationMap);
        assertThat(endIndex, is(4));
    }

    @Test
    public void check_that_END_index_is_5() {
        int[] elevationMap = {1, 2, 1, 1, 0, 2, 1};
        int endIndex = getEndIndex(elevationMap);
        assertThat(endIndex, is(5));
    }

    @Test
    public void check_that_END_index_for_adjacent_numbers_is_8() {
        int[] elevationMap = {0, 2, 2, 1, 1, 0, 0, 1, 2, 2, 0};
        int endIndex = getEndIndex(elevationMap);
        assertThat(endIndex, is(8));
    }

    @Test
    public void check_that_WATER_VOLUME_in_single_dam_is_1a() {
        int[] elevationMap = {0, 1, 0, 2};
        int indexVolume = getIndexVolume(elevationMap);
        assertThat(indexVolume, is(1));
    }

    @Test
    public void check_that_WATER_VOLUME_in_single_dam_is_1b() {
        int[] elevationMap = {0, 2, 0, 1};
        int indexVolume = getIndexVolume(elevationMap);
        assertThat(indexVolume, is(1));
    }

    @Test
    public void check_that_WATER_VOLUME_in_single_dam_is_1c() {
        int[] elevationMap = {1, 3, 2, 1, 2, 1};
        int indexVolume = getIndexVolume(elevationMap);
        assertThat(indexVolume, is(1));
    }

    @Test
    public void check_that_WATER_VOLUME_in_single_dam_is_2() {
        int[] elevationMap = {0, 2, 0, 2};
        int indexVolume = getIndexVolume(elevationMap);
        assertThat(indexVolume, is(2));
    }

    @Test
    public void check_that_WATER_VOLUME_in_single_dam_is_3() {
        int[] elevationMap = {0, 1, 2, 1, 1, 1, 2, 0};
        int indexVolume = getIndexVolume(elevationMap);
        assertThat(indexVolume, is(3));
    }

    @Test
    public void check_that_WATER_VOLUME_in_single_dam_is_4() {
        int[] elevationMap = {0, 2, 1, 0, 1, 3};
        int indexVolume = getIndexVolume(elevationMap);
        assertThat(indexVolume, is(4));
    }

    @Test
    public void check_that_WATER_VOLUME_in_single_dam_is_12() {
        int[] elevationMap = {4, 2, 2, 1, 0, 3, 4};
        int indexVolume = getIndexVolume(elevationMap);
        assertThat(indexVolume, is(12));
    }

    @Test
    public void check_that_WATER_VOLUME_in_double_dam_is_2() {
        int[] elevationMap = {0, 0, 1, 0, 1, 0, 1};
        int totalWaterVolume = getTotalWaterVolume(elevationMap);
        assertThat(totalWaterVolume, is(2));
    }

    @Test
    public void check_that_WATER_VOLUME_in_double_dam_is_3() {
        int[] elevationMap = {0, 0, 2, 0, 2, 0, 1};
        int totalWaterVolume = getTotalWaterVolume(elevationMap);
        assertThat(totalWaterVolume, is(3));
    }

    @Test
    public void check_that_WATER_VOLUME_in_double_dam_is_4() {
        int[] elevationMap = {2, 0, 2, 0, 2 ,1 ,0};
        int totalWaterVolume = getTotalWaterVolume(elevationMap);
        assertThat(totalWaterVolume, is(4));
    }

    @Test
    public void check_that_WATER_VOLUME_in_triple_dam_is_6() {
        int[] elevationMap = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int totalWaterVolume = getTotalWaterVolume(elevationMap);
        assertThat(totalWaterVolume, is(6));
    }

    @Test
    public void check_that_WATER_VOLUME_in_quadruple_dam_is_9() {
        int[] elevationMap = {0, 2, 0, 2, 3, 0, 1, 3, 0, 1, 0, 1};
        int totalWaterVolume = getTotalWaterVolume(elevationMap);
        assertThat(totalWaterVolume, is(9));
    }


    // helper method to retrieve water volume in elevation map
    private int getTotalWaterVolume(int[] elevationMap) {
        TrappedWater trappedWater = new TrappedWater(elevationMap);
        int startIndex = trappedWater.getStartIndex();
        return trappedWater.getWaterVolumeInElevationMap(startIndex);
    }

    // helper method to retrieve start index
    private int getStartIndex(int[] elevationMap) {
        TrappedWater trappedWater = new TrappedWater(elevationMap);
        return trappedWater.getStartIndex();
    }

    // helper method to get end index
    private int getEndIndex(int[] elevationMap) {
        TrappedWater trappedWater = new TrappedWater(elevationMap);
        int startIndex = trappedWater.getStartIndex();
        return trappedWater.getEndIndex(startIndex);
    }

    // helper method to get water volume between start and end indexes
    private int getIndexVolume(int[] elevationMap) {
        TrappedWater trappedWater = new TrappedWater(elevationMap);
        int startIndex = trappedWater.getStartIndex();
        int endIndex = trappedWater.getEndIndex(startIndex);
        return trappedWater.getWaterVolumeBetweenIndexes(startIndex, endIndex);
    }


}