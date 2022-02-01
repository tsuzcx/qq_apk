package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import anpc;
import aoop;
import aoow;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SafeBitmapFactory.SafeDecodeOption;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;

public class ThumbDecoder
  implements aoow
{
  private static final String TAG = "ThumbDecoder";
  private float mDensity;
  private LocalMediaInfo mInfo;
  
  public ThumbDecoder(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.mInfo = paramLocalMediaInfo;
  }
  
  public static int calSampleSize(int paramInt1, int paramInt2, int paramInt3)
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
    return checkSquareLarge(paramInt1, paramInt2, paramInt3, j);
  }
  
  private static int checkSquareLarge(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = paramInt3 * paramInt3 * paramInt4 * paramInt4;
    while (paramInt1 * paramInt2 > paramInt3 * 4)
    {
      paramInt3 *= 4;
      paramInt4 *= 2;
    }
    return paramInt4;
  }
  
  public Bitmap getBitmap(URL paramURL)
  {
    LocalMediaInfo localLocalMediaInfo = this.mInfo;
    if (localLocalMediaInfo != null)
    {
      paramURL = new BitmapFactory.Options();
      paramURL.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(localLocalMediaInfo.path, paramURL);
      paramURL.inSampleSize = calSampleSize(paramURL.outWidth, paramURL.outHeight, localLocalMediaInfo.thumbWidth);
      paramURL.inJustDecodeBounds = false;
      Object localObject1 = null;
      label243:
      for (;;)
      {
        try
        {
          SafeBitmapFactory.SafeDecodeOption localSafeDecodeOption = new SafeBitmapFactory.SafeDecodeOption();
          localSafeDecodeOption.inOptions = paramURL;
          localSafeDecodeOption.inNeedFlashBackTest = true;
          paramURL = SafeBitmapFactory.safeDecode(localLocalMediaInfo.path, localSafeDecodeOption);
          boolean bool;
          long l;
          ((OutOfMemoryError)localObject1).printStackTrace();
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ThumbDecoder", 2, "ThumbDecoder regionDecodeInfo:" + localSafeDecodeOption.toString());
            }
            if ((!localSafeDecodeOption.isInJustDecodeBounds) && (localSafeDecodeOption.needRegionDecode))
            {
              localObject1 = localSafeDecodeOption.getInfo();
              ((HashMap)localObject1).put("from", "ThumbDecoder");
              localObject2 = anpc.a(BaseApplication.getContext());
              bool = localSafeDecodeOption.isGetBitmap;
              l = localSafeDecodeOption.runTime;
              i = localSafeDecodeOption.rawHeight;
              ((anpc)localObject2).collectPerformance(null, "safeDecode", bool, l, localSafeDecodeOption.rawWidth * i, (HashMap)localObject1, "");
            }
            if (paramURL != null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ThumbDecoder", 2, "decode bitmap return null,maybe oom");
            }
            return paramURL;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            Object localObject2;
            int i;
            int j;
            int k;
            Rect localRect;
            break label243;
          }
          localOutOfMemoryError2 = localOutOfMemoryError2;
          paramURL = (URL)localObject1;
          localObject1 = localOutOfMemoryError2;
        }
      }
      i = aoop.eI(localLocalMediaInfo.path);
      if ((i == 0) && (paramURL.getWidth() == localLocalMediaInfo.thumbWidth) && (paramURL.getHeight() == localLocalMediaInfo.thumbWidth) && (paramURL.getConfig() == Bitmap.Config.RGB_565)) {
        return paramURL;
      }
      j = paramURL.getWidth();
      k = paramURL.getHeight();
      localRect = new Rect();
      localObject2 = new RectF(0.0F, 0.0F, localLocalMediaInfo.thumbWidth, localLocalMediaInfo.thumbWidth);
      if (j > k)
      {
        j = (j - k) / 2;
        localRect.set(j, 0, j + k, k + 0);
      }
      for (;;)
      {
        localObject1 = Bitmap.createBitmap(localLocalMediaInfo.thumbWidth, localLocalMediaInfo.thumbWidth, Bitmap.Config.RGB_565);
        if (localObject1 == null) {
          break label464;
        }
        new Canvas((Bitmap)localObject1).drawBitmap(paramURL, localRect, (RectF)localObject2, new Paint(6));
        paramURL.recycle();
        paramURL = (URL)localObject1;
        if (i == 0) {
          break;
        }
        return FlowThumbDecoder.rotate((Bitmap)localObject1, i);
        k = (k - j) / 2;
        localRect.set(0, k, 0 + j, j + k);
      }
    }
    label464:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.ThumbDecoder
 * JD-Core Version:    0.7.0.1
 */