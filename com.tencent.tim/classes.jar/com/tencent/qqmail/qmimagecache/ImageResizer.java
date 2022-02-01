package com.tencent.qqmail.qmimagecache;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import java.io.FileDescriptor;
import moai.core.utilities.Utils;

public class ImageResizer
  extends ImageWorker
{
  private static final String TAG = "ImageResizer";
  protected int mImageHeight;
  protected int mImageWidth;
  
  public ImageResizer(Context paramContext, int paramInt)
  {
    super(paramContext);
    setImageSize(paramInt);
  }
  
  public ImageResizer(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    setImageSize(paramInt1, paramInt2);
  }
  
  @TargetApi(11)
  private static void addInBitmapOptions(BitmapFactory.Options paramOptions, ImageDrawableCache paramImageDrawableCache)
  {
    paramOptions.inMutable = true;
    if (paramImageDrawableCache != null)
    {
      paramImageDrawableCache = paramImageDrawableCache.getBitmapFromReusableSet(paramOptions);
      if (paramImageDrawableCache != null) {
        paramOptions.inBitmap = paramImageDrawableCache;
      }
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      int i = Math.round(k / paramInt2);
      j = Math.round(m / paramInt1);
      if (i < j) {}
      for (;;)
      {
        float f1 = m * k;
        float f2 = paramInt1 * paramInt2 * 2;
        for (;;)
        {
          j = i;
          if (f1 / (i * i) <= f2) {
            break;
          }
          i += 1;
        }
        i = j;
      }
    }
    return j;
  }
  
  public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2, ImageDrawableCache paramImageDrawableCache)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    if (Utils.hasHoneycomb()) {
      addInBitmapOptions(localOptions, paramImageDrawableCache);
    }
    return BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2, ImageDrawableCache paramImageDrawableCache)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
    if (Utils.hasHoneycomb()) {
      addInBitmapOptions(localOptions, paramImageDrawableCache);
    }
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  public static Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt1, int paramInt2, int paramInt3, ImageDrawableCache paramImageDrawableCache)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt2, paramInt3);
    if (Utils.hasHoneycomb()) {
      addInBitmapOptions(localOptions, paramImageDrawableCache);
    }
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
  }
  
  private Bitmap processBitmap(int paramInt)
  {
    Log.d("yh", "processBitmap resid");
    return decodeSampledBitmapFromResource(this.mResources, paramInt, this.mImageWidth, this.mImageHeight, getImageCache());
  }
  
  protected Bitmap processBitmap(Object paramObject)
  {
    Log.d("yh", "processBitmap parseint");
    return processBitmap(Integer.parseInt(String.valueOf(paramObject)));
  }
  
  public void setImageSize(int paramInt)
  {
    setImageSize(paramInt, paramInt);
  }
  
  public void setImageSize(int paramInt1, int paramInt2)
  {
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.ImageResizer
 * JD-Core Version:    0.7.0.1
 */