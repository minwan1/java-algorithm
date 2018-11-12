package algorithm.arith;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
public class MiniMaxSum {

    @Test
    public void test() {
        int arr[] = {256741038, 623958417, 467905213, 714532089, 938071625};
        miniMaxSum(arr);
    }

    private void miniMaxSum(int[] arr) {
        long[] longArray = Arrays.stream(arr).asLongStream().toArray();
        Arrays.sort(longArray);
        long miniSum = longArray[0]+longArray[1]+longArray[2]+longArray[3];
        long maxSum = longArray[1]+longArray[2]+longArray[3]+longArray[4];
        System.out.println(miniSum+" "+maxSum);
    }
}
