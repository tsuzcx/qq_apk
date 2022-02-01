import android.graphics.Bitmap;
import java.lang.reflect.Array;

public class aqmp
{
  public static void fastblur(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt < 1) {
      return;
    }
    int i14 = paramBitmap.getWidth();
    int i15 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i14 * i15];
    paramBitmap.getPixels(arrayOfInt1, 0, i14, 0, 0, i14, i15);
    int i19 = i14 - 1;
    int i16 = i15 - 1;
    int i = i14 * i15;
    int i17 = paramInt + paramInt + 1;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[Math.max(i14, i15)];
    i = i17 + 1 >> 1;
    int j = i * i;
    int[] arrayOfInt6 = new int[j * 256];
    int i20 = arrayOfInt6.length;
    i = 0;
    while (i < j * 256)
    {
      arrayOfInt6[i] = (i / j);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i17, 3 });
    int i18 = paramInt + 1;
    int i7 = 0;
    int i6 = 0;
    i = 0;
    int m;
    int i8;
    int i2;
    int k;
    int i1;
    int i3;
    int i4;
    int i5;
    int n;
    int i9;
    int[] arrayOfInt7;
    int i10;
    int i11;
    int i12;
    for (;;)
    {
      if (i7 >= i15) {
        break label771;
      }
      m = 0;
      i8 = -paramInt;
      j = 0;
      i2 = 0;
      k = 0;
      i1 = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      n = 0;
      if (i8 <= paramInt)
      {
        i9 = arrayOfInt1[(Math.min(i19, Math.max(i8, 0)) + i)];
        arrayOfInt7 = arrayOfInt[(i8 + paramInt)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = i18 - Math.abs(i8);
        i3 += arrayOfInt7[0] * i9;
        i4 += arrayOfInt7[1] * i9;
        i5 += i9 * arrayOfInt7[2];
        if (i8 > 0)
        {
          m += arrayOfInt7[0];
          n += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i2 += arrayOfInt7[0];
          k += arrayOfInt7[1];
          i1 += arrayOfInt7[2];
        }
      }
      i10 = i3;
      i11 = i1;
      i8 = n;
      i3 = paramInt;
      i12 = j;
      i9 = m;
      int i13 = 0;
      m = i5;
      i1 = i4;
      i4 = i10;
      j = i11;
      n = i2;
      i5 = i12;
      i2 = i13;
      for (;;)
      {
        if (i2 >= i14) {
          break label755;
        }
        if ((i4 >= i20) || (i1 >= i20) || (m >= i20)) {
          break;
        }
        arrayOfInt2[i] = arrayOfInt6[i4];
        arrayOfInt3[i] = arrayOfInt6[i1];
        arrayOfInt4[i] = arrayOfInt6[m];
        arrayOfInt7 = arrayOfInt[((i3 - paramInt + i17) % i17)];
        i12 = arrayOfInt7[0];
        i11 = arrayOfInt7[1];
        i10 = arrayOfInt7[2];
        if (i7 == 0) {
          arrayOfInt5[i2] = Math.min(i2 + paramInt + 1, i19);
        }
        i13 = arrayOfInt1[(arrayOfInt5[i2] + i6)];
        arrayOfInt7[0] = ((0xFF0000 & i13) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i13) >> 8);
        arrayOfInt7[2] = (i13 & 0xFF);
        i9 += arrayOfInt7[0];
        i8 += arrayOfInt7[1];
        i5 += arrayOfInt7[2];
        i4 = i4 - n + i9;
        i1 = i1 - k + i8;
        m = m - j + i5;
        i3 = (i3 + 1) % i17;
        arrayOfInt7 = arrayOfInt[(i3 % i17)];
        n = n - i12 + arrayOfInt7[0];
        k = k - i11 + arrayOfInt7[1];
        j = j - i10 + arrayOfInt7[2];
        i9 -= arrayOfInt7[0];
        i8 -= arrayOfInt7[1];
        i5 -= arrayOfInt7[2];
        i += 1;
        i2 += 1;
      }
      label755:
      i7 += 1;
      i6 += i14;
    }
    label771:
    i = 0;
    while (i < i14)
    {
      m = 0;
      i7 = -paramInt * i14;
      i6 = -paramInt;
      j = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      k = 0;
      if (i6 <= paramInt)
      {
        i9 = Math.max(0, i7) + i;
        arrayOfInt7 = arrayOfInt[(i6 + paramInt)];
        arrayOfInt7[0] = arrayOfInt2[i9];
        arrayOfInt7[1] = arrayOfInt3[i9];
        arrayOfInt7[2] = arrayOfInt4[i9];
        i10 = i18 - Math.abs(i6);
        i8 = i3 + arrayOfInt2[i9] * i10;
        i4 += arrayOfInt3[i9] * i10;
        i5 += arrayOfInt4[i9] * i10;
        if (i6 > 0)
        {
          m += arrayOfInt7[0];
          k += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i3 = i7;
          if (i6 < i16) {
            i3 = i7 + i14;
          }
          i6 += 1;
          i7 = i3;
          i3 = i8;
          break;
          n += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          i2 += arrayOfInt7[2];
        }
      }
      i6 = 0;
      i7 = i;
      i9 = paramInt;
      i8 = j;
      j = i9;
      while (i6 < i15)
      {
        arrayOfInt1[i7] = (0xFF000000 | arrayOfInt6[i3] << 16 | arrayOfInt6[i4] << 8 | arrayOfInt6[i5]);
        arrayOfInt7 = arrayOfInt[((j - paramInt + i17) % i17)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[i6] = (Math.min(i6 + i18, i16) * i14);
        }
        i12 = arrayOfInt5[i6] + i;
        arrayOfInt7[0] = arrayOfInt2[i12];
        arrayOfInt7[1] = arrayOfInt3[i12];
        arrayOfInt7[2] = arrayOfInt4[i12];
        m += arrayOfInt7[0];
        k += arrayOfInt7[1];
        i8 += arrayOfInt7[2];
        i3 = i3 - n + m;
        i4 = i4 - i1 + k;
        i5 = i5 - i2 + i8;
        j = (j + 1) % i17;
        arrayOfInt7 = arrayOfInt[j];
        n = n - i11 + arrayOfInt7[0];
        i1 = i1 - i10 + arrayOfInt7[1];
        i2 = i2 - i9 + arrayOfInt7[2];
        m -= arrayOfInt7[0];
        k -= arrayOfInt7[1];
        i8 -= arrayOfInt7[2];
        i7 += i14;
        i6 += 1;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i14, 0, 0, i14, i15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmp
 * JD-Core Version:    0.7.0.1
 */