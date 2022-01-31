package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class RegionalThumbDecoder
  implements BitmapDecoder
{
  @TargetApi(10)
  public Bitmap a(URL paramURL)
  {
    LocalPhotoInfo localLocalPhotoInfo = LocalPhotoInfo.a(paramURL);
    if (localLocalPhotoInfo != null) {
      do
      {
        do
        {
          for (;;)
          {
            try
            {
              paramURL = new BitmapFactory.Options();
              paramURL.inJustDecodeBounds = true;
              BitmapFactory.decodeFile(localLocalPhotoInfo.a, paramURL);
              if (paramURL.outWidth > paramURL.outHeight)
              {
                i = paramURL.outHeight;
                f = paramURL.outWidth / paramURL.outHeight;
                if (f > 3.0F) {
                  continue;
                }
                paramURL.inSampleSize = ThumbDecoder.a(paramURL.outWidth, paramURL.outHeight, localLocalPhotoInfo.f);
                paramURL.inJustDecodeBounds = false;
                paramURL.inPreferredConfig = Bitmap.Config.RGB_565;
                paramURL = BitmapFactory.decodeFile(localLocalPhotoInfo.a, paramURL);
                if (paramURL != null) {
                  continue;
                }
                localObject1 = paramURL;
              }
              try
              {
                if (QLog.isColorLevel())
                {
                  QLog.e("RegionalThumbDecoder", 2, "decode bitmap return null,maybe oom");
                  localObject1 = paramURL;
                }
                return localObject1;
              }
              catch (Throwable localThrowable1) {}
              i = paramURL.outWidth;
              float f = paramURL.outHeight / paramURL.outWidth;
              continue;
              localObject2 = new Rect(0, 0, i, i);
              paramURL.inSampleSize = ThumbDecoder.a(i, i, localLocalPhotoInfo.f);
              paramURL.inJustDecodeBounds = false;
              paramURL.inPreferredConfig = Bitmap.Config.RGB_565;
              localObject1 = BitmapRegionDecoder.newInstance(localLocalPhotoInfo.a, true);
              paramURL = ((BitmapRegionDecoder)localObject1).decodeRegion((Rect)localObject2, paramURL);
            }
            catch (Throwable localThrowable2)
            {
              int i;
              Object localObject1;
              Object localObject2;
              int j;
              int k;
              URL localURL;
              paramURL = null;
              continue;
            }
            try
            {
              ((BitmapRegionDecoder)localObject1).recycle();
            }
            catch (Throwable localThrowable3) {}
          }
          i = ThumbDecoder.a(localLocalPhotoInfo.a);
          if ((i != 0) || (paramURL.getWidth() != localLocalPhotoInfo.f)) {
            break;
          }
          localObject1 = paramURL;
        } while (paramURL.getHeight() == localLocalPhotoInfo.f);
        j = paramURL.getWidth();
        k = paramURL.getHeight();
        localObject1 = new Rect();
        localObject2 = new RectF(0.0F, 0.0F, localLocalPhotoInfo.f, localLocalPhotoInfo.f);
        if (j > k)
        {
          j = (j - k) / 2;
          ((Rect)localObject1).set(j, 0, j + k, k + 0);
        }
        for (;;)
        {
          Bitmap localBitmap = Bitmap.createBitmap(localLocalPhotoInfo.f, localLocalPhotoInfo.f, Bitmap.Config.RGB_565);
          Canvas localCanvas = new Canvas(localBitmap);
          if (i != 0) {
            localCanvas.rotate(i, localLocalPhotoInfo.f / 2.0F, localLocalPhotoInfo.f / 2.0F);
          }
          localCanvas.drawBitmap(paramURL, (Rect)localObject1, (RectF)localObject2, new Paint(6));
          if (localBitmap == null) {
            break;
          }
          paramURL.recycle();
          return localBitmap;
          k = (k - j) / 2;
          ((Rect)localObject1).set(0, k, 0 + j, j + k);
        }
        if (QLog.isColorLevel()) {
          QLog.e("RegionalThumbDecoder", 2, "can't getBitmap", localThrowable1);
        }
        localURL = paramURL;
      } while (paramURL != null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.RegionalThumbDecoder
 * JD-Core Version:    0.7.0.1
 */