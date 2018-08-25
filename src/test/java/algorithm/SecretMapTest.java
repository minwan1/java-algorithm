package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

//kko1
public class SecretMapTest {

    @Test
    public void getSecretMapSolution() {
        final int[] firstStarMap = {9, 20, 28, 18, 11};
        final int[] secondStarMap = {30, 1, 21, 17, 28};

        final SecretMap secretMap = new SecretMap(firstStarMap, secondStarMap, 5);
        final String solution = secretMap.getSolutionMap().toString();
        assertThat(solution, is("[#####, # # #, ### #, #  ##, #####]"));

    }

    public class SecretMap {

        private final int[] firstStarMap;
        private final int[] secondStarMap;
        private final int mapSize;

        public SecretMap(final int[] firstStarMap, final int[] secondStarMap, final int mapSize) {
            this.firstStarMap = firstStarMap;
            this.secondStarMap = secondStarMap;
            this.mapSize = mapSize;
        }

        public List<String> getSolutionMap() {
            String[] result = new String[mapSize];
            for (int i = 0; i < mapSize; i++) {
                result[i] = Integer.toBinaryString(firstStarMap[i] | secondStarMap[i]);
                result[i] = result[i].replace("1", "#");
                result[i] = result[i].replace("0", " ");
            }

            return Arrays.asList(result);
        }

    }


}
