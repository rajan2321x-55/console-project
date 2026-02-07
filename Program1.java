package Array;

public class Program1 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4}; // Sample Input
        int sum = 0;

        // The "for-each" loop: "For every 'num' in 'arr'..."
        for (int num : arr) {
            sum += num;
        }

        System.out.println(sum);

	}

}
