package com.google.zxing.common.detector;

import com.google.zxing.ReaderException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector
{
  private static final int jdField_a_of_type_Int = 30;
  private static final int b = 1;
  private final BitMatrix jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  
  public WhiteRectangleDetector(BitMatrix paramBitMatrix)
  {
    this.a = paramBitMatrix;
    this.c = paramBitMatrix.b();
    this.d = paramBitMatrix.a();
    this.e = (this.d - 30 >> 1);
    this.f = (this.d + 30 >> 1);
    this.h = (this.c - 30 >> 1);
    this.g = (this.c + 30 >> 1);
    if ((this.h < 0) || (this.e < 0) || (this.g >= this.c) || (this.f >= this.d)) {
      throw ReaderException.getInstance();
    }
  }
  
  public WhiteRectangleDetector(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramBitMatrix;
    this.c = paramBitMatrix.b();
    this.d = paramBitMatrix.a();
    paramInt1 >>= 1;
    this.e = (paramInt2 - paramInt1);
    this.f = (paramInt2 + paramInt1);
    this.h = (paramInt3 - paramInt1);
    this.g = (paramInt1 + paramInt3);
    if ((this.h < 0) || (this.e < 0) || (this.g >= this.c) || (this.f >= this.d)) {
      throw ReaderException.getInstance();
    }
  }
  
  private ResultPoint a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = MathUtils.a(MathUtils.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    paramFloat3 = (paramFloat3 - paramFloat1) / j;
    paramFloat4 = (paramFloat4 - paramFloat2) / j;
    int i = 0;
    while (i < j)
    {
      int k = MathUtils.a(i * paramFloat3 + paramFloat1);
      int m = MathUtils.a(i * paramFloat4 + paramFloat2);
      if (this.a.a(k, m)) {
        return new ResultPoint(k, m);
      }
      i += 1;
    }
    return null;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramInt1;
    if (paramBoolean) {
      while (paramInt1 <= paramInt2)
      {
        if (this.a.a(paramInt1, paramInt3)) {
          return true;
        }
        paramInt1 += 1;
      }
    }
    do
    {
      i += 1;
      if (i > paramInt2) {
        break;
      }
    } while (!this.a.a(paramInt3, i));
    return true;
    return false;
  }
  
  private ResultPoint[] a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4)
  {
    float f1 = paramResultPoint1.a();
    float f2 = paramResultPoint1.b();
    float f3 = paramResultPoint2.a();
    float f4 = paramResultPoint2.b();
    float f5 = paramResultPoint3.a();
    float f6 = paramResultPoint3.b();
    float f7 = paramResultPoint4.a();
    float f8 = paramResultPoint4.b();
    if (f1 < this.d / 2.0F) {
      return new ResultPoint[] { new ResultPoint(f7 - 1.0F, f8 + 1.0F), new ResultPoint(f3 + 1.0F, f4 + 1.0F), new ResultPoint(f5 - 1.0F, f6 - 1.0F), new ResultPoint(f1 + 1.0F, f2 - 1.0F) };
    }
    return new ResultPoint[] { new ResultPoint(f7 + 1.0F, f8 + 1.0F), new ResultPoint(f3 + 1.0F, f4 - 1.0F), new ResultPoint(f5 - 1.0F, f6 + 1.0F), new ResultPoint(f1 - 1.0F, f2 - 1.0F) };
  }
  
  public ResultPoint[] a()
  {
    int i8 = 0;
    int i7 = 1;
    int k = this.e;
    int i3 = this.f;
    int i = this.h;
    int i1 = this.g;
    int i5 = 0;
    int i6 = 1;
    int i9;
    int m;
    int j;
    boolean bool;
    int n;
    if (i6 != 0)
    {
      i9 = 1;
      m = 0;
      j = i3;
      while ((i9 != 0) && (j < this.d))
      {
        bool = a(i, i1, j, false);
        i9 = bool;
        if (bool)
        {
          j += 1;
          m = 1;
          i9 = bool;
        }
      }
      if (j >= this.d)
      {
        m = 1;
        n = j;
        j = k;
        k = i;
        i = i1;
      }
    }
    for (;;)
    {
      label116:
      ResultPoint localResultPoint1;
      if ((m == 0) && (i5 != 0))
      {
        i1 = n - j;
        m = 1;
        localResultPoint1 = null;
        label138:
        if (m >= i1) {
          break label712;
        }
        localResultPoint1 = a(j, i - m, j + m, i);
        if (localResultPoint1 == null) {}
      }
      label712:
      for (ResultPoint localResultPoint2 = localResultPoint1;; localResultPoint2 = localResultPoint1)
      {
        if (localResultPoint2 == null)
        {
          throw ReaderException.getInstance();
          i9 = 1;
          n = m;
          m = i1;
          while ((i9 != 0) && (m < this.c))
          {
            bool = a(k, j, m, true);
            i9 = bool;
            if (bool)
            {
              m += 1;
              n = 1;
              i9 = bool;
            }
          }
          if (m >= this.c)
          {
            i2 = 1;
            n = j;
            i1 = m;
            j = k;
            k = i;
            m = i2;
            i = i1;
            break label116;
          }
          i9 = 1;
          i1 = n;
          n = k;
          while ((i9 != 0) && (n >= 0))
          {
            bool = a(i, m, n, false);
            i9 = bool;
            if (bool)
            {
              n -= 1;
              i1 = 1;
              i9 = bool;
            }
          }
          if (n < 0)
          {
            i2 = 1;
            i1 = j;
            k = m;
            j = n;
            n = i;
            m = i2;
            i = k;
            k = n;
            n = i1;
            break label116;
          }
          i9 = 1;
          int i4 = i1;
          int i2 = i;
          while ((i9 != 0) && (i2 >= 0))
          {
            bool = a(n, j, i2, true);
            i9 = bool;
            if (bool)
            {
              i2 -= 1;
              i4 = 1;
              i9 = bool;
            }
          }
          if (i2 < 0)
          {
            i3 = 1;
            i1 = j;
            i = m;
            j = n;
            k = i2;
            m = i3;
            n = i1;
            break label116;
          }
          i1 = m;
          i = i2;
          i3 = j;
          k = n;
          i6 = i4;
          if (i4 == 0) {
            break;
          }
          i5 = 1;
          i1 = m;
          i = i2;
          i3 = j;
          k = n;
          i6 = i4;
          break;
          m += 1;
          break label138;
        }
        m = 1;
        localResultPoint1 = null;
        if (m < i1)
        {
          localResultPoint1 = a(j, k + m, j + m, k);
          if (localResultPoint1 == null) {}
        }
        for (ResultPoint localResultPoint3 = localResultPoint1;; localResultPoint3 = localResultPoint1)
        {
          if (localResultPoint3 == null)
          {
            throw ReaderException.getInstance();
            m += 1;
            break;
          }
          j = 1;
          localResultPoint1 = null;
          if (j < i1)
          {
            localResultPoint1 = a(n, k + j, n - j, k);
            if (localResultPoint1 == null) {}
          }
          for (ResultPoint localResultPoint4 = localResultPoint1;; localResultPoint4 = localResultPoint1)
          {
            if (localResultPoint4 == null)
            {
              throw ReaderException.getInstance();
              j += 1;
              break;
            }
            localResultPoint1 = null;
            j = i7;
            for (;;)
            {
              if (j < i1)
              {
                localResultPoint1 = a(n, i - j, n - j, i);
                if (localResultPoint1 == null) {}
              }
              else
              {
                if (localResultPoint1 != null) {
                  break;
                }
                throw ReaderException.getInstance();
              }
              j += 1;
            }
            return a(localResultPoint1, localResultPoint2, localResultPoint4, localResultPoint3);
            throw ReaderException.getInstance();
          }
        }
      }
      n = i3;
      j = k;
      k = i;
      m = i8;
      i = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.detector.WhiteRectangleDetector
 * JD-Core Version:    0.7.0.1
 */