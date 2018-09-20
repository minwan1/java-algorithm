package algorithm;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12948?language=java
 */
public class MobileNumberFormatTest {

    @Test
    public void test() {
        //given
        final String mobile = "01033334444";

        //when
        final String mobileAsterisk = formatMobileAsterisk(mobile);

        //then
        assertThat("*******4444", is(mobileAsterisk));
    }

    private String formatMobileAsterisk(String mobile) {
        final char[] chars = mobile.toCharArray();

        for(int i = 0; i < chars.length - 4; i++){
            chars[i] = '*';
        }
        return String.valueOf(chars);
    }
}
