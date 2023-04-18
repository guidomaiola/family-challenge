package com.github.markboydcode.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Calculates for any four digit number the number of iterations it takes to arrive at Kaprekar's constant of 6174 by
 * the following steps:
 *
 * 1) Take any four digit number (whose digits are not all identical).
 * 2) Rearrange the string of digits to form the largest and smallest 4-digit numbers possible.
 * 3) Take these two numbers and subtract the smaller number from the larger.
 * 4) Use the number you obtain and repeat the above process until you arrive at Kaprekar's constant of 6174.
 * 5) Return the count of the number of iterations it took to arrive at the constant.
 *
 * @author boydmr
 */
public class KaprekarsConstant {
  static final String TOO_LOW = "the value is less than or equal to zero";
  static final String TOO_HIGH = "the value is greater than 9999";
  static final String NO_VARIANCE = "the value contains digits that are all identical";

  private static final int THE_CONSTANT = 6174;

  /**
   *
   * @param fourDigitNumber the number to be tested
   * @return the number of iterations to arrive at Kaprekar's constant.
   * @throws IllegalArgumentException with one of three messages: "the value is greater than 9999",
   *  "the value is less than or equal to zero", or "the value contains digits that are all identical".
   */
  public int calculateIterations(int fourDigitNumber) {
    if (fourDigitNumber <= 0) {
      throw new IllegalArgumentException(TOO_LOW);
    } else if (fourDigitNumber > 9999) {
      throw new IllegalArgumentException(TOO_HIGH);
    }

    int counter = 0;
    int newFourDigitNumber = fourDigitNumber;
    int smaller = 0;
    int largest = 0;
    while (THE_CONSTANT != newFourDigitNumber) {
      smaller = rearrangeToGetSmallerNumber(newFourDigitNumber);
      largest = rearrangeToGetLargestNumber(newFourDigitNumber);
      newFourDigitNumber = largest - smaller;
      counter++;
    }
    return counter;
  }

  private int rearrangeToGetSmallerNumber(int originalFourDigitNumber) {
    Integer[] digits = new Integer[4];
    for (int i = 0; i < 4; i++) {
      digits[i] = originalFourDigitNumber % 10;
      originalFourDigitNumber /= 10;
    }
    // SORT ASC
    List<Integer> ascendingList = Arrays.asList(digits);
    Collections.sort(ascendingList, Collections.reverseOrder());
    int shortest = 0;
    for (int i = 3; i >= 0; i--) {
      shortest = shortest * 10 + digits[i];
    }
    return shortest;
  }

  private  int rearrangeToGetLargestNumber(int originalFourDigitNumber) {
    int[] digits = new int[4];
    for (int i = 0; i < 4; i++) {
      digits[i] = originalFourDigitNumber % 10;
      originalFourDigitNumber /= 10;
    }
    // Sorting descendant
    Arrays.sort(digits);
    int largest = 0;
    for (int i = 3; i >= 0; i--) {
      largest = largest * 10 + digits[i];
    }
    return largest;
  }
}
