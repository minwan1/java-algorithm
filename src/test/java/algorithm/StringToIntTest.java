package algorithm;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * String to int
 */
public class StringToIntTest {

    @Test
    public void test() {
        //given
        final String problem = "456";

        //when
        int answer = StringToInt(problem);

        //then
        assertThat(456, is(answer));
    }

    private int StringToInt(String problem) {
        final char[] chars = problem.toCharArray();
        int answer = 0;
        for(char value : chars){
            answer = answer * 10;
            answer +=(value-'0');
        }
        return answer;
    }
}
