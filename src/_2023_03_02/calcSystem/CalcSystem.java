package _2023_03_02.calcSystem;

import java.util.ArrayList;
import java.util.List;

//TODO НАПИСАТЬ ПРОГРАММУ КОТОРАЯ ПЕРЕВОДИТ ИЗ АРАБСКИХ ЦИФР В РИМСКИЕ
public class CalcSystem {
    private static List<Character> getDigitalTable() {
        ArrayList<Character> digits = new ArrayList<>();
        for (char i = '0'; i <= '9'; i++) {
            digits.add(i);
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            digits.add(i);
        }
        return digits;
    }

    public static String getIntRadix(int number, int radix) throws IllegalAccessException {
        List<Character> digits = getDigitalTable();

        //Проверяем на нормальность
        if (radix < 2 || radix >= digits.size() || number < 0) {
            System.out.println("Incorrect arguments");
        }

        //Используем для создания строки
        StringBuilder valueStr = new StringBuilder();

        while (number > 0) {
            valueStr.insert(0, digits.get(number % radix));
            number /= radix; //number = number / radix
        }
        return valueStr.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(getIntRadix(255, 16));
    }
}