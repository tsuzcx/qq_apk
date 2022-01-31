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

public final class bf
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
  
  public bf(Activity paramActivity)
  {
    this.b = BitmapFactory.decodeResource(paramActivity.getResources(), 2130837842);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.d = localDisplayMetrics.density;
    this.f = (286.0F * this.d);
    this.g = (442.0F * this.d);
    this.h = (this.f / 100.0F);
    this.a.setColor(paramActivity.getResources().getColor(2131165311));
    this.a.setAntiAlias(true);
    this.a.setFilterBitmap(true);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    this.e %= 100;
    if (this.e != 99)
    {
      float f1 = this.h;
      float f2 = this.e;
      paramCanvas.drawBitmap(this.b, 0.0F, f1 * f2, this.a);
    }
    for (;;)
    {
      this.e += 1;
      invalidateSelf();
      return;
      paramCanvas.drawBitmap(this.b, 0.0F, this.f - this.b.getHeight(), this.a);
    }
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bf
 * JD-Core Version:    0.7.0.1
 */