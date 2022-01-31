import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;

public class uki
{
  public static double a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 == null)) {}
    while ((paramBitmap1.getWidth() != paramBitmap2.getWidth()) || (paramBitmap1.getHeight() != paramBitmap2.getHeight())) {
      return 0.0D;
    }
    int i = a(a(paramBitmap1));
    int j = a(a(paramBitmap2));
    return a(a(paramBitmap1, i), a(paramBitmap2, j), paramBitmap1.getWidth(), paramBitmap1.getHeight());
  }
  
  private static double a(int[][] paramArrayOfInt1, int[][] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    double d1 = 0.0D;
    int i = 0;
    while (i < paramInt1)
    {
      int j = 0;
      while (j < paramInt2)
      {
        double d2 = d1;
        if (paramArrayOfInt1[i][j] != paramArrayOfInt2[i][j]) {
          d2 = d1 + 1.0D;
        }
        j += 1;
        d1 = d2;
      }
      i += 1;
    }
    return 1.0D - d1 / (paramInt1 * paramInt2);
  }
  
  private static int a(byte[] paramArrayOfByte)
  {
    float f1 = 0.0F;
    int m = 0;
    int[] arrayOfInt = new int[256];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    int j = 0;
    i = 0;
    while (i < paramArrayOfByte.length)
    {
      n = paramArrayOfByte[i] & 0xFF;
      arrayOfInt[n] += 1;
      k = j;
      if (arrayOfInt[n] > j) {
        k = arrayOfInt[n];
      }
      i += 1;
      j = k;
    }
    int n = paramArrayOfByte.length;
    i = 0;
    for (float f2 = 0.0F; i < 256; f2 = f3 + f2)
    {
      f3 = arrayOfInt[i] * i;
      i += 1;
    }
    j = 0;
    float f3 = 0.0F;
    int k = 0;
    i = m;
    if (i < 256)
    {
      k = arrayOfInt[i] + k;
      if (k != 0) {}
    }
    for (;;)
    {
      i += 1;
      break;
      m = n - k;
      if (m == 0) {
        return j;
      }
      f1 = arrayOfInt[i] * i + f1;
      float f4 = f1 / k;
      float f5 = (f2 - f1) / m;
      float f6 = k;
      f4 = (f4 - f5) * (m * f6 * (f4 - f5));
      if (f4 > f3)
      {
        j = i;
        f3 = f4;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if (paramBitmap.getWidth() <= 50)
    {
      localBitmap = paramBitmap;
      if (paramBitmap.getHeight() <= 50) {}
    }
    else
    {
      localBitmap = a(paramBitmap, 50, 50);
    }
    return b(localBitmap);
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, false);
  }
  
  private static byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramBitmap.getByteCount());
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static int[][] a(Bitmap paramBitmap, int paramInt)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, j });
    i = 0;
    while (i < paramBitmap.getWidth())
    {
      j = 0;
      if (j < paramBitmap.getHeight())
      {
        if (Color.red(paramBitmap.getPixel(i, j)) > paramInt) {
          arrayOfInt[i][j] = 1;
        }
        for (;;)
        {
          j += 1;
          break;
          arrayOfInt[i][j] = 0;
        }
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static Bitmap b(Bitmap paramBitmap)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int[] arrayOfInt = new int[k * m];
    paramBitmap.getPixels(arrayOfInt, 0, k, 0, 0, k, m);
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < k)
      {
        int n = arrayOfInt[(k * i + j)];
        double d = (0xFF0000 & n) >> 16;
        n = (int)(((0xFF00 & n) >> 8) * 0.59D + d * 0.3D + (n & 0xFF) * 0.11D);
        arrayOfInt[(k * i + j)] = (n | n << 16 | 0xFF000000 | n << 8);
        j += 1;
      }
      i += 1;
    }
    paramBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.RGB_565);
    paramBitmap.setPixels(arrayOfInt, 0, k, 0, 0, k, m);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uki
 * JD-Core Version:    0.7.0.1
 */