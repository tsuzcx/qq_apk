package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.token.cc;
import com.tencent.token.ui.IndexActivity;

public class a
  extends Drawable
{
  public boolean a = true;
  private Paint b;
  private float c;
  private float d;
  
  public a(Context paramContext)
  {
    float f1 = IndexActivity.S_RES_WIDTH - paramContext.getResources().getDimension(2131034278);
    float f2 = paramContext.getResources().getDimension(2131034277);
    if (f1 > f2) {
      f1 = f2;
    }
    this.c = f1;
    this.d = (IndexActivity.S_DENSITY * 3.5F);
    this.b = new Paint();
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(-1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis() + cc.c().q();
    float f1 = (int)(l / 1000L) % 30 * 1000 + (int)(l % 1000L);
    float f2 = this.c;
    paramCanvas.drawRect(f1 * f2 / 30000.0F, 0.0F, f2 + 3.0F, this.d, this.b);
    if (this.a) {
      invalidateSelf();
    }
  }
  
  public int getOpacity()
  {
    return -1;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.a
 * JD-Core Version:    0.7.0.1
 */