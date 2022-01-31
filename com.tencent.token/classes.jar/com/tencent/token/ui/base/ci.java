package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.token.global.e;
import com.tencent.token.ui.IndexActivity;

public final class ci
  extends Drawable
{
  private Paint a = new Paint();
  private Rect b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private String j;
  
  public ci(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.c = paramContext.getResources().getColor(2131165282);
    this.d = paramContext.getResources().getColor(2131165283);
    this.e = paramContext.getResources().getColor(2131165184);
    this.f = paramContext.getResources().getColor(2131165205);
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    this.j = paramString;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.h - this.g != 1) {
      return;
    }
    float f1 = IndexActivity.S_DENSITY / 3.0F;
    int m = this.b.width() / 2;
    int n = this.b.height() / 2 - (int)(64.0F * f1);
    int k = this.g % 12;
    int i1;
    Object localObject;
    if (k <= 2)
    {
      k = k * 30 + 270;
      i1 = (int)(240.0F * f1);
      localObject = new RectF(m - i1, n - i1, m + i1, i1 + n);
      this.a.reset();
      this.a.setStyle(Paint.Style.FILL);
      this.a.setColor(this.d);
      this.a.setAntiAlias(true);
      paramCanvas.drawArc((RectF)localObject, k, 30.0F, true, this.a);
      i1 = (int)(230.0F * f1);
      localObject = new RectF(m - i1, n - i1, m + i1, i1 + n);
      this.a.reset();
      this.a.setColor(this.c);
      this.a.setAntiAlias(true);
      this.a.setStyle(Paint.Style.FILL);
      if (k != 0) {
        break label844;
      }
      paramCanvas.drawArc((RectF)localObject, k + 32, 360 - (k + 34), true, this.a);
    }
    for (;;)
    {
      i1 = (int)(170.0F * f1);
      localObject = new RectF(m - i1, n - i1, m + i1, i1 + n);
      this.a.setColor(this.e);
      this.a.setAntiAlias(true);
      paramCanvas.drawArc((RectF)localObject, 0.0F, k, true, this.a);
      paramCanvas.drawArc((RectF)localObject, k + 30, 360 - (k + 30), true, this.a);
      k = (int)(88.0F * f1);
      localObject = new RectF(m - k, n - k, m + k, k + n);
      this.a.setColor(this.c);
      paramCanvas.drawArc((RectF)localObject, 0.0F, 360.0F, true, this.a);
      this.a.reset();
      this.a.setAntiAlias(true);
      this.a.setColor(this.f);
      this.a.setTextAlign(Paint.Align.CENTER);
      this.a.setTextSize(45.0F * f1);
      k = (int)this.a.getFontMetrics().ascent;
      this.a.getFontMetrics();
      i1 = (int)this.a.measureText("12:00");
      paramCanvas.drawText("12:00", m, n - 250.0F * f1, this.a);
      paramCanvas.drawText("06:00", m, n + 250.0F * f1 - k, this.a);
      this.a.setTextAlign(Paint.Align.LEFT);
      paramCanvas.drawText("09:00", m - 250.0F * f1 - i1, n - k / 2, this.a);
      paramCanvas.drawText("03:00", m + 250.0F * f1, n - k / 2, this.a);
      this.a.setTextAlign(Paint.Align.CENTER);
      this.a.setTextSize(50.0F * f1);
      this.a.setColor(this.d);
      paramCanvas.drawText(this.j, this.b.centerX(), this.b.bottom - 90.0F * f1, this.a);
      this.a.setTextSize(80.0F * f1);
      this.a.setColor(this.f);
      this.a.setTextAlign(Paint.Align.LEFT);
      localObject = "" + this.i;
      k = (int)this.a.measureText((String)localObject);
      i1 = (int)this.a.getFontMetrics().ascent;
      this.a.getFontMetrics();
      paramCanvas.drawText((String)localObject, m - k * 3 / 4, n - i1 / 2, this.a);
      this.a.setTextSize(50.0F * f1);
      paramCanvas.drawText("次", k * 1 / 4 + m, n - i1 * 2 / 5, this.a);
      return;
      k = (k - 3) * 30;
      break;
      label844:
      if (k == 330)
      {
        paramCanvas.drawArc((RectF)localObject, 2.0F, k - 4, true, this.a);
      }
      else
      {
        paramCanvas.drawArc((RectF)localObject, 0.0F, k - 2, true, this.a);
        paramCanvas.drawArc((RectF)localObject, k + 32, 360 - (k + 32), true, this.a);
      }
    }
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    e.a("logintimedrawable left=" + paramInt1 + ",top=" + paramInt2 + ", right=" + paramInt3 + ", bottom=" + paramInt4 + ", startTime=" + this.g);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ci
 * JD-Core Version:    0.7.0.1
 */