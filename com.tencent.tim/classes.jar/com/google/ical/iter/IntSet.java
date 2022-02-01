package com.google.ical.iter;

import java.util.BitSet;

final class IntSet
{
  BitSet ints = new BitSet();
  
  private static void reverse(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      paramInt2 -= 1;
      if (paramInt1 >= paramInt2) {
        break;
      }
      int i = paramArrayOfInt[paramInt1];
      paramArrayOfInt[paramInt1] = paramArrayOfInt[paramInt2];
      paramArrayOfInt[paramInt2] = i;
      paramInt1 += 1;
    }
  }
  
  void add(int paramInt)
  {
    this.ints.set(encode(paramInt));
  }
  
  boolean contains(int paramInt)
  {
    return this.ints.get(encode(paramInt));
  }
  
  int decode(int paramInt)
  {
    return (paramInt >>> 1) * (-(paramInt & 0x1) | 0x1);
  }
  
  int encode(int paramInt)
  {
    if (paramInt < 0) {
      return (-paramInt << 1) + 1;
    }
    return paramInt << 1;
  }
  
  int size()
  {
    return this.ints.cardinality();
  }
  
  int[] toIntArray()
  {
    int[] arrayOfInt = new int[this.ints.cardinality()];
    int j = arrayOfInt.length;
    int k = -1;
    int i = 0;
    for (;;)
    {
      k = this.ints.nextSetBit(k + 1);
      if (k < 0) {
        break;
      }
      int m = decode(k);
      if (m < 0)
      {
        arrayOfInt[i] = m;
        i += 1;
      }
      else
      {
        j -= 1;
        arrayOfInt[j] = m;
      }
    }
    reverse(arrayOfInt, 0, i);
    reverse(arrayOfInt, i, arrayOfInt.length);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.IntSet
 * JD-Core Version:    0.7.0.1
 */