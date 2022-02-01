package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.token.global.g;

public class h
  extends Drawable
{
  private int a;
  private int b;
  private Paint c = new Paint();
  private RectF d;
  private RectF e;
  private boolean f;
  private float g;
  private float h;
  
  public h(Context paramContext)
  {
    this.a = paramContext.getResources().getColor(2130968665);
    this.b = paramContext.getResources().getColor(2130968669);
    this.d = new RectF();
    this.e = new RectF();
  }
  
  public void a()
  {
    this.f = true;
    this.g = 80.0F;
  }
  
  public void b()
  {
    this.g = 0.0F;
    this.f = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.c.setColor(this.a);
    this.c.setStyle(Paint.Style.FILL);
    paramCanvas.drawRoundRect(this.d, 5.0F, 5.0F, this.c);
    if (!this.f)
    {
      double d1 = this.g;
      Double.isNaN(d1);
      this.g = ((float)(d1 + 0.15D));
      if (this.g > 80.0F) {
        this.g = 80.0F;
      }
    }
    else
    {
      this.g += 5.0F;
    }
    if (this.g >= 100.0F) {
      this.g = 100.0F;
    }
    this.e.set(this.d.left, this.d.top, this.d.left + this.h * this.g, this.d.bottom);
    this.c.setColor(this.b);
    paramCanvas.drawRoundRect(this.e, 5.0F, 5.0F, this.c);
    invalidateSelf();
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d.set(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = (this.d.width() / 100.0F);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBounds rect=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",clipRect=");
    localStringBuilder.append(this.e);
    g.c(localStringBuilder.toString());
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.h
 * JD-Core Version:    0.7.0.1
 */