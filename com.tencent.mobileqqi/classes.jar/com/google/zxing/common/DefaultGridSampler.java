package com.google.zxing.common;

import com.google.zxing.ReaderException;

public final class DefaultGridSampler
  extends GridSampler
{
  public BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
  {
    return a(paramBitMatrix, paramInt1, paramInt2, PerspectiveTransform.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16));
  }
  
  public BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw ReaderException.getInstance();
    }
    BitMatrix localBitMatrix = new BitMatrix(paramInt1, paramInt2);
    float[] arrayOfFloat = new float[paramInt1 << 1];
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      int j = arrayOfFloat.length;
      float f = paramInt1;
      int i = 0;
      while (i < j)
      {
        arrayOfFloat[i] = ((i >> 1) + 0.5F);
        arrayOfFloat[(i + 1)] = (f + 0.5F);
        i += 2;
      }
      paramPerspectiveTransform.a(arrayOfFloat);
      a(paramBitMatrix, arrayOfFloat);
      i = 0;
      while (i < j) {
        try
        {
          if (paramBitMatrix.a((int)arrayOfFloat[i], (int)arrayOfFloat[(i + 1)])) {
            localBitMatrix.a(i >> 1, paramInt1);
          }
          i += 2;
        }
        catch (ArrayIndexOutOfBoundsException paramBitMatrix)
        {
          throw ReaderException.getInstance();
        }
      }
      paramInt1 += 1;
    }
    return localBitMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.DefaultGridSampler
 * JD-Core Version:    0.7.0.1
 */