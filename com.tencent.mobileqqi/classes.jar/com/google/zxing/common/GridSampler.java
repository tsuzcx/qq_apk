package com.google.zxing.common;

import com.google.zxing.ReaderException;

public abstract class GridSampler
{
  private static GridSampler a = new DefaultGridSampler();
  
  public static GridSampler a()
  {
    return a;
  }
  
  protected static void a(BitMatrix paramBitMatrix, float[] paramArrayOfFloat)
  {
    int k = paramBitMatrix.a();
    int m = paramBitMatrix.b();
    int j = 0;
    int i = 1;
    int n;
    if ((j < paramArrayOfFloat.length) && (i != 0))
    {
      i = (int)paramArrayOfFloat[j];
      n = (int)paramArrayOfFloat[(j + 1)];
      if ((i < -1) || (i > k) || (n < -1) || (n > m)) {
        throw ReaderException.getInstance();
      }
      if (i == -1)
      {
        paramArrayOfFloat[j] = 0.0F;
        i = 1;
      }
    }
    for (;;)
    {
      label78:
      if (n == -1)
      {
        paramArrayOfFloat[(j + 1)] = 0.0F;
        i = 1;
      }
      for (;;)
      {
        j += 2;
        break;
        if (i != k) {
          break label275;
        }
        paramArrayOfFloat[j] = (k - 1);
        i = 1;
        break label78;
        if (n == m)
        {
          paramArrayOfFloat[(j + 1)] = (m - 1);
          i = 1;
        }
      }
      j = paramArrayOfFloat.length - 2;
      i = 1;
      if ((j >= 0) && (i != 0))
      {
        i = (int)paramArrayOfFloat[j];
        n = (int)paramArrayOfFloat[(j + 1)];
        if ((i < -1) || (i > k) || (n < -1) || (n > m)) {
          throw ReaderException.getInstance();
        }
        if (i == -1)
        {
          paramArrayOfFloat[j] = 0.0F;
          i = 1;
        }
      }
      for (;;)
      {
        label207:
        if (n == -1)
        {
          paramArrayOfFloat[(j + 1)] = 0.0F;
          i = 1;
        }
        for (;;)
        {
          j -= 2;
          break;
          if (i != k) {
            break label270;
          }
          paramArrayOfFloat[j] = (k - 1);
          i = 1;
          break label207;
          if (n == m)
          {
            paramArrayOfFloat[(j + 1)] = (m - 1);
            i = 1;
          }
        }
        return;
        label270:
        i = 0;
      }
      label275:
      i = 0;
    }
  }
  
  public static void a(GridSampler paramGridSampler)
  {
    a = paramGridSampler;
  }
  
  public abstract BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16);
  
  public abstract BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.GridSampler
 * JD-Core Version:    0.7.0.1
 */