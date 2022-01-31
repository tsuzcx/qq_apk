package com.tencent.mobileqq.activity.aio.photo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.image.DownloadParams;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PhotoDecoder
  extends LocaleFileDownloader
{
  private static final float a = 1.5F;
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private static final int d = 5242880;
  private float b;
  
  public PhotoDecoder(Resources paramResources)
  {
    this.b = paramResources.getDisplayMetrics().density;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt6 == 2) || (paramInt3 == 2147483647) || (paramInt4 == 2147483647))
    {
      paramInt2 = 1;
      return paramInt2;
    }
    float f;
    if (paramInt6 == 1) {
      switch (paramInt5)
      {
      default: 
        paramInt5 = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = paramInt5;
        paramInt6 = paramInt1;
        paramInt5 = paramInt2;
        if (paramInt2 > paramInt3 * 2)
        {
          paramInt6 = paramInt1;
          paramInt5 = paramInt2;
          if (paramInt1 > paramInt4)
          {
            paramInt5 = (int)(paramInt2 * this.b + 0.5D);
            paramInt6 = (int)(paramInt1 * this.b + 0.5D);
          }
        }
        paramInt1 = paramInt6 * paramInt3 / paramInt5;
        if (paramInt5 >= paramInt3) {
          if (paramInt4 >= paramInt1) {
            f = paramInt3 / paramInt5;
          }
        }
        break;
      }
    }
    for (;;)
    {
      label151:
      if (this.b > 2.0F) {}
      for (paramInt1 = (int)(1.0F / f * 3.0F / 4.0F);; paramInt1 = (int)(1.0F / f))
      {
        if (paramInt1 > 1) {
          break label319;
        }
        return 1;
        break;
        if (paramInt4 * 1.5F >= paramInt1)
        {
          f = paramInt4 / paramInt6;
          break label151;
        }
        f = paramInt3 / paramInt5;
        break label151;
        if (paramInt6 < paramInt4)
        {
          if (paramInt4 >= paramInt1)
          {
            if (paramInt5 * 1.5F < paramInt3) {
              break label481;
            }
            f = paramInt3 / paramInt5;
            break label151;
          }
          if (paramInt6 * 1.5F < paramInt4) {
            break label481;
          }
          f = paramInt4 / paramInt6;
          break label151;
        }
        if ((paramInt6 <= paramInt4) || (paramInt6 >= paramInt4 * 1.5F)) {
          break label481;
        }
        f = paramInt4 / paramInt6;
        break label151;
      }
      label319:
      if (paramInt1 > 32)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "the pic it fxxking large.....");
        }
        return 32;
      }
      paramInt3 = 65536;
      for (;;)
      {
        if (paramInt3 == 0) {
          break label369;
        }
        paramInt4 = paramInt1 & paramInt3;
        paramInt2 = paramInt4;
        if (paramInt4 != 0) {
          break;
        }
        paramInt3 >>= 1;
      }
      label369:
      return 1;
      if ((paramInt3 == 0) || (paramInt4 == 0) || (paramInt3 == -1) || (paramInt4 == -1)) {
        return 1;
      }
      int i = 1;
      paramInt5 = paramInt2;
      paramInt6 = paramInt1;
      paramInt1 = i;
      label405:
      if (paramInt5 <= paramInt4)
      {
        paramInt2 = paramInt1;
        if (paramInt6 <= paramInt3) {
          break;
        }
      }
      i = Math.round(paramInt5 / paramInt4);
      paramInt2 = Math.round(paramInt6 / paramInt3);
      if (i > paramInt2) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < 2) {
          break;
        }
        paramInt6 /= 2;
        paramInt5 /= 2;
        paramInt1 *= 2;
        break label405;
        i = paramInt2;
      }
      label481:
      f = 1.0F;
    }
  }
  
  private Object a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    localFileInputStream = new FileInputStream(paramFile);
    j = 0;
    try
    {
      l1 = SystemClock.uptimeMillis();
      localObject = new byte[2];
      localFileInputStream.read((byte[])localObject);
      int m = localObject[0];
      int n = localObject[1];
      paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
      i = 0;
      k = 0;
      switch (m << 8 & 0xFF00 | n & 0xFF)
      {
      }
    }
    finally
    {
      for (;;)
      {
        long l1;
        Object localObject;
        int k;
        byte[] arrayOfByte;
        paramInt = j;
        continue;
        int i = k;
      }
    }
    arrayOfByte = new byte[(int)paramFile.length()];
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    localFileInputStream.read(arrayOfByte, localObject.length, localFileInputStream.available());
    localFileInputStream.close();
    for (;;)
    {
      try
      {
        for (;;)
        {
          long l2;
          if (QLog.isColorLevel())
          {
            l2 = SystemClock.uptimeMillis();
            QLog.d("PEAK", 2, "read file to memory cost: " + (l2 - l1));
          }
          l1 = SystemClock.uptimeMillis();
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          localOptions.inPreferredConfig = paramURLDrawableHandler;
          localOptions.inDensity = 160;
          localOptions.inTargetDensity = 160;
          localOptions.inScreenDensity = 160;
          localOptions.inPurgeable = true;
          localOptions.inInputShareable = true;
          BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
          j = localOptions.outWidth;
          k = localOptions.outHeight;
          if (i != 0) {
            paramDownloadParams.outOrientation = new ExifInterface(paramFile.getAbsolutePath()).getAttributeInt("Orientation", 1);
          }
          if (QLog.isColorLevel())
          {
            l2 = SystemClock.uptimeMillis();
            QLog.d("PEAK", 2, "read size & exif cost: " + (l2 - l1));
          }
          localOptions.inJustDecodeBounds = false;
          paramInt = a(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          try
          {
            localOptions.inSampleSize = paramInt;
            paramURLDrawableHandler = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
            paramURLDrawableHandler.setDensity(160);
            if (Build.VERSION.SDK_INT < 11) {
              break label768;
            }
            boolean bool = SliceBitmap.needSlice(paramURLDrawableHandler);
            if (!bool) {
              break label768;
            }
            try
            {
              localObject = new SliceBitmap(paramURLDrawableHandler);
              paramURLDrawableHandler.recycle();
              paramURLDrawableHandler = (URLDrawableHandler)localObject;
              if (localOptions.inSampleSize > 1)
              {
                if (!paramDownloadParams.mAutoScaleByDensity) {
                  break label712;
                }
                paramDownloadParams.outWidth = ((int)Math.ceil(j * this.b));
                paramDownloadParams.outHeight = ((int)Math.ceil(k * this.b));
              }
              if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + j + "x" + k + " , sampleSize: " + localOptions.inSampleSize);
              }
              return paramURLDrawableHandler;
            }
            catch (Exception localException)
            {
              if (paramURLDrawableHandler == null) {
                break label602;
              }
              paramURLDrawableHandler.recycle();
              throw new OutOfMemoryError("slice failed.");
            }
            i = 1;
            paramURLDrawableHandler = Bitmap.Config.RGB_565;
          }
          catch (OutOfMemoryError paramURLDrawableHandler)
          {
            label602:
            if (!QLog.isColorLevel()) {
              break label681;
            }
            QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + 1 + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
            label681:
            i = paramInt * 2;
            System.gc();
            Thread.yield();
            System.gc();
            paramInt = i;
          }
        }
        localFileInputStream.close();
        return null;
      }
      finally
      {
        label712:
        paramInt = 1;
        if (paramInt != 0) {
          continue;
        }
        localFileInputStream.close();
      }
      if (i <= 8)
      {
        paramURLDrawableHandler = null;
        continue;
        paramDownloadParams.outWidth = ((int)Math.ceil(j));
        paramDownloadParams.outHeight = ((int)Math.ceil(k));
      }
    }
  }
  
  private Object b(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    paramURLDrawableHandler = new FileInputStream(paramFile);
    try
    {
      localObject = new byte[2];
      paramURLDrawableHandler.read((byte[])localObject);
      k = localObject[0];
      m = localObject[1];
      paramURLDrawableHandler.close();
      localObject = new FileInputStream(paramFile);
    }
    finally
    {
      for (;;)
      {
        int k;
        int m;
        label132:
        BitmapFactory.Options localOptions;
        paramDownloadParams = paramURLDrawableHandler;
        paramInt = 0;
      }
    }
    try
    {
      paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
      i = 0;
      j = 0;
      switch (k << 8 & 0xFF00 | m & 0xFF)
      {
      }
    }
    finally
    {
      paramInt = 0;
      paramDownloadParams = (DownloadParams)localObject;
      break label618;
      paramURLDrawableHandler = null;
      break label330;
      i = j;
      break label132;
      break label330;
    }
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPreferredConfig = paramURLDrawableHandler;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    BitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
    j = localOptions.outWidth;
    k = localOptions.outHeight;
    ((InputStream)localObject).close();
    if (i != 0) {}
    for (;;)
    {
      try
      {
        for (;;)
        {
          paramDownloadParams.outOrientation = new ExifInterface(paramFile.getAbsolutePath()).getAttributeInt("Orientation", 1);
          localOptions.inJustDecodeBounds = false;
          paramInt = a(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          i = 1;
          if (i > 3) {
            break label648;
          }
          try
          {
            localOptions.inSampleSize = paramInt;
            paramURLDrawableHandler = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
            paramURLDrawableHandler.setDensity(160);
            if (Build.VERSION.SDK_INT < 11) {
              break label660;
            }
            boolean bool = SliceBitmap.needSlice(paramURLDrawableHandler);
            if (!bool) {
              break label660;
            }
            try
            {
              SliceBitmap localSliceBitmap = new SliceBitmap(paramURLDrawableHandler);
              paramURLDrawableHandler.recycle();
              paramURLDrawableHandler = localSliceBitmap;
              label330:
              if (localOptions.inSampleSize > 1)
              {
                if (!paramDownloadParams.mAutoScaleByDensity) {
                  break label586;
                }
                paramDownloadParams.outWidth = ((int)Math.ceil(j * this.b));
                paramDownloadParams.outHeight = ((int)Math.ceil(k * this.b));
              }
              if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + localOptions.outWidth + "x" + localOptions.outHeight + " , sampleSize: " + localOptions.inSampleSize);
              }
              return paramURLDrawableHandler;
            }
            catch (Exception localException)
            {
              if (paramURLDrawableHandler == null) {
                break label482;
              }
              paramURLDrawableHandler.recycle();
              throw new OutOfMemoryError("slice failed.");
            }
            i = 1;
            paramURLDrawableHandler = Bitmap.Config.RGB_565;
          }
          catch (OutOfMemoryError paramURLDrawableHandler)
          {
            label482:
            if (!QLog.isColorLevel()) {
              break label562;
            }
            QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
            label562:
            System.gc();
            Thread.yield();
            System.gc();
            i += 1;
            paramInt *= 2;
          }
        }
        ((InputStream)localObject).close();
        return null;
      }
      finally
      {
        label586:
        paramInt = 1;
        paramDownloadParams = (DownloadParams)localObject;
        if (paramInt != 0) {
          continue;
        }
        paramDownloadParams.close();
      }
      continue;
      paramDownloadParams.outWidth = ((int)Math.ceil(j));
      paramDownloadParams.outHeight = ((int)Math.ceil(k));
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      l2 = paramFile.length();
      int i = 0;
      if (paramDownloadParams.tag != null) {
        i = ((Integer)paramDownloadParams.tag).intValue();
      }
      if (l2 < 5242880L)
      {
        paramURLDrawableHandler = a(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        if (QLog.isColorLevel())
        {
          l2 = SystemClock.uptimeMillis();
          QLog.d("PEAK", 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
          paramDownloadParams = paramURLDrawableHandler;
        }
        return paramDownloadParams;
      }
      paramURLDrawableHandler = b(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
      paramDownloadParams = paramURLDrawableHandler;
      return paramURLDrawableHandler;
    }
    finally
    {
      long l2;
      if (QLog.isColorLevel())
      {
        l2 = SystemClock.uptimeMillis();
        QLog.d("PEAK", 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoDecoder
 * JD-Core Version:    0.7.0.1
 */