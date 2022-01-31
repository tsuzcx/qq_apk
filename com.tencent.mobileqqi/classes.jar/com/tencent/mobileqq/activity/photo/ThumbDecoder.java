package com.tencent.mobileqq.activity.photo;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URL;

public class ThumbDecoder
  implements BitmapDecoder
{
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    int i;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    }
    while (i > paramInt3 * 2)
    {
      j *= 2;
      i /= 2;
      continue;
      i = paramInt1;
    }
    return a(paramInt1, paramInt2, paramInt3, j);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = paramInt3 * paramInt3 * paramInt4 * paramInt4;
    while (paramInt1 * paramInt2 > paramInt3 * 4)
    {
      paramInt3 *= 4;
      paramInt4 *= 2;
    }
    return paramInt4;
  }
  
  static int a(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      if (paramString == null) {
        return 0;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("hehe", 2, "new ExifInterface", paramString);
        }
        paramString = null;
      }
      switch (paramString.getAttributeInt("Orientation", 0))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      }
    }
    return 180;
    return 90;
    return 270;
  }
  
  public Bitmap a(URL paramURL)
  {
    try
    {
      LocalPhotoInfo localLocalPhotoInfo = LocalPhotoInfo.a(paramURL);
      if (localLocalPhotoInfo == null) {
        break label351;
      }
      paramURL = new BitmapFactory.Options();
      paramURL.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(localLocalPhotoInfo.a, paramURL);
      paramURL.inSampleSize = a(paramURL.outWidth, paramURL.outHeight, localLocalPhotoInfo.f);
      paramURL.inJustDecodeBounds = false;
      paramURL = BitmapFactory.decodeFile(localLocalPhotoInfo.a, paramURL);
      if (paramURL == null) {
        localObject = paramURL;
      }
      try
      {
        if (!QLog.isColorLevel()) {
          break label360;
        }
        QLog.e("ThumbDecoder", 2, "decode bitmap return null,maybe oom");
        return paramURL;
      }
      catch (Throwable localThrowable1) {}
      int i = a(localLocalPhotoInfo.a);
      if ((i == 0) && (paramURL.getWidth() == localLocalPhotoInfo.f) && (paramURL.getHeight() == localLocalPhotoInfo.f))
      {
        localObject = paramURL;
        if (paramURL.getConfig() == Bitmap.Config.RGB_565) {
          break label360;
        }
      }
      int j = paramURL.getWidth();
      int k = paramURL.getHeight();
      Object localObject = new Rect();
      RectF localRectF = new RectF(0.0F, 0.0F, localLocalPhotoInfo.f, localLocalPhotoInfo.f);
      if (j > k)
      {
        j = (j - k) / 2;
        ((Rect)localObject).set(j, 0, j + k, k + 0);
      }
      for (;;)
      {
        Bitmap localBitmap = Bitmap.createBitmap(localLocalPhotoInfo.f, localLocalPhotoInfo.f, Bitmap.Config.RGB_565);
        Canvas localCanvas = new Canvas(localBitmap);
        if (i != 0) {
          localCanvas.rotate(i, localLocalPhotoInfo.f / 2.0F, localLocalPhotoInfo.f / 2.0F);
        }
        localCanvas.drawBitmap(paramURL, (Rect)localObject, localRectF, new Paint(6));
        if (localBitmap == null) {
          break;
        }
        paramURL.recycle();
        return localBitmap;
        k = (k - j) / 2;
        ((Rect)localObject).set(0, k, 0 + j, j + k);
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        URL localURL;
        label351:
        paramURL = null;
      }
      label360:
      return localThrowable2;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ThumbDecoder", 2, "can't getBitmap", localThrowable1);
    }
    localURL = paramURL;
    if (paramURL == null) {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.ThumbDecoder
 * JD-Core Version:    0.7.0.1
 */