import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {

  public static void main(String[] args) {

    System.err.println(args);

    ArrayList<Integer> arr = Arrays.stream(args)
    .map(Integer::parseInt)
    .collect(Collectors.toCollection(ArrayList::new));
   
    for (int i = 0; i < arr.size() - 1; ++i) {

        for (int j = 0; j < arr.size() - i - 1; ++j) {

            if (arr.get(j) > arr.get(j + 1)) {

                int temp = arr.get(j);
                arr.set(j, arr.get(j + 1));
                arr.set(j + 1, temp);
            }
        }
    }

        System.out.println(arr);
    }
}
