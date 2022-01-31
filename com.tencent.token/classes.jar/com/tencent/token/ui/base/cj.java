package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.token.utils.t;

public final class cj
  extends Drawable
{
  private Paint a = new Paint();
  private int b;
  private int[] c = new int[3];
  private Rect d;
  private Bitmap e;
  private Bitmap f;
  private String[] g;
  private int[] h;
  
  public cj(Context paramContext, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.b = paramContext.getResources().getColor(2131165205);
    int i = 2131165290;
    int j = 0;
    while (j < this.c.length)
    {
      this.c[j] = paramContext.getResources().getColor(i);
      j += 1;
      i += 1;
    }
    this.e = t.a(paramContext.getResources(), 2130837678);
    this.f = t.a(paramContext.getResources(), 2130837678, 0.85F, 0.85F);
    e.a("logincity width= " + this.e.getWidth() + ", height=" + this.e.getHeight());
    if (paramArrayOfString != null)
    {
      this.g = new String[paramArrayOfString.length];
      i = 0;
      if (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].length() > 4) {
          this.g[i] = (paramArrayOfString[i].substring(0, 4) + "...");
        }
        for (;;)
        {
          i += 1;
          break;
          this.g[i] = paramArrayOfString[i];
        }
      }
    }
    if (paramArrayOfInt != null)
    {
      this.h = new int[paramArrayOfInt.length];
      i = k;
      while (i < paramArrayOfInt.length)
      {
        this.h[i] = paramArrayOfInt[i];
        i += 1;
      }
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((this.g == null) || (this.h == null) || (this.g.length != this.h.length) || (this.g.length > 3) || (this.e == null) || (this.f == null)) {
      return;
    }
    float f1 = IndexActivity.S_DENSITY / 3.0F;
    int j = this.d.width() / 2;
    int i = this.d.height() / 2 - (int)(78.0F * f1);
    this.a.setAntiAlias(true);
    int n;
    if (this.g.length == 3)
    {
      k = (int)(j - this.e.getWidth() / 2 - this.f.getWidth() + 50.0F * f1);
      m = (int)(i - 172.0F * f1);
      paramCanvas.drawBitmap(this.f, k, m, this.a);
      f2 = 109.0F * f1;
      k = (int)(k + 139.0F * f1);
      m = (int)(m + 139.0F * f1);
      localRectF = new RectF(k - f2, m - f2, k + f2, m + f2);
      this.a.setStyle(Paint.Style.FILL);
      this.a.setColor(this.c[2]);
      paramCanvas.drawArc(localRectF, 0.0F, 360.0F, true, this.a);
      this.a.setColor(-1);
      this.a.setTextSize(43.0F * f1);
      this.a.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(this.g[2], k, m - this.a.descent(), this.a);
      this.a.setTextSize(43.0F * f1);
      this.a.setTextAlign(Paint.Align.LEFT);
      n = (int)this.a.measureText("" + this.h[2]);
      float f3 = this.a.getFontMetrics().ascent;
      paramCanvas.drawText("" + this.h[2], k - n, m - f3, this.a);
      this.a.setTextSize(40.0F * f1);
      paramCanvas.drawText("次", k, m - f3, this.a);
      k = (int)(this.e.getWidth() / 2 + j - 45.0F * f1);
      m = (int)(i - 172.0F * f1);
      paramCanvas.drawBitmap(this.f, k, m, this.a);
      k = (int)(k + 139.0F * f1);
      m = (int)(m + 139.0F * f1);
      localRectF = new RectF(k - f2, m - f2, k + f2, m + f2);
      this.a.setStyle(Paint.Style.FILL);
      this.a.setColor(this.c[1]);
      paramCanvas.drawArc(localRectF, 0.0F, 360.0F, true, this.a);
      this.a.setColor(-1);
      this.a.setTextSize(43.0F * f1);
      this.a.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(this.g[1], k, m - this.a.descent(), this.a);
      this.a.setTextSize(43.0F * f1);
      this.a.setTextAlign(Paint.Align.LEFT);
      n = (int)this.a.measureText("" + this.h[1]);
      f2 = this.a.getFontMetrics().ascent;
      paramCanvas.drawText("" + this.h[1], k - n, m - f2, this.a);
      this.a.setTextSize(40.0F * f1);
      paramCanvas.drawText("次", k, m - f2, this.a);
      k = this.e.getWidth() / 2;
      m = (int)(i - 162.0F * f1);
      paramCanvas.drawBitmap(this.e, j - k, m, this.a);
      f2 = 125.0F * f1;
      localRectF = new RectF(j - f2, i - f2, j + f2, f2 + i);
      this.a.setStyle(Paint.Style.FILL);
      this.a.setColor(this.c[0]);
      paramCanvas.drawArc(localRectF, 0.0F, 360.0F, true, this.a);
      this.a.setColor(-1);
      this.a.setTextSize(50.0F * f1);
      this.a.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(this.g[0], j, i - this.a.descent(), this.a);
      this.a.setTextSize(50.0F * f1);
      this.a.setTextAlign(Paint.Align.LEFT);
      k = (int)this.a.measureText("" + this.h[0]);
      f2 = this.a.getFontMetrics().ascent;
      paramCanvas.drawText("" + this.h[0], j - k, i - f2, this.a);
      this.a.setTextSize(45.0F * f1);
      paramCanvas.drawText("次", j, i - f2, this.a);
      return;
    }
    if (this.g.length == 2)
    {
      j -= (int)((this.f.getWidth() - 50.0F * f1) / 2.0F);
      k = (int)(this.e.getWidth() / 2 + j - 45.0F * f1);
      m = (int)(i - 172.0F * f1);
      paramCanvas.drawBitmap(this.f, k, m, this.a);
      f2 = 109.0F * f1;
      k = (int)(k + 139.0F * f1);
      m = (int)(m + 139.0F * f1);
      localRectF = new RectF(k - f2, m - f2, k + f2, f2 + m);
      this.a.setStyle(Paint.Style.FILL);
      this.a.setColor(this.c[1]);
      paramCanvas.drawArc(localRectF, 0.0F, 360.0F, true, this.a);
      this.a.setColor(-1);
      this.a.setTextSize(43.0F * f1);
      this.a.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(this.g[1], k, m - this.a.descent(), this.a);
      this.a.setTextSize(43.0F * f1);
      this.a.setTextAlign(Paint.Align.LEFT);
      n = (int)this.a.measureText("" + this.h[1]);
      f2 = this.a.getFontMetrics().ascent;
      paramCanvas.drawText("" + this.h[1], k - n, m - f2, this.a);
      this.a.setTextSize(40.0F * f1);
      paramCanvas.drawText("次", k, m - f2, this.a);
      k = this.e.getWidth() / 2;
      m = (int)(i - 162.0F * f1);
      paramCanvas.drawBitmap(this.e, j - k, m, this.a);
      f2 = 125.0F * f1;
      localRectF = new RectF(j - f2, i - f2, j + f2, f2 + i);
      this.a.setStyle(Paint.Style.FILL);
      this.a.setColor(this.c[0]);
      paramCanvas.drawArc(localRectF, 0.0F, 360.0F, true, this.a);
      this.a.setColor(-1);
      this.a.setTextSize(50.0F * f1);
      this.a.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(this.g[0], j, i - this.a.descent(), this.a);
      this.a.setTextSize(50.0F * f1);
      this.a.setTextAlign(Paint.Align.LEFT);
      k = (int)this.a.measureText("" + this.h[0]);
      f2 = this.a.getFontMetrics().ascent;
      paramCanvas.drawText("" + this.h[0], j - k, i - f2, this.a);
      this.a.setTextSize(45.0F * f1);
      paramCanvas.drawText("次", j, i - f2, this.a);
      return;
    }
    int k = this.e.getWidth() / 2;
    int m = (int)(i - 162.0F * f1);
    paramCanvas.drawBitmap(this.e, j - k, m, this.a);
    float f2 = 125.0F * f1;
    RectF localRectF = new RectF(j - f2, i - f2, j + f2, f2 + i);
    this.a.setStyle(Paint.Style.FILL);
    this.a.setColor(this.c[0]);
    paramCanvas.drawArc(localRectF, 0.0F, 360.0F, true, this.a);
    this.a.setColor(-1);
    this.a.setTextSize(50.0F * f1);
    this.a.setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawText(this.g[0], j, i - this.a.descent(), this.a);
    this.a.setTextSize(50.0F * f1);
    this.a.setTextAlign(Paint.Align.LEFT);
    k = (int)this.a.measureText("" + this.h[0]);
    f2 = this.a.getFontMetrics().ascent;
    paramCanvas.drawText("" + this.h[0], j - k, i - f2, this.a);
    this.a.setTextSize(45.0F * f1);
    paramCanvas.drawText("次", j, i - f2, this.a);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    e.a("logintimedrawable left=" + paramInt1 + ",top=" + paramInt2 + ", right=" + paramInt3 + ", bottom=" + paramInt4);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cj
 * JD-Core Version:    0.7.0.1
 */