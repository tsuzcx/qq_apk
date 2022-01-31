package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.token.global.h;

public class cd
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
  
  public cd(Context paramContext)
  {
    this.a = paramContext.getResources().getColor(2131492933);
    this.b = paramContext.getResources().getColor(2131492937);
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
      this.g = ((float)(this.g + 0.15D));
      if (this.g <= 80.0F) {}
    }
    for (this.g = 80.0F;; this.g += 5.0F)
    {
      if (this.g >= 100.0F) {
        this.g = 100.0F;
      }
      this.e.set(this.d.left, this.d.top, this.d.left + this.h * this.g, this.d.bottom);
      this.c.setColor(this.b);
      paramCanvas.drawRoundRect(this.e, 5.0F, 5.0F, this.c);
      invalidateSelf();
      return;
    }
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
    h.c("setBounds rect=" + this.d + ",clipRect=" + this.e);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cd
 * JD-Core Version:    0.7.0.1
 */