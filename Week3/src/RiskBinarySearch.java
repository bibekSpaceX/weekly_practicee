package com.sorting.problem6;

import java.util.*;

public class RiskBinarySearch {

    public static void findFloorCeil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer floor = null, ceil = null;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Floor: " + floor);
        System.out.println("Ceiling: " + ceil);
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};

        findFloorCeil(arr, 30);
    }
}
