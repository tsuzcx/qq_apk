package com.tencent.util;

import android.graphics.Bitmap;

public class BitmapUtil
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int m = paramInt1 / j;
    int n = paramInt2 / k;
    if (n > m)
    {
      paramInt1 = (paramInt2 - k * paramInt1 / j) / 2;
      paramInt2 = paramInt1 / k;
      paramInt2 = i;
    }
    for (;;)
    {
      if (paramInt1 > 0) {}
      while (paramInt2 <= 0)
      {
        return null;
        if (n >= m) {
          break label93;
        }
        paramInt2 = (paramInt1 - j * paramInt2 / k) / 2;
        paramInt1 = paramInt2 / j;
        paramInt1 = 0;
        break;
      }
      return null;
      label93:
      paramInt1 = 0;
      paramInt2 = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */