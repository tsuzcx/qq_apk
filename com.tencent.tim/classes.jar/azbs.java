public class azbs
{
  public static void a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int m = 0;
    int i = 0;
    int i7 = paramInt1 * paramInt2;
    int j = 0;
    int i4 = 0;
    int n;
    int k;
    int i5;
    int i1;
    if (i4 < paramInt2)
    {
      n = (i4 >> 1) * paramInt1 / 2;
      k = i7 * 5 / 4;
      k = (i4 >> 1) * paramInt1 / 2 + k;
      i5 = 0;
      n = i7 + n;
      if (i5 < paramInt1)
      {
        i1 = (paramArrayOfByte[j] & 0xFF) - 16;
        if (i1 >= 0) {
          break label389;
        }
        i1 = 0;
      }
    }
    label389:
    for (;;)
    {
      int i2;
      if ((i5 & 0x1) == 0)
      {
        i = paramArrayOfByte[n];
        i2 = paramArrayOfByte[k];
        m = n + 1;
        n = (i2 & 0xFF) - 128;
        i = (i & 0xFF) - 128;
        i2 = k + 1;
        k = m;
        m = i2;
      }
      for (;;)
      {
        i1 *= 1192;
        i2 = i1 + n * 1634;
        int i3 = i1 - n * 833 - i * 400;
        int i6 = i1 + i * 2066;
        if (i2 < 0)
        {
          i1 = 0;
          label210:
          if (i3 >= 0) {
            break label320;
          }
          i2 = 0;
          label218:
          if (i6 >= 0) {
            break label338;
          }
          i3 = 0;
        }
        for (;;)
        {
          paramArrayOfInt[j] = (i3 >> 10 & 0xFF | i2 >> 2 & 0xFF00 | i1 << 6 & 0xFF0000 | 0xFF000000);
          i5 += 1;
          i2 = j + 1;
          j = n;
          i1 = i;
          n = k;
          k = m;
          i = j;
          m = i1;
          j = i2;
          break;
          i1 = i2;
          if (i2 <= 262143) {
            break label210;
          }
          i1 = 262143;
          break label210;
          label320:
          i2 = i3;
          if (i3 <= 262143) {
            break label218;
          }
          i2 = 262143;
          break label218;
          label338:
          i3 = i6;
          if (i6 > 262143) {
            i3 = 262143;
          }
        }
        i4 += 1;
        break;
        return;
        i2 = m;
        m = k;
        k = n;
        n = i;
        i = i2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azbs
 * JD-Core Version:    0.7.0.1
 */