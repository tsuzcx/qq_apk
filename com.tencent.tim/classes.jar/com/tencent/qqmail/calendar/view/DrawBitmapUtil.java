package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class DrawBitmapUtil
{
  public static int CIRCLE_DIAMETER_NORMAL = 8;
  public static int CIRCLE_DIAMETER_SMALL = 5;
  private static SparseArray<Drawable> flags = new SparseArray();
  
  private static Bitmap createCircleBitmap(int paramInt1, int paramInt2, Paint.Style paramStyle)
  {
    if (paramStyle == Paint.Style.STROKE) {}
    Canvas localCanvas;
    Paint localPaint;
    for (Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt1 + 4, Bitmap.Config.ARGB_8888);; localBitmap = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888))
    {
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(paramInt2);
      localPaint.setStyle(paramStyle);
      paramInt1 /= 2;
      if (paramStyle != Paint.Style.STROKE) {
        break;
      }
      localPaint.setStrokeWidth(2.0F);
      localCanvas.drawCircle(paramInt1, paramInt1 + 4, paramInt1 - 1, localPaint);
      return localBitmap;
    }
    localCanvas.drawCircle(paramInt1, paramInt1, paramInt1, localPaint);
    return localBitmap;
  }
  
  private static Drawable createFlag(Context paramContext, int paramInt1, int paramInt2, Paint.Style paramStyle)
  {
    paramContext = new BitmapDrawable(paramContext.getResources(), createCircleBitmap(QMUIKit.dpToPx(paramInt2), paramInt1, paramStyle));
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
    return paramContext;
  }
  
  public static Drawable drawCircle(Context paramContext, int paramInt1, int paramInt2, Paint.Style paramStyle)
  {
    int i = paramStyle.ordinal();
    Drawable localDrawable2 = (Drawable)flags.get(((paramInt2 << 30) + paramInt1 << 2) + i);
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null)
    {
      localDrawable1 = createFlag(paramContext, paramInt1, paramInt2, paramStyle);
      flags.put(paramInt1, localDrawable1);
    }
    return localDrawable1;
  }
  
  public static Bitmap drawSquredIcon(Bitmap paramBitmap)
  {
    QMApplicationContext.sharedInstance();
    int i = (int)(30.0F * QMUIKit.DENSITY + 0.5D);
    Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Object localObject = new RectF(0.0F, 0.0F, i, i);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawRoundRect((RectF)localObject, QMUIKit.dpToPx(3), QMUIKit.dpToPx(3), localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, null, (RectF)localObject, localPaint);
    paramBitmap = new Rect(0, 0, i + 0, i + 0);
    localObject = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    new Canvas((Bitmap)localObject).drawBitmap(localBitmap, null, paramBitmap, null);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.DrawBitmapUtil
 * JD-Core Version:    0.7.0.1
 */