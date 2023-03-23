package _2023_03_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class HAFF {
    public static void main(String[] args) {
        String text = """
                The 20-year-old man, who was already serving a national\s
                stadium ban and should not have been in the ground, was given a three-month prison sentence.
                He was also banned from the area around PSV's Philips Stadium for two years.
                The Dutch club also said it will look to recover financial damages from him.
                PSV can expect a heavy fine after Uefa opened a disciplinary case against them following the incident.
                The pitch invader, who PSV said entered the ground using a ticket bought by a friend, was already\s
                serving a national stadium ban until 2026 imposed by the Dutch football association.
                He approached Serb Dmitrovic near the end of the play-off second leg at the end of\s
                February and punched him in the face.\s
                The former Charlton goalkeeper wrestled the man to the ground and stewards led him away.
                Dmitrovic was able to continue as Sevilla lost 2-0 on the night, but went through 3-2 on aggregate.
                The Spanish six-time Europa League champions will play Manchester United in the quarter-finals.""";
        String milk = "moloko";

        //Считаем кол-во символов в тексте
        TreeMap<Character, Integer> freq = countFreq(milk);

        //Генерируем список листьев дерева
        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : freq.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, freq.get(c)));
        }

        //Строим кодовое дерево
        CodeTreeNode tree = huff(codeTreeNodes);

        //Генерируем мапу, где ключ это символ,
        //а значение строка ноликов и единичек
        TreeMap<Character, String> codes = new TreeMap<>();
        for (Character c : freq.keySet()) {
            //добавлять нолики и единички для нашего символа
            codes.put(c, tree.getCodeForCharacters(c, ""));
        }

        System.out.println("Таблица префиксных кодов: " + codes);

        //Кодируем текст
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < milk.length(); i++) {
            encoded.append(codes.get(milk.charAt(i)));
        }

        System.out.println("Размер исходной строки: " + milk.getBytes().length * 8 + " бит");
        System.out.println("Размер сжатой строки: " + encoded.length() + " бит");
        System.out.println("Биты сжатой строки: " + encoded);

        //Раскодируем
        String decoded = decode(encoded.toString(), tree);

        System.out.println("Раскодированная строка: " + decoded);
    }

    //1. Считать кол-во символов в нашем тексте
    private static TreeMap<Character, Integer> countFreq(String text) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
//            Character c = text.charAt(i);
//            Integer count = map.get(c);
//            map.put(c, count != null ? count + 1 : 1);
            map.merge(text.charAt(i), 1, Integer::sum);
        }
        return map;
    }

    //2. Класс для предоставления кодового дерева
    private static class CodeTreeNode implements Comparable<CodeTreeNode> {
        Character content; //хранить символ
        int weight; //кол-во повторений
        CodeTreeNode left;
        CodeTreeNode right;

        public CodeTreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(CodeTreeNode o) {
            return o.weight - weight;
        }

        //3.1 Обход дерева в глубину
        public String getCodeForCharacters(Character ch, String parentPath) {
            //Если мы нашли символ
            if (content == ch) {
                return parentPath;
            } else {
                if (left != null) {
                    String path = left.getCodeForCharacters(ch, parentPath + 0);
                    if (path != null) {
                        return path;
                    }
                }

                if (right != null) {
                    String path = right.getCodeForCharacters(ch, parentPath + 1);
                    if (path != null) {
                        return path;
                    }
                }
            }
            return null;
        }
    }

    //3.0 Возвращаем дерево и принимаем список узлов
    private static CodeTreeNode huff(ArrayList<CodeTreeNode> codeTreeNodes) {
        while (codeTreeNodes.size() > 1) {
            Collections.sort(codeTreeNodes);
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            CodeTreeNode parent = new CodeTreeNode(null, right.weight + left.weight, left, right);
            codeTreeNodes.add(parent);
        }
        return codeTreeNodes.get(0);
    }

    //4. Декодируем
    private static String decode(String encoded, CodeTreeNode tree) {
        StringBuilder decoded = new StringBuilder();

        CodeTreeNode root = tree;
        for (int i = 0; i < encoded.length(); i++) {
            root = encoded.charAt(i) == '0' ? root.left : root.right;
            if (root.content != null) {
                decoded.append(root.content);
                root = tree;
            }
        }
        return decoded.toString();
    }
}