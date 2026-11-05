import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {

        int n = array.length;

        if (n == 0 || (direction != 'R' && direction != 'L')) {
            return array;
        }

        // Normalize the shift to the array length
        int shift = move % n;

        // Convert left shifts into right shifts
        if (direction == 'L') {
            shift = -shift;
        }

        // Ensure the shift is between 0 and n-1
        shift = (shift + n) % n;

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + shift) % n;
            temp[newIndex] = array[i];
        }

        // Copy the result back into the original array
        for (int i = 0; i < n; i++) {
            array[i] = temp[i];
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R')));
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R')));
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r')));
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g')));
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L')));
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L')));
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L')));
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R')));
    }
}
