package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.BitSet;

@GwtIncompatible
final class SmallCharMatcher
  extends CharMatcher.NamedFastMatcher
{
  private static final int C1 = -862048943;
  private static final int C2 = 461845907;
  private static final double DESIRED_LOAD_FACTOR = 0.5D;
  static final int MAX_SIZE = 1023;
  private final boolean containsZero;
  private final long filter;
  private final char[] table;
  
  private SmallCharMatcher(char[] paramArrayOfChar, long paramLong, boolean paramBoolean, String paramString)
  {
    super(paramString);
    this.table = paramArrayOfChar;
    this.filter = paramLong;
    this.containsZero = paramBoolean;
  }
  
  private boolean checkFilter(int paramInt)
  {
    return 1L == (this.filter >> paramInt & 1L);
  }
  
  @VisibleForTesting
  static int chooseTableSize(int paramInt)
  {
    int j;
    if (paramInt == 1)
    {
      j = 2;
      return j;
    }
    int i = Integer.highestOneBit(paramInt - 1) << 1;
    for (;;)
    {
      j = i;
      if (i * 0.5D >= paramInt) {
        break;
      }
      i <<= 1;
    }
  }
  
  static CharMatcher from(BitSet paramBitSet, String paramString)
  {
    long l = 0L;
    int i = paramBitSet.cardinality();
    boolean bool = paramBitSet.get(0);
    char[] arrayOfChar = new char[chooseTableSize(i)];
    int k = arrayOfChar.length - 1;
    i = paramBitSet.nextSetBit(0);
    if (i != -1)
    {
      l |= 1L << i;
      for (int j = smear(i) & k;; j = j + 1 & k) {
        if (arrayOfChar[j] == 0)
        {
          arrayOfChar[j] = ((char)i);
          i = paramBitSet.nextSetBit(i + 1);
          break;
        }
      }
    }
    return new SmallCharMatcher(arrayOfChar, l, bool, paramString);
  }
  
  static int smear(int paramInt)
  {
    return 461845907 * Integer.rotateLeft(-862048943 * paramInt, 15);
  }
  
  public boolean matches(char paramChar)
  {
    if (paramChar == 0) {
      return this.containsZero;
    }
    if (!checkFilter(paramChar)) {
      return false;
    }
    int m = this.table.length - 1;
    int j = smear(paramChar) & m;
    int i = j;
    int k;
    do
    {
      if (this.table[i] == 0) {
        return false;
      }
      if (this.table[i] == paramChar) {
        return true;
      }
      k = i + 1 & m;
      i = k;
    } while (k != j);
    return false;
  }
  
  void setBits(BitSet paramBitSet)
  {
    int i = 0;
    if (this.containsZero) {
      paramBitSet.set(0);
    }
    char[] arrayOfChar = this.table;
    int j = arrayOfChar.length;
    while (i < j)
    {
      int k = arrayOfChar[i];
      if (k != 0) {
        paramBitSet.set(k);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.SmallCharMatcher
 * JD-Core Version:    0.7.0.1
 */