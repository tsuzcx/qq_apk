package com.tencent.token.ui.base;

import java.lang.reflect.Array;

public final class ca
{
  static ca[][] c = (ca[][])Array.newInstance(ca.class, new int[] { 3, 3 });
  int a;
  int b;
  
  static
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        c[i][j] = new ca(i, j);
        j += 1;
      }
      i += 1;
    }
  }
  
  private ca(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static ca a(int paramInt1, int paramInt2)
  {
    try
    {
      b(paramInt1, paramInt2);
      ca localca = c[paramInt1][paramInt2];
      return localca;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 2)) {
      throw new IllegalArgumentException("row must be in range 0-2");
    }
    if ((paramInt2 < 0) || (paramInt2 > 2)) {
      throw new IllegalArgumentException("column must be in range 0-2");
    }
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final String toString()
  {
    return "(row=" + this.a + ",clmn=" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ca
 * JD-Core Version:    0.7.0.1
 */