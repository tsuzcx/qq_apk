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
    int i = (int)d - 1;
    while ((i + 1) * (i + 1) <= i1) {
      i += 1;
    }
    localObject[0] = i;
    if (i * i == i1) {
      return;
    }
    int k = 1;
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[1] = 1;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = (-localObject[0]);
    arrayOfInt1[4] = 1;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 100, 5 });
    i = 0;
    int j = 0;
    if (k < 100)
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
      label305:
      if (i < j)
      {
        int[] arrayOfInt2 = arrayOfInt[i];
        if ((arrayOfInt2[1] != arrayOfInt1[1]) || (arrayOfInt2[2] != arrayOfInt1[2]) || (arrayOfInt2[3] != arrayOfInt1[3]) || (arrayOfInt2[4] != arrayOfInt1[4])) {}
      }
      else
      {
        if (i >= j) {
          break label484;
        }
      }
    }
    for (j = i;; j = i)
    {
      int i2 = k - 1;
      long l1 = 0L;
      long l2 = 1L;
      k = 1;
      i = 0;
      int n;
      if ((l1 < 200L) || (i == 0))
      {
        n = k + 1;
        l1 = 0L;
        l2 = 1L;
        k = n - 1;
        label424:
        if (k >= 0)
        {
          if (n <= i2) {}
          for (int m = localObject[k];; m = localObject[((k - j) % i2 + j)])
          {
            l4 = m;
            k -= 1;
            l3 = l1;
            l1 = l2 + l4 * l1;
            l2 = l3;
            break label424;
            i += 1;
            break label305;
            label484:
            arrayOfInt[j][1] = arrayOfInt1[1];
            arrayOfInt[j][2] = arrayOfInt1[2];
            arrayOfInt[j][3] = arrayOfInt1[3];
            arrayOfInt[j][4] = arrayOfInt1[4];
            j += 1;
            localObject[k] = ((int)Math.floor(a(d, arrayOfInt1)));
            a(i1, arrayOfInt1, localObject[k]);
            k += 1;
            break;
          }
        }
        if (l1 >= 1000000L) {
          throw new RuntimeException();
        }
        long l3 = l1 * l1;
        long l4 = l2 * l2;
        long l5 = i1 * l4;
        long l6 = 1000L * l3;
        if ((l1 < 200L) || (999L * l5 >= l6) || (l6 >= l5 * 1001L) || (i != 0) || (((!paramBoolean) || (l3 >= i1 * l4)) && ((paramBoolean) || (l3 <= l4 * i1)))) {
          break label725;
        }
        i = 1;
      }
      label725:
      for (;;)
      {
        k = n;
        break;
        a(l1, l2);
        return;
      }
    }
  }
  
  private static final double a(double paramDouble, int[] paramArrayOfInt)
  {
    return (paramArrayOfInt[1] + paramArrayOfInt[2] * paramDouble) / (paramArrayOfInt[3] + paramArrayOfInt[4] * paramDouble);
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
    do
    {
      paramInt1 = i;
      i = paramInt2;
      j = paramInt1;
      paramInt2 = j % i;
    } while (paramInt2 != 0);
    return i;
  }
  
  private static final boolean g(int paramInt)
  {
    int i = (int)Math.sqrt(paramInt) - 1;
    while ((i + 1) * (i + 1) <= paramInt) {
      i += 1;
    }
    return i * i == paramInt;
  }
  
  private void y()
  {
    long l2 = this.fG;
    long l1 = this.fH;
    long l3 = this.fI;
    if (l1 < 200L) {
      throw new RuntimeException();
    }
    l2 *= l3 * l3;
    l3 = l2 * 1000L;
    l1 = l1 * l1 * 1000L;
    if ((l1 <= l3 - l2) || (l1 >= l2 + l3)) {
      throw new RuntimeException();
    }
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