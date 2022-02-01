package com.tencent.qqmail.qmui.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class QMUIDrawableHelper
{
  private static ColorMatrix mSaturationMatrix;
  private static final Canvas sCanvas = new Canvas();
  
  public static Bitmap createBitmapFromView(View paramView)
  {
    if ((paramView instanceof ImageView))
    {
      ??? = ((ImageView)paramView).getDrawable();
      if ((??? != null) && ((??? instanceof BitmapDrawable))) {
        ??? = ((BitmapDrawable)???).getBitmap();
      }
    }
    Bitmap localBitmap;
    do
    {
      return ???;
      paramView.clearFocus();
      localBitmap = createBitmapSafely(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888, 1);
      ??? = localBitmap;
    } while (localBitmap == null);
    synchronized (sCanvas)
    {
      Canvas localCanvas = sCanvas;
      localCanvas.setBitmap(localBitmap);
      paramView.draw(localCanvas);
      localCanvas.setBitmap(null);
      return localBitmap;
    }
  }
  
  public static Bitmap createBitmapSafely(int paramInt1, int paramInt2, Bitmap.Config paramConfig, int paramInt3)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      if (paramInt3 > 0)
      {
        System.gc();
        return createBitmapSafely(paramInt1, paramInt2, paramConfig, paramInt3 - 1);
      }
    }
    return null;
  }
  
  @Deprecated
  public static Bitmap createBitmapWithMaskColor(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j;
    int i;
    float f;
    label72:
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    label151:
    int k;
    if (mSaturationMatrix == null)
    {
      mSaturationMatrix = new ColorMatrix();
      mSaturationMatrix.setSaturation(0.0F);
      j = paramBitmap.getWidth();
      i = paramBitmap.getHeight();
      f = paramInt3 / paramInt4;
      if (f <= j / i) {
        break label247;
      }
      paramInt4 = (int)(paramInt4 / paramInt3 * j);
      paramInt3 = j;
      localBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColorFilter(new ColorMatrixColorFilter(mSaturationMatrix));
      localPaint.setAlpha(paramInt1);
      if (paramInt3 >= j) {
        break label262;
      }
      paramInt1 = (j - paramInt3) / 2;
      j = paramInt1;
      paramInt1 += paramInt3;
      if (paramInt4 >= i) {
        break label275;
      }
      k = (i - paramInt4) / 2;
      i = k + paramInt4;
    }
    for (;;)
    {
      localCanvas.drawBitmap(paramBitmap, new Rect(j, k, paramInt1, i), new Rect(0, 0, paramInt3, paramInt4), localPaint);
      localPaint.setColorFilter(null);
      localPaint.setColor(paramInt2);
      localCanvas.drawRect(0.0F, 0.0F, paramInt3, paramInt4, localPaint);
      return localBitmap;
      mSaturationMatrix.reset();
      break;
      label247:
      paramInt3 = (int)(f * i);
      paramInt4 = i;
      break label72;
      label262:
      k = 0;
      paramInt1 = j;
      j = k;
      break label151;
      label275:
      k = 0;
    }
  }
  
  public static Bitmap createCircleBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt2);
    localPaint.setStyle(Paint.Style.FILL);
    paramInt1 /= 2;
    localCanvas.drawCircle(paramInt1, paramInt1, paramInt1, localPaint);
    if (paramInt3 != 0)
    {
      localPaint.setColor(paramInt3);
      localPaint.setStyle(Paint.Style.STROKE);
      paramInt2 = QMUIDisplayHelper.dpToPx(1);
      localPaint.setStrokeWidth(paramInt2);
      localCanvas.drawCircle(paramInt1, paramInt1, paramInt1 - (int)(paramInt2 / 2 + 0.5D), localPaint);
    }
    return localBitmap;
  }
  
  public static BitmapDrawable createDrawableWithColor(Resources paramResources, int paramInt)
  {
    return createDrawableWithSize(paramResources, QMUIDisplayHelper.dpToPx(4), QMUIDisplayHelper.dpToPx(4), 0, paramInt);
  }
  
  public static BitmapDrawable createDrawableWithSize(Resources paramResources, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    int i = paramInt4;
    if (paramInt4 == 0) {
      i = 0;
    }
    if (paramInt3 > 0)
    {
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(i);
      localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, paramInt1, paramInt2), paramInt3, paramInt3, localPaint);
    }
    for (;;)
    {
      return new BitmapDrawable(paramResources, localBitmap);
      localCanvas.drawColor(i);
    }
  }
  
  public static BitmapDrawable createDrawableWithStroke(Resources paramResources, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    int i = paramInt5;
    if (paramInt5 == 0) {
      i = 0;
    }
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(i);
    localPaint.setStrokeWidth(paramInt4);
    if (paramInt3 > 0) {
      localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, paramInt1, paramInt2), paramInt3, paramInt3, localPaint);
    }
    for (;;)
    {
      return new BitmapDrawable(paramResources, localBitmap);
      localCanvas.drawRect(new RectF(0.0F, 0.0F, paramInt1, paramInt2), localPaint);
    }
  }
  
  public static BitmapDrawable createMergedDrawable(Resources paramResources, Drawable paramDrawable1, Drawable paramDrawable2, Point paramPoint)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable1.getBounds().width(), paramDrawable1.getBounds().height(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable1.setBounds(0, 0, paramDrawable1.getIntrinsicWidth(), paramDrawable1.getIntrinsicHeight());
    paramDrawable1.draw(localCanvas);
    localCanvas.translate(paramPoint.x, paramPoint.y);
    paramDrawable2.draw(localCanvas);
    return new BitmapDrawable(paramResources, localBitmap);
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    int i;
    int j;
    do
    {
      return null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i <= 0) || (j <= 0));
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight() + paramInt);
    RectF localRectF = new RectF(localRect);
    float f = paramInt;
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, f, f, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public static void setDrawableTintColor(Drawable paramDrawable, int paramInt)
  {
    paramDrawable.setColorFilter(new LightingColorFilter(Color.argb(255, 0, 0, 0), paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.helper.QMUIDrawableHelper
 * JD-Core Version:    0.7.0.1
 */