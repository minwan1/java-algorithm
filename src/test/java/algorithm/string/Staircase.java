package algorithm.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/staircase/problem
 * 별찍기
 */
public class Staircase {

    @Test
    public void test() {
        int n = 6;
        solution(n);
    }
    private void solution(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(n-i-1 <= j){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
