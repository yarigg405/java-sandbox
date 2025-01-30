package HomeworkStartup;

import java.util.ArrayList;
import java.util.HashSet;

public class Homework {

    //Перевернуть строку и вывести на консоль
    public static void turnString(String string) {
        var reflectedArray = new char[string.length()];

        for (int i = 0; i < reflectedArray.length; i++) {
            reflectedArray[i] = string.charAt(string.length() - i - 1);
        }

        System.out.println(reflectedArray);
    }

    //Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] arr) {
        var hashSet = new HashSet<Integer>();
        var resultList = new ArrayList<Integer>();

        for (int i : arr) {
            if (hashSet.contains(i)) continue;

            hashSet.add(i);
            resultList.add(i);
        }

        System.out.println(resultList);
    }

    //Необходимо найти элемент, который меньше максимума, но больше всех остальных
    public static Integer findSecondMaxElement(int[] arr) {
        Integer max = Integer.MIN_VALUE;
        Integer secondMax = Integer.MIN_VALUE;

        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        for (int i : arr) {
            if (i > max) {
                secondMax = max;
                max = i;
                continue;
            }

            if (i > secondMax && i < max) {
                secondMax = i;
            }
        }
        return secondMax;
    }

    //Найти длину последнего слова в строке.
    public static Integer lengthOfLastWord(String string) {
        String[] words = string.split("\\s+");
        if (words.length == 0) return 0;

        var lastString = words[words.length - 1];
        return lastString.length();
    }

    //Определить, что строка является палиндромом
    public static boolean isPalindrome(String string) {
        var size = string.length();
        if (size == 0) return false;

        for (int i = 0; i < size / 2 + 1; i++) {
            if (string.charAt(i) != string.charAt(size - 1 - i))
                return false;
        }

        return true;
    }
}



