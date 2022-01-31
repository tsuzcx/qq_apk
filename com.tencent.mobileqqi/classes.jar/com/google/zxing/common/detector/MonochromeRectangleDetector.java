package com.google.zxing.common.detector;

import com.google.zxing.ReaderException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class MonochromeRectangleDetector
{
  private static final int jdField_a_of_type_Int = 32;
  private final BitMatrix jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  
  public MonochromeRectangleDetector(BitMatrix paramBitMatrix)
  {
    this.a = paramBitMatrix;
  }
  
  private ResultPoint a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    int j = paramInt1;
    int i = paramInt5;
    int[] arrayOfInt;
    for (Object localObject = null; (i < paramInt8) && (i >= paramInt7) && (j < paramInt4) && (j >= paramInt3); localObject = arrayOfInt)
    {
      if (paramInt2 == 0) {
        arrayOfInt = a(i, paramInt9, paramInt3, paramInt4, true);
      }
      while (arrayOfInt == null) {
        if (localObject == null)
        {
          throw ReaderException.getInstance();
          arrayOfInt = a(j, paramInt9, paramInt7, paramInt8, false);
        }
        else
        {
          float f1;
          if (paramInt2 == 0)
          {
            paramInt2 = i - paramInt6;
            if (localObject[0] < paramInt1)
            {
              if (localObject[1] > paramInt1)
              {
                if (paramInt6 > 0) {}
                for (f1 = localObject[0];; f1 = localObject[1]) {
                  return new ResultPoint(f1, paramInt2);
                }
              }
              return new ResultPoint(localObject[0], paramInt2);
            }
            return new ResultPoint(localObject[1], paramInt2);
          }
          paramInt1 = j - paramInt2;
          if (localObject[0] < paramInt5)
          {
            if (localObject[1] > paramInt5)
            {
              float f2 = paramInt1;
              if (paramInt2 < 0) {}
              for (f1 = localObject[0];; f1 = localObject[1]) {
                return new ResultPoint(f2, f1);
              }
            }
            return new ResultPoint(paramInt1, localObject[0]);
          }
          return new ResultPoint(paramInt1, localObject[1]);
        }
      }
      j += paramInt2;
      i += paramInt6;
    }
    throw ReaderException.getInstance();
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int j = paramInt3 + paramInt4 >> 1;
    int i = j;
    int k;
    label62:
    int m;
    if (i >= paramInt3)
    {
      if (paramBoolean)
      {
        if (!this.a.a(i, paramInt1)) {}
      }
      else {
        while (this.a.a(paramInt1, i))
        {
          i -= 1;
          break;
        }
      }
      k = i;
      do
      {
        m = k - 1;
        if (m < paramInt3) {
          break;
        }
        if (!paramBoolean) {
          break label150;
        }
        k = m;
      } while (!this.a.a(m, paramInt1));
      label96:
      if ((m >= paramInt3) && (i - m <= paramInt2)) {}
    }
    else
    {
      k = i + 1;
      paramInt3 = j;
    }
    for (;;)
    {
      label120:
      if (paramInt3 < paramInt4)
      {
        if (paramBoolean)
        {
          if (!this.a.a(paramInt3, paramInt1)) {}
        }
        else {
          while (this.a.a(paramInt1, paramInt3))
          {
            paramInt3 += 1;
            break label120;
            k = m;
            if (!this.a.a(paramInt1, m)) {
              break label62;
            }
            break label96;
            i = m;
            break;
          }
        }
        i = paramInt3;
        do
        {
          j = i + 1;
          if (j >= paramInt4) {
            break;
          }
          if (!paramBoolean) {
            break label265;
          }
          i = j;
        } while (!this.a.a(j, paramInt1));
      }
      for (;;)
      {
        label150:
        if ((j < paramInt4) && (j - paramInt3 <= paramInt2)) {
          break label285;
        }
        paramInt1 = paramInt3 - 1;
        if (paramInt1 <= k) {
          break label291;
        }
        return new int[] { k, paramInt1 };
        label265:
        i = j;
        if (!this.a.a(paramInt1, j)) {
          break;
        }
      }
      label285:
      paramInt3 = j;
    }
    label291:
    return null;
  }
  
  public ResultPoint[] a()
  {
    int i1 = this.a.b();
    int i2 = this.a.a();
    int i = i1 >> 1;
    int j = i2 >> 1;
    int k = Math.max(1, i1 / 256);
    int i3 = Math.max(1, i2 / 256);
    int m = (int)a(j, 0, 0, i2, i, -k, 0, i1, j >> 1).b() - 1;
    ResultPoint localResultPoint1 = a(j, -i3, 0, i2, i, 0, m, i1, i >> 1);
    int n = (int)localResultPoint1.a() - 1;
    ResultPoint localResultPoint2 = a(j, i3, n, i2, i, 0, m, i1, i >> 1);
    i2 = (int)localResultPoint2.a() + 1;
    ResultPoint localResultPoint3 = a(j, 0, n, i2, i, k, m, i1, j >> 1);
    i1 = (int)localResultPoint3.b();
    return new ResultPoint[] { a(j, 0, n, i2, i, -k, m, i1 + 1, j >> 2), localResultPoint1, localResultPoint2, localResultPoint3 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.detector.MonochromeRectangleDetector
 * JD-Core Version:    0.7.0.1
 */