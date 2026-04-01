package com.sorting;

import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore;
    }
}

public class ClientRiskRanking {

    // Bubble Sort (Ascending riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort (DESC riskScore + accountBalance)
    public static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Print top N risky clients
    public static void printTopClients(Client[] arr, int topN) {
        System.out.println("Top " + topN + " highest risk clients:");
        for (int i = 0; i < Math.min(topN, arr.length); i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("A", 20, 1000),
                new Client("B", 50, 2000),
                new Client("C", 80, 500)
        };

        // Bubble Sort (Ascending)
        Client[] bubbleArr = Arrays.copyOf(clients, clients.length);
        bubbleSort(bubbleArr);
        System.out.println("Bubble Sort (Ascending): " + Arrays.toString(bubbleArr));

        // Insertion Sort (Descending)
        Client[] insertionArr = Arrays.copyOf(clients, clients.length);
        insertionSort(insertionArr);
        System.out.println("Insertion Sort (Descending): " + Arrays.toString(insertionArr));

        // Top 3 risky clients
        printTopClients(insertionArr, 3);
    }
}