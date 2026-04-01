package com.sorting.problem3;

import java.util.*;

class Trade {
    int id;
    int volume;

    Trade(int id, int volume) {
        this.id = id;
        this.volume = volume;
    }

    public String toString() {
        return id + ":" + volume;
    }
}

public class TradeVolumeAnalysis {

    // Merge Sort
    public static void mergeSort(List<Trade> list) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;
        List<Trade> left = new ArrayList<>(list.subList(0, mid));
        List<Trade> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    private static void merge(List<Trade> list, List<Trade> left, List<Trade> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).volume <= right.get(j).volume) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }

    // Quick Sort (DESC)
    public static void quickSort(List<Trade> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private static int partition(List<Trade> list, int low, int high) {
        int pivot = list.get(high).volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).volume > pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    public static void main(String[] args) {
        List<Trade> trades = Arrays.asList(
                new Trade(3, 500),
                new Trade(1, 100),
                new Trade(2, 300)
        );

        List<Trade> mergeList = new ArrayList<>(trades);
        mergeSort(mergeList);
        System.out.println("MergeSort: " + mergeList);

        List<Trade> quickList = new ArrayList<>(trades);
        quickSort(quickList, 0, quickList.size() - 1);
        System.out.println("QuickSort DESC: " + quickList);

        int total = trades.stream().mapToInt(t -> t.volume).sum();
        System.out.println("Total Volume: " + total);
    }
}