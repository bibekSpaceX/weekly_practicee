package com.sorting.problem4;

import java.util.*;

class Asset {
    String name;
    double returnRate;

    Asset(String name, double returnRate) {
        this.name = name;
        this.returnRate = returnRate;
    }

    public String toString() {
        return name + ":" + returnRate;
    }
}

public class PortfolioSorting {

    public static void main(String[] args) {
        List<Asset> list = Arrays.asList(
                new Asset("AAPL", 12),
                new Asset("TSLA", 8),
                new Asset("GOOG", 15)
        );

        // Merge Sort using comparator
        list.sort(Comparator.comparingDouble(a -> a.returnRate));
        System.out.println("Merge (asc): " + list);

        // Quick Sort (desc)
        list.sort((a, b) -> Double.compare(b.returnRate, a.returnRate));
        System.out.println("Quick (desc): " + list);
    }
}