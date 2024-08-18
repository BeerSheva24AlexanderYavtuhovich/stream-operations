package telran.stream;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import static telran.stream.StreamTasks.shuffle;

public class StreamTasksTest {
    @Test
    void shuffleTest() {
        // setup
        int[] originalArray = new Random().ints(1, 50).distinct().limit(6).toArray();
        int[] shuffledArray1 = shuffle(originalArray);
        int[] shuffledArray2 = shuffle(originalArray);

        // length check
        assertEquals(originalArray.length, shuffledArray1.length);
        assertEquals(originalArray.length, shuffledArray2.length);
        assertEquals(shuffledArray1.length, shuffledArray2.length);

        // order check
        assertFalse(Arrays.equals(originalArray, shuffledArray1));
        assertFalse(Arrays.equals(shuffledArray1, shuffledArray2));
        assertFalse(Arrays.equals(originalArray, shuffledArray1));

        // theoretically possible (Reversibility)
        int[] reshuffled = shuffle(shuffledArray1);
        assertFalse(Arrays.equals(shuffledArray1, reshuffled));

        // and finally contains check
        Arrays.sort(originalArray);
        Arrays.sort(shuffledArray1);
        Arrays.sort(shuffledArray2);

        assertArrayEquals(originalArray, shuffledArray2);
        assertArrayEquals(shuffledArray1, shuffledArray2);
        assertArrayEquals(originalArray, shuffledArray1);
    }
}
