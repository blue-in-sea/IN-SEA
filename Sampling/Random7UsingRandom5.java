public class Random7UsingRandom5 {
    public int random7() {
        while (true) {
            // to generate a uniformly distributed 0-24 number
            int random = 5 * RandomFive.random5() + RandomFive.random5();
            // we only care about the first 21 numbers and should
            // ignore and try again for the numbers >= 21
            if (random < 7) {
                return random;
            }
        }
    }
}
