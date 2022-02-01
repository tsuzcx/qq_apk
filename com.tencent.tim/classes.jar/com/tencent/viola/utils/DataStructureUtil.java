package com.tencent.viola.utils;

import java.util.HashMap;

public class DataStructureUtil
{
  private static final int MAX_POWER_OF_TWO = 1073741824;
  
  private static int capacity(int paramInt)
  {
    if (paramInt < 3)
    {
      checkNonnegative(paramInt, "expectedSize");
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return (int)(paramInt / 0.75F + 1.0F);
    }
    return 2147483647;
  }
  
  private static int checkNonnegative(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException(paramString + " cannot be negative but was: " + paramInt);
    }
    return paramInt;
  }
  
  public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int paramInt)
  {
    return new HashMap(capacity(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.utils.DataStructureUtil
 * JD-Core Version:    0.7.0.1
 */