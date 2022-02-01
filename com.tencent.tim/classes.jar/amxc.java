import java.util.Arrays;

public class amxc
{
  static boolean a(int paramInt, long[][] paramArrayOfLong, long[] paramArrayOfLong1, long[] paramArrayOfLong2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2, long[] paramArrayOfLong3)
  {
    paramArrayOfBoolean1[paramInt] = true;
    int i = 0;
    if (i < paramArrayOfLong2.length)
    {
      if ((paramArrayOfBoolean2[i] != 0) || (paramArrayOfLong[paramInt][i] <= 0L)) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayOfLong1[paramInt] + paramArrayOfLong2[i] - paramArrayOfLong[paramInt][i];
        if (l == 0L)
        {
          paramArrayOfBoolean2[i] = true;
          int j = paramArrayOfInt2[i];
          if ((j == -1) || (a(j, paramArrayOfLong, paramArrayOfLong1, paramArrayOfLong2, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfBoolean1, paramArrayOfBoolean2, paramArrayOfLong3)))
          {
            paramArrayOfInt2[i] = paramInt;
            paramArrayOfInt1[paramInt] = i;
            return true;
          }
        }
        else if (l < paramArrayOfLong3[i])
        {
          paramArrayOfLong3[i] = l;
        }
      }
    }
    return false;
  }
  
  public static int[] a(long[][] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    long[] arrayOfLong1 = new long[paramInt1];
    long[] arrayOfLong2 = new long[paramInt2];
    long[] arrayOfLong3 = new long[paramInt2];
    int[] arrayOfInt1 = new int[paramInt1];
    int[] arrayOfInt2 = new int[paramInt2];
    Arrays.fill(arrayOfLong1, -9223372036854775808L);
    Arrays.fill(arrayOfLong2, 0L);
    int i = 0;
    int j;
    while (i < paramInt1)
    {
      j = 0;
      while (j < paramInt2)
      {
        if ((paramArrayOfLong[i][j] > 0L) && (paramArrayOfLong[i][j] > arrayOfLong1[i])) {
          arrayOfLong1[i] = paramArrayOfLong[i][j];
        }
        j += 1;
      }
      i += 1;
    }
    Arrays.fill(arrayOfInt1, -1);
    Arrays.fill(arrayOfInt2, -1);
    i = 0;
    if (i < paramInt1)
    {
      boolean[] arrayOfBoolean1 = new boolean[paramInt1];
      boolean[] arrayOfBoolean2 = new boolean[paramInt2];
      Arrays.fill(arrayOfLong3, 9223372036854775807L);
      Arrays.fill(arrayOfBoolean1, false);
      Arrays.fill(arrayOfBoolean2, false);
      for (;;)
      {
        long l1;
        if (!a(i, paramArrayOfLong, arrayOfLong1, arrayOfLong2, arrayOfInt1, arrayOfInt2, arrayOfBoolean1, arrayOfBoolean2, arrayOfLong3))
        {
          l1 = 9223372036854775807L;
          j = 0;
          if (j < paramInt2)
          {
            long l2;
            if (arrayOfBoolean2[j] != 0) {
              l2 = l1;
            }
            for (;;)
            {
              j += 1;
              l1 = l2;
              break;
              l2 = l1;
              if (arrayOfLong3[j] < l1) {
                l2 = arrayOfLong3[j];
              }
            }
          }
          if ((l1 != 9223372036854775807L) && (l1 != 0L)) {}
        }
        else
        {
          i += 1;
          break;
        }
        j = 0;
        while (j <= i)
        {
          if (arrayOfBoolean1[j] != 0) {
            arrayOfLong1[j] -= l1;
          }
          j += 1;
        }
        j = 0;
        if (j < paramInt2)
        {
          if (arrayOfBoolean2[j] != 0) {
            arrayOfLong2[j] += l1;
          }
          for (;;)
          {
            j += 1;
            break;
            arrayOfLong3[j] -= l1;
          }
        }
        Arrays.fill(arrayOfBoolean1, false);
        Arrays.fill(arrayOfBoolean2, false);
      }
    }
    return arrayOfInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxc
 * JD-Core Version:    0.7.0.1
 */