package algorithm;

import org.junit.Test;
import sun.misc.LRUCache;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CacheTest {

    @Test
    public void getRunningTime() {

        int t1 = getRunningTime(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        int t2 = getRunningTime(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});
        int t3 = getRunningTime(2, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
        int t4 = getRunningTime(5, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
        int t5 = getRunningTime(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"});
        int t6 = getRunningTime(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"});

        System.out.println(Arrays.asList(t1, t2, t3, t4, t5, t6));

        assertThat(t1, is(50));
        assertThat(t2, is(21));
        assertThat(t3, is(60));
        assertThat(t4, is(52));
        assertThat(t5, is(20));
        assertThat(t6, is(25));
    }


    private int getRunningTime(int cacheSize, String[] cities) {

        LRUCache cache = new LRUCache(cacheSize);
        for (String city : cities) {
            cache.get(city);
        }
        return cache.getHitCount() + (cache.getMissCount() * 5);
    }


    public class LRUCache{

        private final LinkedHashMap<String, String> map;
        private int hitCount;
        private int missCount;

        public LRUCache(int cacheSize) {
            this.map = new LinkedHashMap<String,String>(){
                @Override
                protected boolean removeEldestEntry(Map.Entry<String,String> eldest){
                    return size() == cacheSize+1;
                }
            };
        }

        public String get(String city){

            String value = map.get(city);

            if(value != null){
                hitCount++;
                value = map.put(city, city);
            }else{
                missCount++;
                map.put(city, city);
            }
            return value;
        }

        public int getHitCount() {
            return hitCount;
        }

        public int getMissCount() {
            return missCount;
        }
    }
}
