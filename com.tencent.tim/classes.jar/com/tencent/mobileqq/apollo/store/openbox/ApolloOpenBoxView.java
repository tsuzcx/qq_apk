package com.tencent.mobileqq.apollo.store.openbox;

import abuh;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class ApolloOpenBoxView
  extends View
{
  private abuh a;
  private Rect ar;
  private int csA;
  private int csB;
  private int csC;
  private int csD;
  private int csE;
  private int csF;
  private int csG;
  private int csH;
  private int csI;
  private int csJ;
  private int csK;
  private int csL;
  private int csx = 0;
  private int csy;
  private int csz;
  private Drawable es;
  private Drawable et;
  private Drawable eu;
  private int mHeight;
  private int mWidth;
  private long wS;
  
  public ApolloOpenBoxView(Context paramContext, abuh paramabuh)
  {
    super(paramContext);
    init();
    this.a = paramabuh;
  }
  
  public ApolloOpenBoxView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.es = getResources().getDrawable(2130838542);
    this.et = getResources().getDrawable(2130838541);
    this.eu = getResources().getDrawable(2130838540);
    int i = this.eu.getIntrinsicWidth() >> 1;
    int j = this.eu.getIntrinsicHeight() >> 1;
    this.eu.setBounds(-i, -j, i, j);
    this.ar = new Rect();
    i = this.es.getIntrinsicWidth();
    int n = this.es.getIntrinsicHeight();
    j = this.et.getIntrinsicWidth();
    int k = this.et.getIntrinsicHeight();
    int m = -(n + k) >> 1;
    n += m;
    this.es.setBounds(-i >> 1, m, i >> 1, n);
    this.et.setBounds(-j >> 1, n, j >> 1, k + n);
  }
  
  public void cFx()
  {
    this.csx = 4;
    this.wS = System.currentTimeMillis();
    super.invalidate();
    if (this.a != null) {
      this.a.aC(this.csx, this.csG, this.csH);
    }
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 1.0F;
    super.onDraw(paramCanvas);
    paramCanvas.save();
    long l = System.currentTimeMillis();
    int k = 255;
    float f2;
    if (this.csx == 1)
    {
      f2 = (float)(l - this.wS) / 200.0F;
      if (f2 <= 1.0F) {
        break label1110;
      }
      this.wS = l;
      this.csx = 2;
    }
    for (;;)
    {
      int i = (int)(this.csy + (this.csA - this.csy) * f1);
      f2 = this.csz;
      int j = (int)(f1 * (this.csB - this.csz) + f2);
      this.ar.set(i - this.eu.getIntrinsicWidth() / 10, j - this.eu.getIntrinsicHeight() / 10, this.eu.getIntrinsicWidth() / 10 + i, this.eu.getIntrinsicHeight() / 10 + j);
      paramCanvas.clipRect(this.ar);
      paramCanvas.translate(i, j);
      paramCanvas.scale(0.2F, 0.2F);
      this.eu.setAlpha(255);
      this.eu.draw(paramCanvas);
      super.invalidate();
      paramCanvas.restore();
      if (QLog.isColorLevel()) {
        QLog.e("ApolloBoxView", 2, "onDaw use" + (System.currentTimeMillis() - l));
      }
      return;
      if (this.csx == 2)
      {
        f2 = (float)(l - this.wS) / 100.0F;
        if (f2 <= 1.0F) {
          break label1105;
        }
        this.csx = 3;
        this.wS = l;
      }
      for (;;)
      {
        i = (int)(this.csA + (this.csC - this.csA) * f1);
        j = (int)(this.csB + (this.csD - this.csB) * f1);
        f1 = f1 * 0.8F + 0.2F;
        this.ar.set((int)(i - this.eu.getIntrinsicWidth() / 2 * f1), (int)(j - this.eu.getIntrinsicHeight() / 2 * f1), (int)(i + this.eu.getIntrinsicWidth() / 2 * f1), (int)(j + this.eu.getIntrinsicHeight() / 2 * f1));
        paramCanvas.clipRect(this.ar);
        paramCanvas.translate(i, j);
        paramCanvas.scale(f1, f1);
        this.eu.setAlpha(255);
        this.eu.draw(paramCanvas);
        super.invalidate();
        break;
        if (this.csx == 3) {
          if ((float)(l - this.wS) > 400.0F)
          {
            f2 = ((float)(l - this.wS) - 400.0F) / 100.0F;
            if (f2 <= 1.0F) {
              break label1102;
            }
            this.csx = 4;
            this.wS = l;
            f2 = f1;
            if (this.a != null)
            {
              this.a.aC(this.csx, this.csG, this.csH);
              f2 = f1;
            }
          }
        }
        label1102:
        for (;;)
        {
          j = (int)(this.csE + (this.csG - this.csE) * f2);
          f1 = this.csF;
          for (i = (int)(f2 * (this.csH - this.csF) + f1);; i = (int)(f1 * (this.csF - this.csD) + f2))
          {
            this.ar.set(j - this.eu.getIntrinsicWidth() / 2, i - this.eu.getIntrinsicHeight() / 2, this.eu.getIntrinsicWidth() / 2 + j, this.eu.getIntrinsicHeight() / 2 + i);
            paramCanvas.clipRect(this.ar);
            paramCanvas.translate(j, i);
            this.eu.setAlpha(255);
            this.eu.draw(paramCanvas);
            super.invalidate();
            break;
            f1 = (float)(l - this.wS) / 400.0F;
            j = (int)(this.csC + (this.csE - this.csC) * f1);
            f2 = this.csD;
          }
          if (this.csx != 4) {
            break;
          }
          int m = this.csG;
          int n = this.csG;
          if ((float)(l - this.wS) > 450.0F)
          {
            f2 = ((float)(l - this.wS) - 150.0F - 300.0F) / 150.0F;
            f1 = f2;
            if (f2 > 1.0F)
            {
              this.csx = 0;
              this.wS = l;
              f1 = 1.0F;
            }
            k = (int)((1.0F - f1) * 255.0F);
            j = (int)(this.csH + this.csI + this.csK * f1);
            i = (int)(this.csH + this.csJ + f1 * this.csL);
          }
          for (;;)
          {
            this.ar.set(m - this.es.getIntrinsicWidth() / 2, j - this.es.getIntrinsicHeight(), this.es.getIntrinsicWidth() / 2 + m, this.es.getIntrinsicHeight() + i);
            paramCanvas.clipRect(this.ar);
            paramCanvas.translate(m, j);
            this.es.setAlpha(k);
            this.es.draw(paramCanvas);
            paramCanvas.translate(n - m, i - j);
            this.et.setAlpha(k);
            this.et.draw(paramCanvas);
            super.invalidate();
            break;
            if ((float)(l - this.wS) > 150.0F)
            {
              postInvalidateDelayed(300L);
              i = this.csH;
              j = this.csI + i;
              i = this.csH + this.csJ;
            }
            else
            {
              f1 = (float)(l - this.wS) / 150.0F;
              j = (int)(this.csH + this.csI * f1);
              f2 = this.csH;
              i = (int)(f1 * this.csJ + f2);
            }
          }
        }
        label1105:
        f1 = f2;
      }
      label1110:
      f1 = f2;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.mWidth) || (paramInt2 != this.mHeight))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.csy = ((int)(this.mWidth * 0.5F));
      this.csz = ((int)(0.57F * this.mHeight));
      this.csA = ((int)(this.mWidth * 0.5F));
      this.csB = ((int)(0.4F * this.mHeight));
      this.csC = ((int)(this.mWidth * 0.5F));
      this.csD = ((int)(0.494F * this.mHeight));
      this.csE = ((int)(this.mWidth * 0.5F));
      this.csF = ((int)(0.464F * this.mHeight));
      this.csG = ((int)(this.mWidth * 0.5F));
      this.csH = ((int)(0.521F * this.mHeight));
      this.csI = ((int)(-0.138F * this.mHeight));
      this.csJ = ((int)(0.066F * this.mHeight));
      this.csK = ((int)(-0.092F * this.mHeight));
      this.csL = ((int)(0.052F * this.mHeight));
    }
  }
  
  public void setDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    if (paramDrawable1 != null) {
      this.es = paramDrawable1;
    }
    if (paramDrawable2 != null) {
      this.et = paramDrawable2;
    }
    if (paramDrawable3 != null) {
      this.eu = paramDrawable3;
    }
    int i = this.es.getIntrinsicWidth();
    int n = this.es.getIntrinsicHeight();
    int j = this.et.getIntrinsicWidth();
    int k = this.et.getIntrinsicHeight();
    int m = -(n + k) >> 1;
    n += m;
    this.es.setBounds(-i >> 1, m, i >> 1, n);
    this.et.setBounds(-j >> 1, n, j >> 1, k + n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloOpenBoxView
 * JD-Core Version:    0.7.0.1
 */