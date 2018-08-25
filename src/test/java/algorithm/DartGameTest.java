package algorithm;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//kko2
public class DartGameTest {

    @Test
    public void calculateDartGameScores() {

        final DartGameCalculator dartGameCalculator1 = new DartGameCalculator("1S2D*3T");
        final DartGameCalculator dartGameCalculator2 = new DartGameCalculator("1D2S#10S");
        final DartGameCalculator dartGameCalculator3 = new DartGameCalculator("1D2S0T");
        final DartGameCalculator dartGameCalculator4 = new DartGameCalculator("1D#2S*3S");
        final DartGameCalculator dartGameCalculator5 = new DartGameCalculator("1T2D3D#");
        final DartGameCalculator dartGameCalculator6 = new DartGameCalculator("1D2S3T*");

        final int score1 = dartGameCalculator1.getScore();
        final int score2 = dartGameCalculator2.getScore();
        final int score3 = dartGameCalculator3.getScore();
        final int score4 = dartGameCalculator4.getScore();
        final int score5 = dartGameCalculator5.getScore();
        final int score6 = dartGameCalculator6.getScore();

        assertThat(score1, is(37));
        assertThat(score2, is(9));
        assertThat(score3, is(3));
        assertThat(score4, is(5));
        assertThat(score5, is(-4));
        assertThat(score6, is(59));

     }

    public class DartGameCalculator {

        private final String dartResult;

        public DartGameCalculator(final String dartResult) {
            this.dartResult = dartResult;
        }

        public int getScore(){

            final char[] chars = dartResult.toCharArray();
            Stack<Integer> scores = new Stack<>();

            for (int i = 0; i < chars.length; i++) {
                switch (chars[i]) {
                    case 'S':
                        scores.add((int) Math.pow(scores.pop(), 1));
                        break;
                    case 'D':
                        scores.add((int) Math.pow(scores.pop(), 2));
                        break;
                    case 'T':
                        scores.add((int) Math.pow(scores.pop(), 3));
                        break;
                    case '*':
                        int temp = scores.pop() * 2;
                        if (scores.size() != 0) temp += scores.pop() * 2;
                        scores.add(temp);
                        break;
                    case '#':
                        scores.add(scores.pop() * -1);
                        break;
                    case '0':
                        if (scores.peek() == 1) {
                            scores.pop();
                            scores.add(10);
                        } else {
                            scores.add(0);
                        }

                        break;
                    default:
                        final String str = String.valueOf(chars[i]);
                        final Integer c = Integer.valueOf(str);
                        scores.add(c);
                        break;
                }
            }

            final int scoreSum = sumScores(scores);
            return scoreSum;

        }

        private int sumScores(final Stack<Integer> scores) {
            int scoreSum = 0;
            while (!scores.empty()) {
                scoreSum += scores.pop();
            }
            return scoreSum;
        }

    }
}
