package com.tencent.component.media.image;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ImageOptionInBitmap
{
  private static boolean hasHONEYCOMB;
  private static Set<SoftReference<Bitmap>> mReusableBitmaps = new HashSet();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      hasHONEYCOMB = bool;
      return;
    }
  }
  
  @TargetApi(11)
  public static void addInBitmapOptions(BitmapFactory.Options paramOptions)
  {
    if (!hasHONEYCOMB) {}
    Bitmap localBitmap;
    do
    {
      return;
      paramOptions.inMutable = true;
      localBitmap = getBitmapFromReusableSet(paramOptions);
    } while (localBitmap == null);
    paramOptions.inBitmap = localBitmap;
  }
  
  public static void addReusableBitmaps(Bitmap paramBitmap)
  {
    if (!hasHONEYCOMB) {
      return;
    }
    synchronized (mReusableBitmaps)
    {
      mReusableBitmaps.add(new SoftReference(paramBitmap));
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  private static boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      if (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * getBytesPerPixel(paramBitmap.getConfig()) > paramBitmap.getAllocationByteCount()) {}
    }
    while ((paramBitmap.getWidth() == paramOptions.outWidth) && (paramBitmap.getHeight() == paramOptions.outHeight) && (paramOptions.inSampleSize == 1))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static void clear()
  {
    synchronized (mReusableBitmaps)
    {
      mReusableBitmaps.clear();
      return;
    }
  }
  
  private static Bitmap getBitmapFromReusableSet(BitmapFactory.Options paramOptions)
  {
    if ((mReusableBitmaps != null) && (!mReusableBitmaps.isEmpty())) {
      for (;;)
      {
        synchronized (mReusableBitmaps)
        {
          Iterator localIterator = mReusableBitmaps.iterator();
          if (localIterator.hasNext())
          {
            Bitmap localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
            if ((localBitmap != null) && (localBitmap.isMutable()))
            {
              if (!canUseForInBitmap(localBitmap, paramOptions)) {
                continue;
              }
              localIterator.remove();
              paramOptions = localBitmap;
              return paramOptions;
            }
            localIterator.remove();
          }
        }
        paramOptions = null;
      }
    }
    return null;
  }
  
  private static int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageOptionInBitmap
 * JD-Core Version:    0.7.0.1
 */