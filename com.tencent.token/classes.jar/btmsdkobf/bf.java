package btmsdkobf;

import java.lang.reflect.Array;
import java.security.SecureRandom;

public class bf
{
  private int fG;
  private long fH;
  private long fI;
  
  bf(boolean paramBoolean)
  {
    Object localObject = new SecureRandom();
    do
    {
      i = ((SecureRandom)localObject).nextInt(900) + 101;
    } while (g(i));
    this.fG = i;
    int i1 = this.fG;
    localObject = new int[100];
    double d = Math.sqrt(i1);
    for (int i = (int)d - 1;; i = j)
    {
      j = i + 1;
      if (j * j > i1) {
        break;
      }
    }
    localObject[0] = i;
    if (i * i == i1) {
      return;
    }
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[1] = 1;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = (-localObject[0]);
    arrayOfInt1[4] = 1;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 100, 5 });
    int k = 1;
    i = 0;
    int j = 0;
    while (k < 100)
    {
      if (arrayOfInt1[1] < 0)
      {
        arrayOfInt1[1] = (-arrayOfInt1[1]);
        arrayOfInt1[2] = (-arrayOfInt1[2]);
        arrayOfInt1[3] = (-arrayOfInt1[3]);
        arrayOfInt1[4] = (-arrayOfInt1[4]);
      }
      i = c(c(c(arrayOfInt1[1], Math.abs(arrayOfInt1[2])), Math.abs(arrayOfInt1[3])), Math.abs(arrayOfInt1[4]));
      if (i > 1)
      {
        arrayOfInt1[1] /= i;
        arrayOfInt1[2] /= i;
        arrayOfInt1[3] /= i;
        arrayOfInt1[4] /= i;
      }
      i = 0;
      while (i < j)
      {
        int[] arrayOfInt2 = arrayOfInt[i];
        if ((arrayOfInt2[1] == arrayOfInt1[1]) && (arrayOfInt2[2] == arrayOfInt1[2]) && (arrayOfInt2[3] == arrayOfInt1[3]) && (arrayOfInt2[4] == arrayOfInt1[4])) {
          break;
        }
        i += 1;
      }
      if (i < j) {
        break;
      }
      arrayOfInt[j][1] = arrayOfInt1[1];
      arrayOfInt[j][2] = arrayOfInt1[2];
      arrayOfInt[j][3] = arrayOfInt1[3];
      arrayOfInt[j][4] = arrayOfInt1[4];
      j += 1;
      localObject[k] = ((int)Math.floor(a(d, arrayOfInt1)));
      a(i1, arrayOfInt1, localObject[k]);
      k += 1;
    }
    int i2 = k - 1;
    int m = 1;
    long l2 = 1L;
    long l1 = 0L;
    for (j = 0;; j = k)
    {
      if ((l1 >= 200L) && (j != 0))
      {
        a(l1, l2);
        return;
      }
      int n = m + 1;
      k = n - 1;
      l2 = 1L;
      l1 = 0L;
      while (k >= 0)
      {
        if (n <= i2) {
          m = localObject[k];
        } else {
          m = localObject[((k - i) % i2 + i)];
        }
        l4 = m;
        k -= 1;
        l3 = l1;
        l1 = l2 + l4 * l1;
        l2 = l3;
      }
      if (l1 >= 1000000L) {
        break;
      }
      long l3 = l1 * l1;
      long l4 = i1 * (l2 * l2);
      long l5 = 1000L * l3;
      k = j;
      if (l1 >= 200L)
      {
        k = j;
        if (999L * l4 < l5)
        {
          k = j;
          if (l5 < 1001L * l4)
          {
            k = j;
            if (j == 0) {
              if ((!paramBoolean) || (l3 >= l4))
              {
                k = j;
                if (!paramBoolean)
                {
                  k = j;
                  if (l3 <= l4) {}
                }
              }
              else
              {
                k = 1;
              }
            }
          }
        }
      }
      m = n;
    }
    throw new RuntimeException();
  }
  
  private static final double a(double paramDouble, int[] paramArrayOfInt)
  {
    double d1 = paramArrayOfInt[1];
    double d2 = paramArrayOfInt[2];
    Double.isNaN(d2);
    Double.isNaN(d1);
    double d3 = paramArrayOfInt[3];
    double d4 = paramArrayOfInt[4];
    Double.isNaN(d4);
    Double.isNaN(d3);
    return (d1 + d2 * paramDouble) / (d3 + d4 * paramDouble);
  }
  
  private static final void a(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramArrayOfInt[1] -= paramArrayOfInt[3] * paramInt2;
    paramArrayOfInt[2] -= paramArrayOfInt[4] * paramInt2;
    paramInt2 = paramArrayOfInt[1];
    int i = paramArrayOfInt[3];
    int j = paramArrayOfInt[2];
    int k = paramArrayOfInt[4];
    int m = paramArrayOfInt[1];
    int n = paramArrayOfInt[4];
    int i1 = paramArrayOfInt[2];
    int i2 = paramArrayOfInt[3];
    int i3 = paramArrayOfInt[1];
    int i4 = paramArrayOfInt[1];
    int i5 = paramArrayOfInt[2];
    int i6 = paramArrayOfInt[2];
    paramArrayOfInt[1] = (paramInt2 * i - j * k * paramInt1);
    paramArrayOfInt[2] = (m * n - i1 * i2);
    paramArrayOfInt[3] = (i3 * i4 - i5 * i6 * paramInt1);
    paramArrayOfInt[4] = 0;
  }
  
  private static final int c(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return paramInt2;
    }
    if (paramInt2 == 0) {
      return paramInt1;
    }
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt1 < paramInt2) {
      return c(paramInt2, paramInt1);
    }
    for (;;)
    {
      paramInt1 = j % i;
      if (paramInt1 == 0) {
        return i;
      }
      j = i;
      i = paramInt1;
    }
  }
  
  private static final boolean g(int paramInt)
  {
    int j;
    for (int i = (int)Math.sqrt(paramInt) - 1;; i = j)
    {
      j = i + 1;
      if (j * j > paramInt) {
        break;
      }
    }
    return i * i == paramInt;
  }
  
  private void y()
  {
    long l2 = this.fG;
    long l1 = this.fH;
    long l3 = this.fI;
    if (l1 >= 200L)
    {
      l2 *= l3 * l3;
      l3 = l2 * 1000L;
      l1 = l1 * l1 * 1000L;
      if ((l1 > l3 - l2) && (l1 < l3 + l2)) {
        return;
      }
      throw new RuntimeException();
    }
    throw new RuntimeException();
  }
  
  final void a(long paramLong1, long paramLong2)
  {
    this.fH = paramLong1;
    this.fI = paramLong2;
    y();
  }
  
  final boolean isExpired()
  {
    y();
    long l1 = this.fG;
    long l2 = this.fH;
    long l3 = this.fI;
    return l2 * l2 < l1 * (l3 * l3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bf
 * JD-Core Version:    0.7.0.1
 */