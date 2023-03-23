package _2023_03_23;

import java.util.ArrayList;
import java.util.Arrays;

public class KMP {
    private static ArrayList<Integer> naiveSearchTeamVersion(String source, String template) {
        ArrayList<Integer> foundPosition = new ArrayList<>();

        for (int i = 0; i < source.length() - template.length() + 1; i++) {
            if (source.startsWith(template, i)) {
                foundPosition.add(i);
            }
        }
        return foundPosition;
    }

    private static ArrayList<Integer> naiveSearchMyVersion(String source, String template) {
        ArrayList<Integer> foundPosition = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            int tempLatePosition = 0;
            while (tempLatePosition < template.length()
                    && (i + tempLatePosition) < source.length()
                    && template.charAt(tempLatePosition) == source.charAt(i + tempLatePosition)) {
                tempLatePosition++;
            }
            if (tempLatePosition == template.length()) {
                foundPosition.add(i);
            }
        }
        return foundPosition;
    }

    private static String getSourceAndTemplate(int n) {
        StringBuilder s = new StringBuilder();
        s.append("A".repeat(Math.max(0, n)));
        s.append("B");
        return s.toString();
    }

    private static int[] prefixFunction(String template) {
        //создаем массив для нашей функции
        int[] values = new int[template.length()];
        for (int i = 1; i < template.length(); i++) {
            int templatePosition = 0;
            //ищем саму себя
            while (i + templatePosition < template.length()
                    && template.charAt(templatePosition) == template.charAt(i + templatePosition)) {
                values[i + templatePosition] =
                        Math.max(values[i + templatePosition], templatePosition + 1);
                templatePosition++;
            }
        }
        return values;
    }

    private static ArrayList<Integer> knutMorisPratt(String source, String template) {
        //массив для найденных вхождений
        ArrayList<Integer> found = new ArrayList<>();

        //вычисляем префиксную функцию
        int[] prefix = prefixFunction(template);

        int sourcePosition = 0;
        int templatePosition = 0;

        while (sourcePosition < source.length()) {
            //если символ в образце совпадает с символом в тексте
            if (template.charAt(templatePosition) == source.charAt(sourcePosition)) {
                templatePosition++;
                sourcePosition++;
            }

            //если все символы совпали
            if (templatePosition == template.length()) {
                //в найденную позицию записываем первый символ
                found.add(sourcePosition - templatePosition);

                //берем из префиксной функции значение куда надо двигаться
                templatePosition = prefix[templatePosition - 1];

                //если символ образца не совпадает с символом текста
            } else if (sourcePosition < source.length()
                    && template.charAt(templatePosition) != source.charAt(sourcePosition)) {

                //а если это не первый символ нашего образца
                if (templatePosition != 0) {
                    templatePosition = prefix[templatePosition - 1];
                } else {
                    sourcePosition = sourcePosition + 1;
                }
            }
        }

        return found;
    }

    public static void main(String[] args) {
        String extraSource = getSourceAndTemplate(1_000_000);
        String extraTemplate = getSourceAndTemplate(330_00);

        String source = "AABAABAABAAAABBABBABBAABAAB";
        String template = "AABAAB";

        long tvt = System.currentTimeMillis();
        System.out.println(naiveSearchTeamVersion(extraSource, extraTemplate));
        System.out.println("Team Version Time: " + (System.currentTimeMillis() - tvt));

        long pref = System.currentTimeMillis();
        System.out.println(Arrays.toString(prefixFunction(extraTemplate)));
        System.out.println("Prefix Time: " + (System.currentTimeMillis() - pref));

//        long mvt = System.currentTimeMillis();
//        System.out.println(naiveSearchMyVersion(extraSource, extraTemplate));
//        System.out.println("My Version Time: " + (System.currentTimeMillis() - mvt));

        long kmpt = System.currentTimeMillis();
        System.out.println(knutMorisPratt(extraSource, extraTemplate));
        System.out.println("KMP Version Time: " + (System.currentTimeMillis() - kmpt));
    }
}