package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class e
  extends Drawable
{
  private Paint a = new Paint();
  private Bitmap b;
  private final int c = 100;
  private float d;
  private int e = 0;
  private float f;
  private float g;
  private float h;
  
  public e(Activity paramActivity)
  {
    this.b = BitmapFactory.decodeResource(paramActivity.getResources(), 2131100062);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.d = localDisplayMetrics.density;
    float f1 = this.d;
    this.f = (286.0F * f1);
    this.g = (f1 * 442.0F);
    this.h = (this.f / 100.0F);
    this.a.setColor(paramActivity.getResources().getColor(2130968740));
    this.a.setAntiAlias(true);
    this.a.setFilterBitmap(true);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.e %= 100;
    int i = this.e;
    if (i != 99)
    {
      float f1 = this.h;
      float f2 = i;
      paramCanvas.drawBitmap(this.b, 0.0F, f1 * f2, this.a);
    }
    else
    {
      Bitmap localBitmap = this.b;
      paramCanvas.drawBitmap(localBitmap, 0.0F, this.f - localBitmap.getHeight(), this.a);
    }
    this.e += 1;
    invalidateSelf();
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.e
 * JD-Core Version:    0.7.0.1
 */