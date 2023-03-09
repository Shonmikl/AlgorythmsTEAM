package _2023_03_02.backpack;

import java.util.ArrayList;

public class Dynamic {
    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9};
        int[] prices = {1, 6, 4, 7, 6};

        int maxWeight = 17;
        int count = weights.length;

        //массив оптимальных стоимостей
        int[][] A;

        //в первом индексе кол-во предметов
        //во втором размер
        //значение - это максимальная стоимость набора для
        //соответствующего набора и объема рюкзака
        A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[maxWeight + 1];
        }

        //k - это набор предметов(размер)
        for (int k = 0; k <= count; k++) {
            //s - это размер рюкзака
            for (int s = 0; s <= maxWeight; s++) {
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    //если размер рюкзака больше или равен
                    //размеру текущего предмета
                    if (s >= weights[k - 1]) {
                        A[k][s] = Math.max(A[k - 1][s], A[k - 1][s - weights[k - 1]] + prices[k - 1]);
                    } else {
                        //если предмет в рюкзак не влезает
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        traceResult(A, weights, count, maxWeight, result);

        System.out.print("Оптимальное содержимое: ");
        for (Integer integer : result) {
            System.out.print(integer + "::");
        }
    }

    private static void traceResult(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        //если стоимость A[k][s] = 0
        if (A[k][s] == 0) {
            return;
        }

        //если стоимость k == стоимость k-1,
        //то k- предмет не участвует
        if (A[k - 1][s] == A[k][s]) {
            //просто уменьшаем набор на 1
            traceResult(A, weight, k - 1, s, result);
        } else {
            traceResult(A, weight, k - 1, s - weight[k - 1], result);
            result.add(k);
        }
    }
}