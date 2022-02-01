package com.tencent.mobileqq.armap;

import acfp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import java.util.Random;
import wja;

public class ScanSuccessView
  extends View
{
  RectF aA = new RectF();
  RectF aB = new RectF();
  RectF aC = new RectF();
  RectF ay = new RectF();
  RectF az = new RectF();
  private Paint bL;
  private Paint bM;
  private Paint bN;
  private Paint bO;
  private Paint bP;
  private Paint bQ;
  boolean bQX = true;
  String bvE = acfp.m(2131714007);
  private int cKc;
  private int cKd;
  private int cKe = 70;
  private int cKf = 180;
  private int cKg = 10;
  private int cKh;
  private int cKi = 18;
  boolean isAdd = true;
  private float mRadius = 51.0F;
  private float mStrokeWidth = 10.0F;
  private Paint mTextPaint;
  private int mTotalProgress;
  private float scale = 1.6875F;
  private float vo;
  private float vp;
  private float vq;
  private float vr;
  private float vs;
  private float vt;
  private float vu;
  
  public ScanSuccessView(Context paramContext)
  {
    super(paramContext);
    cUx();
  }
  
  private void cUx()
  {
    this.vo = (this.mRadius + 4.0F + 6.0F);
    this.vr = (this.mRadius + 25.0F);
    this.vp = (this.mRadius + 36.0F);
    this.vq = (this.mRadius + this.mStrokeWidth / 2.0F + 47.0F);
    this.vs = (this.mRadius + 72.0F);
    this.bL = new Paint();
    this.bL.setAntiAlias(true);
    this.bL.setColor(2147483647);
    this.bL.setStyle(Paint.Style.FILL);
    this.bM = new Paint();
    this.bM.setAntiAlias(true);
    this.bM.setColor(-1);
    this.bM.setStyle(Paint.Style.STROKE);
    this.bM.setStrokeWidth(8.0F * this.scale);
    this.bN = new Paint();
    this.bN.setAntiAlias(true);
    this.bN.setColor(2147483647);
    this.bN.setStyle(Paint.Style.STROKE);
    this.bN.setStrokeWidth(2.0F);
    this.bO = new Paint();
    this.bO.setAntiAlias(true);
    this.bO.setColor(-1);
    this.bO.setStyle(Paint.Style.STROKE);
    this.bO.setStrokeWidth(this.scale * 6.0F);
    this.bP = new Paint();
    this.bP.setAntiAlias(true);
    this.bP.setColor(-1);
    this.bP.setStyle(Paint.Style.STROKE);
    this.bP.setStrokeWidth(16.0F * this.scale);
    this.mTextPaint = new Paint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setStyle(Paint.Style.FILL);
    this.mTextPaint.setARGB(255, 255, 255, 255);
    this.mTextPaint.setTextSize(28.0F * this.scale);
    this.bQ = new Paint();
    this.bQ.setAntiAlias(true);
    this.bQ.setStyle(Paint.Style.FILL);
    this.bQ.setARGB(255, 255, 255, 255);
    this.cKi = wja.dp2px(18.0F, getResources());
    this.bQ.setTextSize(this.cKi);
    Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
    this.vu = ((int)Math.ceil(localFontMetrics.descent - localFontMetrics.ascent));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.cKh % 10 == 9) {
      this.isAdd = false;
    }
    if (this.cKh % 10 == 0) {
      this.isAdd = true;
    }
    if (this.isAdd) {}
    for (this.cKh += 1;; this.cKh -= 1)
    {
      if (this.cKh % 2 == 0) {}
      this.cKc = (getWidth() / 2);
      this.cKd = (getHeight() / 2);
      this.ay.left = (this.cKc - this.vo * this.scale);
      this.ay.top = (this.cKd - this.vo * this.scale);
      this.ay.right = (this.cKc + this.vo * this.scale);
      this.ay.bottom = (this.cKd + this.vo * this.scale);
      this.az.left = (this.cKc - this.vp * this.scale);
      this.az.top = (this.cKd - this.vp * this.scale);
      this.az.right = (this.cKc + this.vp * this.scale);
      this.az.bottom = (this.cKd + this.vp * this.scale);
      this.aA.left = (this.cKc - this.vq * this.scale);
      this.aA.top = (this.cKd - this.vq * this.scale);
      this.aA.right = (this.cKc + this.vq * this.scale);
      this.aA.bottom = (this.cKd + this.vq * this.scale);
      this.aB.left = (this.cKc - this.vr * this.scale);
      this.aB.top = (this.cKd - this.vr * this.scale);
      this.aB.right = (this.cKc + this.vr * this.scale);
      this.aB.bottom = (this.cKd + this.vr * this.scale);
      this.aC.left = (this.cKc - this.vs * this.scale - this.cKh % 10);
      this.aC.top = (this.cKd - this.vs * this.scale - this.cKh % 10);
      this.aC.right = (this.cKc + this.vs * this.scale + this.cKh % 10);
      this.aC.bottom = (this.cKd + this.vs * this.scale + this.cKh % 10);
      this.cKe += 10;
      this.cKf += 10;
      this.cKg += 10;
      paramCanvas.drawArc(this.ay, this.cKe + 270, 90.0F, false, this.bM);
      paramCanvas.drawArc(this.az, this.cKf + 270, 270.0F, false, this.bO);
      paramCanvas.drawArc(this.aA, this.cKg + 90, 90.0F, false, this.bP);
      paramCanvas.drawArc(this.aC, 0.0F, 360.0F, false, this.bN);
      paramCanvas.drawArc(this.aB, 0.0F, 360.0F, false, this.bN);
      if (this.bQX)
      {
        paramCanvas.drawCircle(this.cKc, this.cKd, this.mRadius * this.scale, this.bL);
        if (this.mTotalProgress > 99) {
          this.mTotalProgress = 99;
        }
        String str = this.mTotalProgress + "%";
        this.vt = this.mTextPaint.measureText(str, 0, str.length());
        if (this.mTotalProgress != 0) {
          paramCanvas.drawText(str, this.cKc - this.vt / 2.0F, this.cKd + this.vu / 4.0F, this.mTextPaint);
        }
      }
      float f2 = this.cKd + this.vu / 4.0F + 165.0F * this.scale;
      float f1 = f2;
      if (f2 < this.cKd + this.vs * this.scale + this.cKi / 2) {
        f1 = this.cKd + this.vs * this.scale + this.cKi / 2;
      }
      paramCanvas.drawText(this.bvE, this.cKc - this.bQ.measureText(this.bvE, 0, this.bvE.length()) / 2.0F, f1, this.bQ);
      postInvalidateDelayed(15L);
      return;
    }
  }
  
  public void setFistAgree()
  {
    Random localRandom = new Random();
    int i = this.mTotalProgress;
    this.mTotalProgress = (localRandom.nextInt(20) + i);
  }
  
  public void setScale(int paramInt)
  {
    this.scale = (paramInt / 640.0F);
  }
  
  public void setScanText(String paramString)
  {
    this.bvE = paramString;
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    this.bQX = paramBoolean;
  }
  
  public void setTotalProgress(int paramInt)
  {
    if (paramInt > this.mTotalProgress) {
      this.mTotalProgress = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ScanSuccessView
 * JD-Core Version:    0.7.0.1
 */