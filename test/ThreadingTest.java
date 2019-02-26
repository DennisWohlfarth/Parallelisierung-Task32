import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadingTest {
    @Test
    void test()
    {
        //Numbers from https://www.primepuzzles.net/puzzles/puzz_240.htm
        Threading thread = new Threading(1);
        assertTrue(thread.isConsecutivePrime(384)&& thread.isConsecutivePrime(385));
        assertTrue(thread.isConsecutivePrime(539)&& thread.isConsecutivePrime(540));
        assertTrue(thread.isConsecutivePrime(2430)&& thread.isConsecutivePrime(2431));
        assertTrue(thread.isConsecutivePrime(4199)&& thread.isConsecutivePrime(4200));

    }


}