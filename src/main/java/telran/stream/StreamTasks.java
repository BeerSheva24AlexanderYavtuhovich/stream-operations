package telran.stream;

import java.util.Arrays;

public class StreamTasks {

    public static int[] shuffle(int[] arr) {
        final int[] index = { 0 };
        return Arrays.stream(arr)
                .map(i -> {
                    int randInd = (int) (Math.random() * (arr.length - index[0]));
                    int temp = arr[randInd];
                    arr[randInd] = arr[arr.length - 1 - index[0]];
                    return arr[arr.length - 1 - index[0]++] = temp;
                })
                .toArray();
    }

}
