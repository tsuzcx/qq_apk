package com.tencent.mobileqq.mini.zxing.common;

import com.tencent.mobileqq.mini.zxing.Binarizer;
import com.tencent.mobileqq.mini.zxing.LuminanceSource;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import java.lang.reflect.Array;

public final class HybridBinarizer
  extends GlobalHistogramBinarizer
{
  private static final int BLOCK_SIZE = 8;
  private static final int BLOCK_SIZE_MASK = 7;
  private static final int BLOCK_SIZE_POWER = 3;
  private static final int MINIMUM_DIMENSION = 40;
  private static final int MIN_DYNAMIC_RANGE = 24;
  private BitMatrix matrix;
  
  public HybridBinarizer(LuminanceSource paramLuminanceSource)
  {
    super(paramLuminanceSource);
  }
  
  private static int[][] calculateBlackPoints(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i6 = paramInt4 - 8;
    int i7 = paramInt3 - 8;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt2, paramInt1 });
    int i1 = 0;
    int i3;
    label68:
    int i;
    int n;
    int j;
    int k;
    int m;
    label122:
    int i4;
    if (i1 < paramInt2)
    {
      paramInt4 = i1 << 3;
      int i2 = paramInt4;
      if (paramInt4 > i6) {
        i2 = i6;
      }
      i3 = 0;
      if (i3 < paramInt1)
      {
        i = i3 << 3;
        paramInt4 = i;
        if (i > i7) {
          paramInt4 = i7;
        }
        n = 0;
        j = 255;
        i = 0;
        k = 0;
        m = i2 * paramInt3 + paramInt4;
        paramInt4 = n;
        if (k < 8)
        {
          n = 0;
          label132:
          if (n < 8)
          {
            i4 = paramArrayOfByte[(m + n)] & 0xFF;
            if (i4 >= j) {
              break label437;
            }
            j = i4;
          }
        }
      }
    }
    label431:
    label437:
    for (;;)
    {
      if (i4 > i) {
        i = i4;
      }
      for (;;)
      {
        n += 1;
        paramInt4 += i4;
        break label132;
        if (i - j > 24)
        {
          n = m + paramInt3;
          m = k + 1;
          k = n;
          for (;;)
          {
            i5 = k;
            i4 = m;
            n = paramInt4;
            if (m >= 8) {
              break;
            }
            n = 0;
            while (n < 8)
            {
              paramInt4 += (paramArrayOfByte[(k + n)] & 0xFF);
              n += 1;
            }
            m += 1;
            k += paramInt3;
          }
        }
        n = paramInt4;
        i4 = k;
        int i5 = m;
        m = i5 + paramInt3;
        paramInt4 = n;
        k = i4 + 1;
        break label122;
        paramInt4 >>= 6;
        if (i - j <= 24)
        {
          paramInt4 = j / 2;
          if ((i1 <= 0) || (i3 <= 0)) {
            break label431;
          }
          i = (arrayOfInt[(i1 - 1)][i3] + arrayOfInt[i1][(i3 - 1)] * 2 + arrayOfInt[(i1 - 1)][(i3 - 1)]) / 4;
          if (j >= i) {
            break label431;
          }
          paramInt4 = i;
        }
        for (;;)
        {
          arrayOfInt[i1][i3] = paramInt4;
          i3 += 1;
          break label68;
          i1 += 1;
          break;
          return arrayOfInt;
        }
      }
    }
  }
  
  private static void calculateThresholdForBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[][] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i1 = paramInt4 - 8;
    int i2 = paramInt3 - 8;
    paramInt4 = 0;
    while (paramInt4 < paramInt2)
    {
      int j = paramInt4 << 3;
      int i = j;
      if (j > i1) {
        i = i1;
      }
      int i3 = cap(paramInt4, 2, paramInt2 - 3);
      j = 0;
      while (j < paramInt1)
      {
        int m = j << 3;
        int k = m;
        if (m > i2) {
          k = i2;
        }
        int i4 = cap(j, 2, paramInt1 - 3);
        int n = 0;
        m = -2;
        while (m <= 2)
        {
          int[] arrayOfInt = paramArrayOfInt[(i3 + m)];
          int i5 = arrayOfInt[(i4 - 2)];
          int i6 = arrayOfInt[(i4 - 1)];
          int i7 = arrayOfInt[i4];
          int i8 = arrayOfInt[(i4 + 1)];
          n += arrayOfInt[(i4 + 2)] + (i5 + i6 + i7 + i8);
          m += 1;
        }
        thresholdBlock(paramArrayOfByte, k, i, n / 25, paramInt3, paramBitMatrix);
        j += 1;
      }
      paramInt4 += 1;
    }
  }
  
  private static int cap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  private static void thresholdBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitMatrix paramBitMatrix)
  {
    int i = paramInt2 * paramInt4 + paramInt1;
    int j = 0;
    while (j < 8)
    {
      int k = 0;
      while (k < 8)
      {
        if ((paramArrayOfByte[(i + k)] & 0xFF) <= paramInt3) {
          paramBitMatrix.set(paramInt1 + k, paramInt2 + j);
        }
        k += 1;
      }
      j += 1;
      i += paramInt4;
    }
  }
  
  public Binarizer createBinarizer(LuminanceSource paramLuminanceSource)
  {
    return new HybridBinarizer(paramLuminanceSource);
  }
  
  public BitMatrix getBlackMatrix()
    throws NotFoundException
  {
    if (this.matrix != null) {
      return this.matrix;
    }
    Object localObject = getLuminanceSource();
    int m = ((LuminanceSource)localObject).getWidth();
    int n = ((LuminanceSource)localObject).getHeight();
    BitMatrix localBitMatrix;
    if ((m >= 40) && (n >= 40))
    {
      localObject = ((LuminanceSource)localObject).getMatrix();
      int j = m >> 3;
      int i = j;
      if ((m & 0x7) != 0) {
        i = j + 1;
      }
      int k = n >> 3;
      j = k;
      if ((n & 0x7) != 0) {
        j = k + 1;
      }
      int[][] arrayOfInt = calculateBlackPoints((byte[])localObject, i, j, m, n);
      localBitMatrix = new BitMatrix(m, n);
      calculateThresholdForBlock((byte[])localObject, i, j, m, n, arrayOfInt, localBitMatrix);
    }
    for (this.matrix = localBitMatrix;; this.matrix = super.getBlackMatrix()) {
      return this.matrix;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.common.HybridBinarizer
 * JD-Core Version:    0.7.0.1
 */