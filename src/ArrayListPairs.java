import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArrayListPairs {
    static class Pair<R extends Integer, S extends Integer> {
        private R firstno;
        private S secondno;

        public Pair(R firstno, S secondno) {
            this.firstno = firstno;
            this.secondno = secondno;
        }

        @Override
        public String toString() {
            return firstno + "," + secondno + " ";
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add((int) (Math.random() * (i + 4)));

        }
        System.out.println(numbers);
        Collections.sort(numbers);
        List<Pair<Integer, Integer>> pairslist = new ArrayList<>();
//        HashMap<Integer, Integer> pairslist = new HashMap<>();
        int firstpointer = 0;
        int secondpointer = numbers.size() - 1;
        int sum = 0;
        while (firstpointer < secondpointer) {
            sum = numbers.get(firstpointer) + numbers.get(secondpointer);
            if (sum == 6) {
                 var pair = new Pair<>(
                         numbers.get(firstpointer), numbers.get(secondpointer)
                 );
                 pairslist.add(pair);
//                pairslist.put(numbers.get(firstpointer), numbers.get(secondpointer));
                firstpointer++;
                secondpointer--;
            } else if (sum < 6) {
                firstpointer++;
            } else {
                secondpointer--;
            }
        }
        System.out.println("size of pairlist " + pairslist.size());
        System.out.println("pairs " + pairslist);


    }
}