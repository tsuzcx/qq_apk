package com.tencent.mobileqq.profile.view.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import eak;
import eal;

public class HeartRiseLayerDrawable
  extends LayerDrawable
{
  public HeartRiseLayerDrawable(int paramInt, Resources paramResources)
  {
    super(eal.a(paramInt, paramResources, a(paramResources)));
  }
  
  public static Bitmap a(Resources paramResources)
  {
    Paint localPaint = new Paint();
    localPaint.setColor(paramResources.getColor(2131427408));
    Bitmap localBitmap = Bitmap.createBitmap(126, 126, Bitmap.Config.ARGB_4444);
    localBitmap.setDensity(paramResources.getDisplayMetrics().densityDpi);
    paramResources = new Canvas(localBitmap);
    paramResources.rotate(45.0F);
    paramResources.translate(0.0F, -88.0F);
    paramResources.drawRect(56, 56, 126, 126, localPaint);
    paramResources.drawCircle(56, 91, 35, localPaint);
    paramResources.drawCircle(91, 56, 35, localPaint);
    return localBitmap;
  }
  
  public void a(Handler paramHandler, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < getNumberOfLayers())
    {
      eak localeak = new eak(this, i, paramInt1, paramInt2);
      if (i % 2 == 0) {}
      for (long l = i * 200;; l = i * 130)
      {
        paramHandler.postDelayed(localeak, l);
        i += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.helper.HeartRiseLayerDrawable
 * JD-Core Version:    0.7.0.1
 */