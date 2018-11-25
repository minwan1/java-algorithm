package algorithm;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * https://www.welcomekakao.com/learn/courses/30/lessons/12930
 *
 * 특이사항 : String split 함수는 그냥 자르면 뒤쪽의 빈공간이 있으면 trim을 하게됨. 이것에 트림되는것을 막기위해서는 -1을 해줘야함,
 */
public class StrangeString {

    @Test
    public void test() {

        String s = " try hello   world ";
        final String solution = solution(s);
        assertThat(solution, is(" TrY HeLlO   WoRlD "));

    }

    private String solution(String s) {
        s = s.toLowerCase();
        final String[] words = s.split(" ", -1);

        final String answer = Stream.of(words)
                .map(word -> {
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        if (i % 2 == 0) {
                            final char c = Character.toUpperCase(chars[i]);
                            chars[i] = c;
                        }
                    }
                    return String.valueOf(chars);
                })
                .collect(Collectors.joining(" "));
        return answer;
    }

}
