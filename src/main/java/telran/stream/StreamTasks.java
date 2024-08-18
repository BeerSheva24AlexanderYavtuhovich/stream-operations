package telran.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamTasks {

    public static int[] shuffle(int[] arr) {
        return Arrays.stream(getShuffledIndexes(arr))
                .map(i -> arr[i])
                .toArray();
    }

    private static int[] getShuffledIndexes(int[] arr) {
        Random random = new Random();
        int[] res = IntStream.range(0, arr.length).toArray();

        for (int i = res.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int tmp = res[i];
            res[i] = res[j];
            res[j] = tmp;
        }
        return res;
    }
}
