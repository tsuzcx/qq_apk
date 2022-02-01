package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public final class yr
  extends Drawable
{
  public boolean a;
  public float b;
  private int c;
  private int d;
  private Paint e = new Paint();
  private RectF f;
  private RectF g;
  private float h;
  
  public yr(Context paramContext)
  {
    this.c = paramContext.getResources().getColor(2130968665);
    this.d = paramContext.getResources().getColor(2130968669);
    this.f = new RectF();
    this.g = new RectF();
  }
  
  public final void a()
  {
    this.b = 0.0F;
    this.a = false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    this.e.setColor(this.c);
    this.e.setStyle(Paint.Style.FILL);
    paramCanvas.drawRoundRect(this.f, 5.0F, 5.0F, this.e);
    if (!this.a)
    {
      double d1 = this.b;
      Double.isNaN(d1);
      this.b = ((float)(d1 + 0.15D));
      if (this.b > 80.0F) {
        this.b = 80.0F;
      }
    }
    else
    {
      this.b += 5.0F;
    }
    if (this.b >= 100.0F) {
      this.b = 100.0F;
    }
    this.g.set(this.f.left, this.f.top, this.f.left + this.h * this.b, this.f.bottom);
    this.e.setColor(this.d);
    paramCanvas.drawRoundRect(this.g, 5.0F, 5.0F, this.e);
    invalidateSelf();
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.f.set(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = (this.f.width() / 100.0F);
    StringBuilder localStringBuilder = new StringBuilder("setBounds rect=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",clipRect=");
    localStringBuilder.append(this.g);
    xa.c(localStringBuilder.toString());
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yr
 * JD-Core Version:    0.7.0.1
 */