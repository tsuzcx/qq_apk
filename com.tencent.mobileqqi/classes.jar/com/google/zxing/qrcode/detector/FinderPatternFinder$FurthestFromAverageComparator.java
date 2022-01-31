package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

final class FinderPatternFinder$FurthestFromAverageComparator
  implements Serializable, Comparator
{
  private final float average;
  
  private FinderPatternFinder$FurthestFromAverageComparator(float paramFloat)
  {
    this.average = paramFloat;
  }
  
  public int compare(FinderPattern paramFinderPattern1, FinderPattern paramFinderPattern2)
  {
    float f1 = Math.abs(paramFinderPattern2.c() - this.average);
    float f2 = Math.abs(paramFinderPattern1.c() - this.average);
    if (f1 < f2) {
      return -1;
    }
    if (f1 == f2) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternFinder.FurthestFromAverageComparator
 * JD-Core Version:    0.7.0.1
 */