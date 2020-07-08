public class Random1000UsingRandom5 {
  public int random1000() {
    while (true) {
      // the following 4 lines of code is usually used to 
      // compute ax^k + ... + bx^3 + cx^2 + dx^1 + ex^0
      int num = 0;
      for (int i = 0; i < 5; i++) {
        // 5 进制转换
        num = num * 5 + RandomFive.random5();
      }
      // choose 3000 instead of 1000 to reduce # of expected random5() calls
      if (num < 3000) {
        return num % 1000;
      }
    }
  }
}
