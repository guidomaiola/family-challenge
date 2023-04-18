package com.github.markboydcode.questions;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Tests the implementation. You can use:
 *
 * http://www.mathsnut.net/topics/calculators/kaprekar.html
 *
 * to generate the sequence for any number to define more tests if desired. Warning: this site does not correctly
 * implement the algorithm for starting numbers smaller than four digits such as 0001.
 *
 * @author boydmr
 */
public class KaprekarsConstantTest {

  private KaprekarsConstant sut = new KaprekarsConstant();

  @Test
  public void test_minus_1() {
    try {
      sut.calculateIterations(-1);
      fail();
    } catch(IllegalArgumentException e) {
      assertEquals(e.getMessage(), KaprekarsConstant.TOO_LOW);
    }
  }

  @Test
  public void test_0() {
    try {
      sut.calculateIterations(0);
      fail();
    } catch(IllegalArgumentException e) {
      assertEquals(e.getMessage(), KaprekarsConstant.TOO_LOW);
    }
  }

  @Test
  public void test_10000() {
    try {
      sut.calculateIterations(10000);
      fail();
    } catch(IllegalArgumentException e) {
      assertEquals(e.getMessage(), KaprekarsConstant.TOO_HIGH);
    }
  }

  /**
   * Sequence from the site above is as follows for 3456 and should return 3:
   * <pre>
   *   6543 - 3456 = 3087
   *   8730 - 378 = 8352
   *   8532 - 2358 = 6174
   * </pre>
   */
  @Test
  public void test_3456() {
    assertEquals(sut.calculateIterations(3456), 3, "Wrong number of iterations.");
  }

  /**
   * Sequence from the site above is as follows for 1004 and should return 7:
   * <pre>
   *  4100 - 14 = 4086
   *  8640 - 468 = 8172
   *  8721 - 1278 = 7443
   *  7443 - 3447 = 3996
   *  9963 - 3699 = 6264
   *  6642 - 2466 = 4176
   *  7641 - 1467 = 6174
   * </pre>
   */
  @Test
  public void test_1004() {
    assertEquals(sut.calculateIterations(1004), 7, "Wrong number of iterations.");
  }

  @Test
  public void test_5455() {
    assertEquals(sut.calculateIterations(5455), 5, "Wrong number of iterations.");
  }

}
