import java.util.HashSet;
import java.util.Set;

public class VISA_OA4 {

    public int countIlluminatedCoordinates(int[][] lamps) {
        if (lamps.length == 0) {
            return 0;
        }

        int minCoord = Integer.MAX_VALUE;
        int maxCoord = Integer.MIN_VALUE;

        // Determine the range of coordinates
        for (int[] lamp : lamps) {
            int center = lamp[0];
            int radius = lamp[1];
            minCoord = Math.min(minCoord, center - radius);
            maxCoord = Math.max(maxCoord, center + radius);
        }

        int range = maxCoord - minCoord + 1;
        int[] illumination = new int[range];
        int offset = -minCoord;

        for (int[] lamp : lamps) {
            int center = lamp[0];
            int radius = lamp[1];
            int start = Math.max(minCoord, center - radius);
            int end = Math.min(maxCoord, center + radius);

            for (int i = start; i <= end; i++) {
                illumination[i - minCoord] = 1;
            }
        }

        int count = 0;
        for (int value : illumination) {
            if (value == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        VISA_OA4 solution = new VISA_OA4();
        int[][] lamps = {
            {-2, 3},
            {2, 3},
            {2, 1}
        };
        System.out.println(solution.countIlluminatedCoordinates(lamps)); // Expected Output: 11
    }
}
