package _2023_03_16;

import java.util.HashMap;
import java.util.Map;

public class SUBSTR {
    /**
     * Есть две стринги
     * String jewelery = "AuiP"; --> виды драгоценностей
     * String stones = "AUUuuiHNhfgkpPkjAAaakndsdl"; --> набор камней который
     * содержит простые камни и драгоценности
     * !!! Найти сколько и каких драгоценностей в наборе камней
     */

    /**
     * String[] sa = {"2,5", "1-3,8", "4", "5-9", "7,9-2"};
     * String[] newA = {"25", "1238", "4", "56789", "798765432"};
     * Преобразовать массив |sa| в массив |newA|
     */

    public static void main(String[] args) {
        String letters = "ASKJHFDGFGASBBABB";
        String text = "ABBA";

        Map<Character, Integer> lettersMAP = new HashMap<>();
        Map<Character, Integer> textMAP = new HashMap<>();

        for (int i = 0; i < letters.length(); i++) {
            lettersMAP.merge(letters.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < text.length(); i++) {
            textMAP.merge(text.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < textMAP.size(); i++) {
            int count = 0;
            lettersMAP.containsKey(text.charAt(i));
        }
    }
}
