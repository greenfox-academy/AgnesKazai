//Write a Stream Expression to find the frequency of numbers in the following array:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise8 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2));
        Map<Integer, Long> freq =
                numbers.stream()
                        .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        System.out.println("Frequency of numbers: " + freq);

//        Map<Integer, Integer> map =
//                numbers.stream()
//                        .collect(Collectors.toMap(
//                                k -> k,
//                                v -> 1,
//                                Integer::sum));
//
//        System.out.println("Frequency of numbers: " + map);
    }
}