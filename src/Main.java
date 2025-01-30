import HomeworkStartup.Homework;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Homework.turnString("I love Java");

        var testInt = new int[]{6, 7, 8, 8, 8, 8};
        Homework.getDistinctNumbers(testInt);
        System.out.println("////////////////////////////\n");

        System.out.println(Homework.findSecondMaxElement(testInt));
        System.out.println("////////////////////////////\n");

        System.out.println(Homework.lengthOfLastWord("I   Love   C# and   Java   "));
        System.out.println("////////////////////////////\n");

        var palindromeTestString = "112111";
        if (Homework.isPalindrome(palindromeTestString)) {
            System.out.println(palindromeTestString + " is palindrome");
        }
        else {
            System.out.println(palindromeTestString + " is NOT palindrome");
        }
    }
}