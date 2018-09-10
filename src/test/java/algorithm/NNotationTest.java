package algorithm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

// N진수
public class NNotationTest {

    @Test
    public void nNotationTest() throws Exception {

        String result1 = getString(2, 4, 2, 2);
        String result2 = getString(16, 16, 2, 1);
        String result3 = getString(16, 16, 2, 2);

        assertThat(result1, is("1010"));
        assertThat(result2, is("02468ACE11111111"));
        assertThat(result3, is("13579BDF01234567"));

    }

    private String getString(int numberType, int printCount, int personCount,  int order) throws Exception {
        String result = "";
        int value = 0;
        int currentOrder = 1;
        int myOrder = order;

        for(int i = 0; i<printCount*personCount*2; i++){
            String s = Integer.toString(value, numberType);

            for(int j = 0; j < s.length(); j++){ // 16진수로 변경한 string 길이.

                if(result.length() == printCount) return result.toUpperCase();

                if(currentOrder == myOrder) {
                    result = result + s.charAt(j);
                    myOrder = myOrder + personCount ;
                }
                currentOrder++;
            }
            value++;
        }
        throw new Exception("Unexpected Exception");
    }

}

//
//    입력 형식
//    진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.
//
//        2 ≦ n ≦ 16
//        0 ＜ t ≦ 1000
//        2 ≦ m ≦ 100
//        1 ≦ p ≦ m
//        출력 형식
//        튜브가 말해야 하는 숫자 t개를 공백 없이 차례대로 나타낸 문자열. 단, 10~15는 각각 대문자 A~F로 출력한다.
//
//        입출력 예제
//        n	t	m	p	result
//        2	4	2	1	0111
//        16	16	2	1	02468ACE11111111
//        16	16	2	2	13579BDF01234567