package algorithm.hashmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * 양말 짝 맞추기
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */
public class SockMerchant {

    @Test
    public void answer() {

        //given
        //when
        final int answer = sockMerchant(9,
                new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20});
        //then
        assertThat(answer, is(3));

    }

    private static int sockMerchant(int n, int[] ar) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int key : ar){
            if(hashMap.containsKey(key)){
                hashMap.put(key, hashMap.get(key) + 1);
            }else{
                hashMap.put(key, 1);
            }
        }

        final int sum = hashMap.values()
                .stream()
                .mapToInt(value -> value / 2)
                .sum();
        return sum;
    }
}
