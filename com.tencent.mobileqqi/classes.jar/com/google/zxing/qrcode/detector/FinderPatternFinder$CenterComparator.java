package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

final class FinderPatternFinder$CenterComparator
  implements Serializable, Comparator
{
  private final float average;
  
  private FinderPatternFinder$CenterComparator(float paramFloat)
  {
    this.average = paramFloat;
  }
  
  public int compare(FinderPattern paramFinderPattern1, FinderPattern paramFinderPattern2)
  {
    int i;
    int j;
    if (paramFinderPattern2.a() > 1)
    {
      i = 1;
      if (paramFinderPattern1.a() <= 1) {
        break label71;
      }
      j = 1;
    }
    for (;;)
    {
      if (i == j)
      {
        float f1 = Math.abs(paramFinderPattern2.c() - this.average);
        float f2 = Math.abs(paramFinderPattern1.c() - this.average);
        if (f1 < f2)
        {
          return 1;
          i = 0;
          break;
          label71:
          j = 0;
          continue;
        }
        if (f1 == f2) {
          return 0;
        }
        return -1;
      }
    }
    return paramFinderPattern2.a() - paramFinderPattern1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternFinder.CenterComparator
 * JD-Core Version:    0.7.0.1
 */