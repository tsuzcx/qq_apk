package com.tencent.token.ui.base;

import java.lang.reflect.Array;

public class bt
{
  static bt[][] c = (bt[][])Array.newInstance(bt.class, new int[] { 3, 3 });
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
        c[i][j] = new bt(i, j);
        j += 1;
      }
      i += 1;
    }
  }
  
  private bt(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static bt a(int paramInt1, int paramInt2)
  {
    try
    {
      b(paramInt1, paramInt2);
      bt localbt = c[paramInt1][paramInt2];
      return localbt;
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
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "(row=" + this.a + ",clmn=" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bt
 * JD-Core Version:    0.7.0.1
 */