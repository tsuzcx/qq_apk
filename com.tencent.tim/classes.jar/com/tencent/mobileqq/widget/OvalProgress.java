package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

public class OvalProgress
  extends RelativeLayout
{
  public float BI;
  private float BJ = -1.0F;
  private float BK = -1.0F;
  private a a;
  private RectF bb;
  private RectF bc;
  private RectF bd;
  private RectF be;
  private RectF bf;
  private RectF bg;
  private RectF bh;
  private RectF bi;
  private Paint cA;
  private Paint cB;
  private Paint cC;
  private Paint cD;
  private Paint cz;
  private int egN = -3355444;
  private int egO = -16745985;
  private double progress;
  private boolean showRedPoint;
  
  public OvalProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public OvalProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OvalProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private double a(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int j = 90;
    if (this.a.df > 0.0D) {}
    for (int i = (int)(1.0D * paramDouble * 90 / this.a.df);; i = 0)
    {
      if (i > 90) {
        i = j;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.bh, 180.0F, i, false, this.cC);
        return paramDouble - this.a.df;
      }
    }
  }
  
  private double b(Canvas paramCanvas, double paramDouble)
  {
    double d2 = 1.0D;
    double d1 = 0.0D;
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    if (this.a.dg > 0.0D) {
      d1 = paramDouble / this.a.dg;
    }
    if (d1 > 1.0D) {
      d1 = d2;
    }
    for (;;)
    {
      float f = (float)(d1 * (this.bf.right - this.bf.left));
      paramCanvas.drawRect(this.bf.left, this.bf.top, this.bf.left + f, this.bf.bottom, this.cA);
      return paramDouble - this.a.dg;
    }
  }
  
  private void bw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(this.bb, this.cz);
    paramCanvas.drawRect(this.bc, this.cz);
    paramCanvas.drawArc(this.bd, 90.0F, 180.0F, false, this.cB);
    paramCanvas.drawArc(this.be, 270.0F, 180.0F, false, this.cB);
    e(paramCanvas, d(paramCanvas, c(paramCanvas, b(paramCanvas, a(paramCanvas, this.progress)))));
  }
  
  private double c(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int j = 180;
    if (this.a.dh > 0.0D) {}
    for (int i = (int)(1.0D * paramDouble * '´' / this.a.dh);; i = 0)
    {
      if (i > 180) {
        i = j;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.bi, 270.0F, i, false, this.cC);
        return paramDouble - this.a.dh;
      }
    }
  }
  
  private boolean checkParams()
  {
    int i = getWidth();
    int j = getHeight();
    if ((i <= 0) && (j <= 0)) {
      return false;
    }
    if (this.BI <= 0.0F) {
      this.BI = (getResources().getDisplayMetrics().density * 4.0F / 2.0F);
    }
    if ((this.cz == null) || (this.cA == null))
    {
      this.cz = new Paint();
      this.cz.setAntiAlias(true);
      this.cz.setColor(this.egN);
      this.cz.setStrokeWidth(2.0F);
      this.cA = new Paint();
      this.cA.setAntiAlias(true);
      this.cA.setColor(this.egO);
      this.cA.setStrokeWidth(2.0F);
    }
    if ((this.bd == null) || (this.be == null) || (this.bh == null) || (this.bi == null) || (this.cB == null) || (this.cC == null))
    {
      this.cB = new Paint();
      this.cB.setAntiAlias(true);
      this.cB.setColor(this.egN);
      this.cB.setStrokeWidth(2.0F);
      this.cB.setStyle(Paint.Style.STROKE);
      this.cC = new Paint();
      this.cC.setAntiAlias(true);
      this.cC.setColor(this.egO);
      this.cC.setStrokeWidth(2.0F);
      this.cC.setStyle(Paint.Style.STROKE);
      this.bd = new RectF();
      this.bd.left = 1.0F;
      this.bd.right = (this.bd.left + j - 2.0F);
      this.bd.top = 1.0F;
      this.bd.bottom = (j - 1);
      this.be = new RectF();
      this.be.left = (i - 1 - (j - 2));
      this.be.right = (i - 1);
      this.be.top = 1.0F;
      this.be.bottom = (j - 1);
      this.bh = new RectF();
      this.bh.left = 1.0F;
      this.bh.right = (this.bh.left + j - 2.0F);
      this.bh.top = 1.0F;
      this.bh.bottom = (j - 1);
      this.bi = new RectF();
      this.bi.left = (i - 1 - (j - 2));
      this.bi.right = (i - 1);
      this.bi.top = 1.0F;
      this.bi.bottom = (j - 1);
    }
    float f1 = i - j;
    if ((this.bb == null) || (this.bc == null) || (this.bf == null) || (this.bg == null))
    {
      this.bb = new RectF();
      this.bb.left = ((float)((i - f1) * 1.0D / 2.0D - 0.5D));
      this.bb.right = ((float)(this.bb.left + f1 + 0.5D + 0.5D));
      this.bb.top = 0.0F;
      this.bb.bottom = 2.0F;
      this.bc = new RectF();
      this.bc.left = this.bb.left;
      this.bc.right = this.bb.right;
      this.bc.top = (j - 2);
      this.bc.bottom = j;
      this.bf = new RectF();
      this.bf.left = this.bb.left;
      this.bf.right = this.bb.right;
      this.bf.top = 0.0F;
      this.bf.bottom = 2.0F;
      this.bg = new RectF();
      this.bg.left = this.bf.left;
      this.bg.right = this.bf.right;
      this.bg.top = (j - 2);
      this.bg.bottom = j;
    }
    double d1;
    if ((this.cD == null) || (this.BJ == -1.0F) || (this.BK == -1.0F))
    {
      this.cD = new Paint();
      this.cD.setAntiAlias(true);
      this.cD.setColor(-65536);
      d1 = (j - 2) / 2 / 1.4142135623731D;
      float f2 = (this.be.left + this.be.right) / 2.0F;
      float f3 = (this.be.top + this.be.bottom) / 2.0F;
      this.BJ = ((float)(f2 + d1));
      this.BK = ((float)(f3 - d1));
    }
    if (this.a == null)
    {
      d1 = (j - 2) * 3.141592653589793D;
      double d2 = 2.0F * f1 + d1;
      this.a = new a();
      this.a.df = (0.25D * d1 / d2);
      this.a.dg = (f1 * 1.0D / d2);
      this.a.dh = (0.5D * d1 / d2);
      this.a.di = (f1 * 1.0D / d2);
      this.a.dj = (d1 * 0.25D / d2);
    }
    return true;
  }
  
  private double d(Canvas paramCanvas, double paramDouble)
  {
    double d1 = 0.0D;
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    if (this.a.di > 0.0D) {
      d1 = paramDouble / this.a.di;
    }
    double d2 = d1;
    if (d1 > 1.0D) {
      d2 = 1.0D;
    }
    float f = (float)((1.0D - d2) * (this.bg.right - this.bg.left));
    paramCanvas.drawRect(this.bg.left + f, this.bg.top, this.bg.right, this.bg.bottom, this.cA);
    return paramDouble - this.a.di;
  }
  
  private double e(Canvas paramCanvas, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    int j = 90;
    int i;
    if (this.a.dj > 0.0D) {
      if (paramDouble > this.a.dj * 0.99D) {
        i = 90;
      }
    }
    for (;;)
    {
      if (i > 90) {
        i = j;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.bh, 90.0F, i, false, this.cC);
        return paramDouble - this.a.dj;
        i = (int)(1.0D * paramDouble * 90 / this.a.dj);
        break;
      }
      i = 0;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (checkParams())
    {
      bw(paramCanvas);
      if (this.showRedPoint) {
        paramCanvas.drawCircle(this.BJ, this.BK, 4.0F, this.cD);
      }
    }
  }
  
  public void setProgressParams(long paramLong1, long paramLong2)
  {
    if ((paramLong1 <= 0L) || (paramLong2 < 0L)) {
      this.progress = 0.0D;
    }
    for (;;)
    {
      postInvalidate();
      return;
      if (paramLong2 > paramLong1)
      {
        this.showRedPoint = false;
        this.progress = 1.0D;
      }
      else
      {
        this.showRedPoint = false;
        this.progress = (paramLong2 * 1.0D / paramLong1);
      }
    }
  }
  
  public void setThemeColor(int paramInt1, int paramInt2)
  {
    this.egN = paramInt1;
    this.egO = paramInt2;
  }
  
  class a
  {
    double df;
    double dg;
    double dh;
    double di;
    double dj;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OvalProgress
 * JD-Core Version:    0.7.0.1
 */