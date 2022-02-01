package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
final class Hashing
{
  private static final int C1 = -862048943;
  private static final int C2 = 461845907;
  private static final int MAX_TABLE_SIZE = 1073741824;
  
  static int closedTableSize(int paramInt, double paramDouble)
  {
    int j = Math.max(paramInt, 2);
    int i = Integer.highestOneBit(j);
    paramInt = i;
    if (j > (int)(i * paramDouble))
    {
      paramInt = i << 1;
      if (paramInt <= 0) {}
    }
    else
    {
      return paramInt;
    }
    return 1073741824;
  }
  
  static boolean needsResizing(int paramInt1, int paramInt2, double paramDouble)
  {
    return (paramInt1 > paramInt2 * paramDouble) && (paramInt2 < 1073741824);
  }
  
  static int smear(int paramInt)
  {
    return 461845907 * Integer.rotateLeft(-862048943 * paramInt, 15);
  }
  
  static int smearedHash(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = 0;; i = paramObject.hashCode()) {
      return smear(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Hashing
 * JD-Core Version:    0.7.0.1
 */