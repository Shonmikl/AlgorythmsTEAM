package _2023_03_09;

import java.util.function.Function;

public class CurrEx {
    public static int fun1() {
        return 10;
    }

    public static int fun2() {
        return 20;
    }

    public static int fun3() {
        return 30;
    }

    public static void main(String[] args) {
        Function<Integer, Function<Integer, Function<Integer, Integer>>>
                c = x -> y -> z -> 2 * x + 3 * y + 5 * z;
        System.out.println("Evaluating 2*x + 3*y + 5*z with x=10, y=20, z=30 : == " +
                c.apply(fun1()).apply(fun2()).apply(fun3()));
        //curring
    }
}