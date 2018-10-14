package algorithm;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class DayOfWeekTest {

    //입력값의 요일 구하기
    @Test
    public void getDayOfWeek() {

        //given
        final int month = 05;
        final int dayOfMonth = 24;

        //when
        final String displayName = getDayOfWeekSolution(month, dayOfMonth);

        //then
        assertThat("TUE", is(displayName));
    }

    private String getDayOfWeekSolution(int month, int dayOfMonth) {
        final LocalDate of = LocalDate.of(2016, month, dayOfMonth);
        final DayOfWeek dayOfWeek = of.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
    }

}
