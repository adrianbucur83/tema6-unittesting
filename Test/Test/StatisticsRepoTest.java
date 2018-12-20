package Test;

import com.siit.adi.*;

import static org.junit.Assert.*;

import org.junit.Test;


public class StatisticsRepoTest {

    @Test
    public void whenMethodIsInvokedThenMapSizeIncreases() {

        StatisticsRepo stats = new StatisticsRepo();

        stats.measureRunTimeCompute();

        assertEquals(1, stats.runTimes.size());

    }

    ;
}
