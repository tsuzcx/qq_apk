package com.tencent.open.base;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.File;

public class BitmapUtil
{
  public static Bitmap a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.getConfig() != null)) {
      return paramBitmap;
    }
    Bitmap localBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, false);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    if (paramInt1 == -1) {
      paramInt1 = paramOptions.outWidth * paramInt2 / paramOptions.outHeight;
    }
    for (;;)
    {
      if (paramInt2 == -1) {
        paramInt2 = paramOptions.outHeight * paramInt1 / paramOptions.outWidth;
      }
      for (;;)
      {
        int i = paramInt2;
        int j = paramInt1;
        if (paramInt1 != -1)
        {
          i = paramInt2;
          j = paramInt1;
          if (paramInt2 != -1)
          {
            if (paramOptions.outHeight <= paramOptions.outWidth) {
              break label123;
            }
            if (!paramBoolean) {
              break label104;
            }
            j = paramOptions.outWidth * paramInt2 / paramOptions.outHeight;
            i = paramInt2;
          }
        }
        for (;;)
        {
          return Bitmap.createScaledBitmap(paramBitmap, j, i, true);
          label104:
          i = paramOptions.outHeight * paramInt1 / paramOptions.outWidth;
          j = paramInt1;
          continue;
          label123:
          if (paramBoolean)
          {
            i = paramOptions.outHeight * paramInt1 / paramOptions.outWidth;
            j = paramInt1;
          }
          else
          {
            j = paramOptions.outWidth * paramInt2 / paramOptions.outHeight;
            i = paramInt2;
          }
        }
      }
    }
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramString == null) || (!new File(paramString).exists())) {}
    do
    {
      BitmapFactory.Options localOptions;
      do
      {
        return null;
        localOptions = a();
        BitmapFactory.decodeFile(paramString, localOptions);
      } while ((localOptions.outHeight <= 0) || (localOptions.outWidth <= 0));
      a(localOptions, paramInt1, paramInt2, paramBoolean);
      try
      {
        localObject = BitmapFactory.decodeFile(paramString, localOptions);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          localOptions.inSampleSize -= 1;
          paramString = BitmapFactory.decodeFile(paramString, localOptions);
          continue;
          Bitmap.Config localConfig = Bitmap.Config.RGB_565;
        }
      }
    } while (paramString == null);
    if (paramString.hasAlpha())
    {
      localObject = Bitmap.Config.ARGB_8888;
      localOptions.inPreferredConfig = ((Bitmap.Config)localObject);
      return a(paramString, paramInt1, paramInt2, localOptions, paramBoolean);
    }
  }
  
  public static BitmapFactory.Options a()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    return localOptions;
  }
  
  public static BitmapFactory.Options a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramOptions.inJustDecodeBounds = false;
    paramOptions.inSampleSize = 2;
    if (paramBoolean) {
      while ((paramOptions.outWidth / paramOptions.inSampleSize >= paramInt1) || (paramOptions.outHeight / paramOptions.inSampleSize >= paramInt2)) {
        paramOptions.inSampleSize += 1;
      }
    }
    while ((paramOptions.outWidth / paramOptions.inSampleSize >= paramInt1) && (paramOptions.outHeight / paramOptions.inSampleSize >= paramInt2)) {
      paramOptions.inSampleSize += 1;
    }
    paramOptions.inSampleSize -= 1;
    return paramOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.base.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */