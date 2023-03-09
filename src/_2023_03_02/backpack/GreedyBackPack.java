package _2023_03_02.backpack;

import java.util.ArrayList;

public class GreedyBackPack {
    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9};
        int[] prices = {1, 6, 4, 7, 6};

        int maxWeight = 13;

        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int resultWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            indexes.add(i);
        }

        while (!indexes.isEmpty()) {
            int maxValue = prices[indexes.get(0)];
            int maxIndexes = indexes.get(0);

            for (int i = 1; i < indexes.size(); i++) {
                if (maxValue < prices[indexes.get(i)]) {
                    maxValue = prices[indexes.get(i)];
                    maxIndexes = indexes.get(i);
                }
            }

            resultWeight += weights[maxIndexes];
            if (resultWeight > maxWeight) {
                break;
            }

            result.add(maxIndexes);
            indexes.remove(maxIndexes);
        }

        System.out.print("Оптимальное содержимое: ");
        for (Integer integer : result) {
            System.out.print((integer + 1) + "::");
        }
    }
}