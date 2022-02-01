package com.tencent.token;

import java.lang.reflect.Array;

final class gs
{
  private static int a(int paramInt)
  {
    if (paramInt <= 4) {
      return 8;
    }
    return paramInt * 2;
  }
  
  public static int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if ((!a) && (paramInt1 > paramArrayOfInt.length)) {
      throw new AssertionError();
    }
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 + 1 > paramArrayOfInt.length)
    {
      arrayOfInt = new int[a(paramInt1)];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt1);
    }
    arrayOfInt[paramInt1] = paramInt2;
    return arrayOfInt;
  }
  
  public static <T> T[] a(T[] paramArrayOfT, int paramInt, T paramT)
  {
    if ((!a) && (paramInt > paramArrayOfT.length)) {
      throw new AssertionError();
    }
    Object localObject = paramArrayOfT;
    if (paramInt + 1 > paramArrayOfT.length)
    {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), a(paramInt));
      System.arraycopy(paramArrayOfT, 0, localObject, 0, paramInt);
    }
    localObject[paramInt] = paramT;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gs
 * JD-Core Version:    0.7.0.1
 */