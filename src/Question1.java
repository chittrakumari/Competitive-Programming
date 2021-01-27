/*
Question 1 - Pairs
Problem: Consider an array of integers that may contain both positive and negative integers, called numbers.
 Write a program that finds all the pairs of integers whose sum is equal to a given value called desiredSum.

BONUS
1.Create a separate Pair class for this task.
2.Create a separate method for this task.
[Amazon, Adobe, Flipkart]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
class Pair<R extends Integer,S extends Integer>
{
    private R firstno;
    private R secondno;

    public Pair(R firstno, R secondno) {
        this.firstno = firstno;
        this.secondno = secondno;
    }

    @Override
    public String toString() {
        return "{"+
                "firstno=" + firstno +
                ", secondno=" + secondno +
                '}';
    }
}
class Question1 {
    // Please try not to change anything in this method.
    public static void main(String[] args) {
        int[] numbers = new int[15];
        addRandomNumbers(numbers);

        System.out.println(Arrays.toString(numbers));
        System.out.println("Pairs"+findPairs(numbers, 10));
    }

    // Please try not to change anything in this method.
    public static void addRandomNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt() % 10;
        }
    }

    // Try to complete this method.
    public static List<Pair<Integer,Integer>> findPairs(int[] numbers, int desiredSum) {
        System.out.println("before sort"+Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("after sort"+Arrays.toString(numbers));
        int firstpointer=0;
        int secondpointer= numbers.length-1;
        int sum=0;
        List<Pair<Integer,Integer>> pairs=new  ArrayList<>();
        while (firstpointer<secondpointer){
            sum=numbers[firstpointer]+numbers[secondpointer];
            if(sum==desiredSum){
                var pair=new Pair<>(numbers[firstpointer],numbers[secondpointer]);
                pairs.add(pair);
                firstpointer++;
                secondpointer--;
            }
            else if(sum<desiredSum){
                firstpointer++;
            }
            else{
                secondpointer--;
            }
        }
        return pairs;
    }

}