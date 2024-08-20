package telran.stream;

import java.util.Random;

public class StreamTasks {

    public static int[] shuffle(int[] arr) {
        return new Random().ints(0, arr.length).distinct().limit(arr.length)
                .map(i -> arr[i]).toArray();
    }

}
