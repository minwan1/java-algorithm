package algorithm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 *
 * 1~N(짝수) 더하기
 * ex) 1~10 이면 1+10, 2+9 .... 이것의 갯수를 구하면 10/2 의 덧셋이 나온다
 * 그럼이 덧셈의 갯수와 10/2의 값을 곱하면 답인 55가 나온다.
 */
public class OneHundred {


    @Test
    public void test() {
        //given
        int N = 100;
        //when
        int result = getSolution(N);
        //then
        assertThat(result, is(5050));

    }

    private int getSolution(int N) {
        return (1 + N) * (N / 2);
    }
}
