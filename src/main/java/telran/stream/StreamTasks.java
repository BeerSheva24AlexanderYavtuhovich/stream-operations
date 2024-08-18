package telran.stream;

import java.util.stream.IntStream;

public class StreamTasks {
/*
// Create a stream of indices
// Pair indices with random 
// Sort by random to shuffle indexes
// Map shuffled indexes back to array values
 // Collect to array
*/
    public static int[] shuffle(int[] arr) {
        return  IntStream.range(0, arr.length)  
                .mapToObj(i -> new int[] {i, (int)(Math.random() * 1000)})  
                .sorted((a, b) -> Integer.compare(a[1], b[1]))  
                .mapToInt(a -> arr[a[0]])  
                .toArray();
}
    
}
