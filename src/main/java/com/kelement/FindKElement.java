package com.kelement;

import java.util.Arrays;

public class FindKElement {
    public int select(Integer[] values, int k) {
        return this.select(values, 0, values.length, k);
    }

    /**
     * This is an implementation of the Quickselect algorithm
     * @param values array containing the values
     * @param lower lower limit
     * @param upper upper limit
     * @param k k-th smallest element to be returned
     * @return returns the k-th smallest element of the array (without ordering)
     */
    private int select(Integer[] values, int lower, int upper, int k) {
        if (k >= 0 && k < upper) {
            int pivotIndex = pivot(values, lower, upper);
            pivotIndex = partition(values, lower, upper - 1, pivotIndex);

            if (pivotIndex == k) {
                return values[pivotIndex];
            } else if (pivotIndex > k) {
                return select(values, lower, pivotIndex, k);
            }
            return select(values, pivotIndex + 1,
                    upper, k);
        }
        return 0;
    }

    /**
     * This is an implementation of the Median-Of-Medians algorithm
     * @param values array containing the values
     * @param lower lower limit
     * @param upper upper limit
     * @return the value of the pivot
     */
    private int pivot(Integer[] values, int lower, int upper) {
        Integer[] medians = new Integer[(int) Math.ceil((upper - lower) / 5.0)];
        int pos = 0;
        for (int i = lower; i < upper; i = i + 5) {
            medians[pos] = getMedian(Arrays.copyOfRange(values, i, i + 5 <= upper ? i + 5 : upper));
            pos++;
        }
        if (medians.length == 1)
            return medians[0];
        return select(medians, 0, medians.length, medians.length / 2);
    }

    /**
     * Calculates the median for each subarray (composed of 5 elements at most)
     * @param values array containing the values
     * @return the value of the median
     */
    private int getMedian(Integer values[]) {
        Arrays.sort(values);
        return values[values.length / 2];
    }

    /**
     * Swap 2 elements inside the array
     * @param values array containing the values
     * @param indexA index of the first element
     * @param indexB index of the second element
     */
    private void swap(Integer[] values, int indexA, int indexB) {
        if (values[indexA] == values[indexB]) {
            return;
        }
        int temp = values[indexA];
        values[indexA] = values[indexB];
        values[indexB] = temp;
    }

    /**
     * Group the array (ranging from indices left to right) into three parts:
     * those less than the pivot, those equal to it, and those greater than the pivot.
     * @param values array containing the values
     * @param lower lower limit
     * @param upper upper limit
     * @param pivotValue pivot value :)
     * @return the index of the pivot
     */
    private int partition(Integer[] values, int lower, int upper, int pivotValue) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == pivotValue) {
                swap(values, i, upper);
                break;
            }
        }
        int index = lower;
        int i = index;
        while (i < upper) {
            if (values[i] < pivotValue) {
                swap(values, i, index);
                index++;
            }
            i++;
        }

        swap(values, index, upper);
        return index;
    }
}
