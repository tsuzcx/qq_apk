package com.tencent.netdemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

public class SimpleView
  extends View
{
  public static final int ORI_FLIP_HOR = 2;
  public static final int ORI_FLIP_VERT = 4;
  public static final int ORI_NORMAL = 1;
  public static final int ORI_ROTATE_180 = 3;
  public static final int ORI_ROTATE_270 = 8;
  public static final int ORI_ROTATE_90 = 6;
  public static final int ORI_TRANSPOSE = 5;
  public static final int ORI_TRANSVERSE = 7;
  Drawable d;
  Drawable d2;
  Paint p;
  
  public SimpleView(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext.getResources().getDrawable(2130837508);
    paramContext = new BitmapDrawable(orientBitmap(BitmapFactory.decodeResource(getResources(), 2130837508), 5));
    paramContext.setTargetDensity(240);
    this.d2 = paramContext;
    paramContext.getIntrinsicHeight();
    this.p = new Paint();
    this.p.setStrokeWidth(10.0F);
    this.p.setColor(-65536);
  }
  
  public static Bitmap orientBitmap(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    int i = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int m;
    int j;
    if ((paramInt != 6) && (paramInt != 8) && (paramInt != 5))
    {
      m = k;
      j = i;
      if (paramInt != 7) {}
    }
    else
    {
      j = k;
      m = i;
    }
    switch (paramInt)
    {
    default: 
      return paramBitmap;
    case 6: 
      localMatrix.setRotate(90.0F, j / 2.0F, m / 2.0F);
    }
    for (;;)
    {
      return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      localMatrix.setRotate(180.0F, j / 2.0F, m / 2.0F);
      continue;
      localMatrix.setRotate(270.0F, j / 2.0F, m / 2.0F);
      continue;
      localMatrix.preScale(-1.0F, 1.0F);
      continue;
      localMatrix.preScale(1.0F, -1.0F);
      continue;
      localMatrix.setRotate(90.0F, j / 2.0F, m / 2.0F);
      localMatrix.preScale(1.0F, -1.0F);
      continue;
      localMatrix.setRotate(270.0F, j / 2.0F, m / 2.0F);
      localMatrix.preScale(1.0F, -1.0F);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawColor(-1);
    Rect localRect = new Rect(0, 0, this.d2.getIntrinsicWidth(), this.d2.getIntrinsicHeight());
    this.d2.setBounds(localRect);
    this.d2.draw(paramCanvas);
    int i = paramCanvas.save();
    paramCanvas.translate(0.0F, this.d2.getIntrinsicHeight() + 10);
    localRect = new Rect(0, 0, 480, 640);
    this.d.setBounds(localRect);
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-localRect.centerX(), -localRect.centerY());
    localMatrix.postScale(1.0F, -1.0F);
    localMatrix.postRotate(90.0F);
    localMatrix.postTranslate(localRect.centerY(), localRect.centerX());
    paramCanvas.concat(localMatrix);
    this.d.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.netdemo.SimpleView
 * JD-Core Version:    0.7.0.1
 */