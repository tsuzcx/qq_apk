package com.tencent.mobileqq.dinifly;

import android.util.Pair;
import java.util.Comparator;

class PerformanceTracker$1
  implements Comparator<Pair<String, Float>>
{
  PerformanceTracker$1(PerformanceTracker paramPerformanceTracker) {}
  
  public int compare(Pair<String, Float> paramPair1, Pair<String, Float> paramPair2)
  {
    float f1 = ((Float)paramPair1.second).floatValue();
    float f2 = ((Float)paramPair2.second).floatValue();
    if (f2 > f1) {
      return 1;
    }
    if (f1 > f2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.PerformanceTracker.1
 * JD-Core Version:    0.7.0.1
 */