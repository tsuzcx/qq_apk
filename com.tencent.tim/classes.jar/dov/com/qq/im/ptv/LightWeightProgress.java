package dov.com.qq.im.ptv;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import azbx;

public class LightWeightProgress
  extends View
{
  protected Paint Q;
  RectF bN = new RectF();
  private boolean bbV;
  protected Paint dg;
  int eJn;
  protected int eJo;
  protected int eJp;
  protected int eJq;
  protected int eJr;
  protected int eJs;
  int mBgColor;
  float mDensity;
  int mHeight;
  float mProgress;
  int mProgressColor;
  protected Paint mProgressPaint;
  int mRadius = azbx.dip2px(14.0F);
  int mStrokeWidth = 2;
  int mWidth;
  protected int totalLength;
  
  public LightWeightProgress(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LightWeightProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public int RH()
  {
    return this.mProgressColor;
  }
  
  protected void cb(Canvas paramCanvas)
  {
    int i = this.mStrokeWidth / 2;
    float f1 = this.mRadius + i;
    float f2 = i;
    paramCanvas.drawLine(f1, f2, this.mWidth - f1, f2, this.Q);
    f1 = this.mRadius + i;
    f2 = this.mHeight - i;
    paramCanvas.drawLine(f1, f2, this.mWidth - f1, f2, this.Q);
    f1 = i;
    f2 = this.mRadius + i;
    paramCanvas.drawLine(f1, f2, f1, this.mHeight - f2, this.Q);
    f1 = this.mWidth - i;
    f2 = this.mRadius + i;
    paramCanvas.drawLine(f1, f2, f1, this.mHeight - f2, this.Q);
    int j = this.mRadius + this.mRadius;
    RectF localRectF1 = this.bN;
    RectF localRectF2 = this.bN;
    f1 = i;
    localRectF2.top = f1;
    localRectF1.left = f1;
    localRectF1 = this.bN;
    localRectF2 = this.bN;
    f1 = i + j;
    localRectF2.bottom = f1;
    localRectF1.right = f1;
    paramCanvas.drawArc(this.bN, 180.0F, 90.0F, false, this.Q);
    this.bN.left = i;
    this.bN.top = (this.mHeight - (i + j));
    this.bN.right = (i + j);
    this.bN.bottom = (this.mHeight - i);
    paramCanvas.drawArc(this.bN, 90.0F, 90.0F, false, this.Q);
    this.bN.left = (this.mWidth - (i + j));
    this.bN.top = (this.mHeight - (i + j));
    this.bN.right = (this.mWidth - i);
    this.bN.bottom = (this.mHeight - i);
    paramCanvas.drawArc(this.bN, 0.0F, 90.0F, false, this.Q);
    this.bN.left = (this.mWidth - (i + j));
    this.bN.top = i;
    this.bN.right = (this.mWidth - i);
    this.bN.bottom = (i + j);
    paramCanvas.drawArc(this.bN, 270.0F, 90.0F, false, this.Q);
  }
  
  protected void cc(Canvas paramCanvas)
  {
    Paint localPaint = this.mProgressPaint;
    if (this.bbV)
    {
      this.dg.setColor(this.eJn);
      localPaint = this.dg;
    }
    int i = this.mStrokeWidth / 2;
    this.eJo = (this.mWidth - (this.mRadius + i) * 2);
    this.eJp = (this.eJo / 2);
    this.eJq = (this.mHeight - (this.mRadius + i) * 2);
    this.eJr = ((int)(6.283185307179586D * this.mRadius));
    this.totalLength = (this.eJr + this.eJo * 2 + this.eJq * 2);
    this.eJs = (this.eJr / 4);
    int k = (int)(this.mProgress / 10000.0F * this.totalLength);
    int j = this.mRadius + this.mRadius;
    if (k <= this.eJp)
    {
      paramCanvas.drawLine(this.mWidth / 2, i, this.mWidth / 2 + k, i, localPaint);
      return;
    }
    paramCanvas.drawLine(this.mWidth / 2, i, this.mWidth - (this.mRadius + i), i, localPaint);
    k -= this.eJp;
    this.bN.left = (this.mWidth - (i + j));
    this.bN.top = i;
    this.bN.right = (this.mWidth - i);
    this.bN.bottom = (i + j);
    if (k <= this.eJs)
    {
      f = k * 1.0F / this.eJs;
      paramCanvas.drawArc(this.bN, 270.0F, f * 90.0F, false, localPaint);
      return;
    }
    paramCanvas.drawArc(this.bN, 270.0F, 90.0F, false, localPaint);
    k -= this.eJs;
    if (k <= this.eJq)
    {
      paramCanvas.drawLine(this.mWidth - i, this.mRadius + i, this.mWidth - i, this.mRadius + i + k, localPaint);
      return;
    }
    paramCanvas.drawLine(this.mWidth - i, this.mRadius + i, this.mWidth - i, this.mHeight - (this.mRadius + i), localPaint);
    k -= this.eJq;
    this.bN.left = (this.mWidth - (i + j));
    this.bN.top = (this.mHeight - (i + j));
    this.bN.right = (this.mWidth - i);
    this.bN.bottom = (this.mHeight - i);
    if (k <= this.eJs)
    {
      f = k * 1.0F / this.eJs;
      paramCanvas.drawArc(this.bN, 0.0F, f * 90.0F, false, localPaint);
      return;
    }
    paramCanvas.drawArc(this.bN, 0.0F, 90.0F, false, localPaint);
    k -= this.eJs;
    if (k <= this.eJo)
    {
      f = this.mWidth - (this.mRadius + i);
      paramCanvas.drawLine(f, this.mHeight - i, f - k, this.mHeight - i, localPaint);
      return;
    }
    paramCanvas.drawLine(this.mWidth - (this.mRadius + i), this.mHeight - i, this.mRadius + i, this.mHeight - i, localPaint);
    k -= this.eJo;
    this.bN.left = i;
    this.bN.top = (this.mHeight - (i + j));
    this.bN.right = (i + j);
    this.bN.bottom = (this.mHeight - i);
    if (k <= this.eJs)
    {
      f = k * 1.0F / this.eJs;
      paramCanvas.drawArc(this.bN, 90.0F, f * 90.0F, false, localPaint);
      return;
    }
    paramCanvas.drawArc(this.bN, 90.0F, 90.0F, false, localPaint);
    k -= this.eJs;
    if (k <= this.eJq)
    {
      f = this.mHeight - (this.mRadius + i);
      paramCanvas.drawLine(i, f, i, f - k, localPaint);
      return;
    }
    paramCanvas.drawLine(i, this.mHeight - (this.mRadius + i), i, this.mRadius + i, localPaint);
    k -= this.eJq;
    RectF localRectF1 = this.bN;
    RectF localRectF2 = this.bN;
    float f = i;
    localRectF2.top = f;
    localRectF1.left = f;
    localRectF1 = this.bN;
    localRectF2 = this.bN;
    f = i + j;
    localRectF2.bottom = f;
    localRectF1.right = f;
    if (k <= this.eJs)
    {
      f = k * 1.0F / this.eJs;
      paramCanvas.drawArc(this.bN, 180.0F, f * 90.0F, false, localPaint);
      return;
    }
    paramCanvas.drawArc(this.bN, 180.0F, 90.0F, false, localPaint);
    f = k - this.eJs + (this.mRadius + i);
    if (this.mProgress == 10000.0F) {
      f = this.mWidth / 2;
    }
    paramCanvas.drawLine(this.mRadius + i, i, f, i, localPaint);
  }
  
  protected void init()
  {
    setLayerType(1, null);
    this.mDensity = getResources().getDisplayMetrics().density;
    this.mBgColor = 0;
    this.mProgressColor = getResources().getColor(2131166534);
    this.eJn = getResources().getColor(2131166538);
    this.Q = new Paint();
    this.Q.setAntiAlias(true);
    this.Q.setStyle(Paint.Style.STROKE);
    this.Q.setColor(this.mBgColor);
    this.mProgressPaint = new Paint();
    this.mProgressPaint.setAntiAlias(true);
    this.mProgressPaint.setStyle(Paint.Style.STROKE);
    this.mProgressPaint.setColor(this.mProgressColor);
    this.dg = new Paint();
    this.dg.setAntiAlias(true);
    this.dg.setStyle(Paint.Style.STROKE);
    this.dg.setColor(this.eJn);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    if (this.mWidth <= 0) {
      return;
    }
    cb(paramCanvas);
    cc(paramCanvas);
  }
  
  public void setCurrentProgress(float paramFloat)
  {
    float f = 10000.0F;
    if (paramFloat > 10000.0F) {}
    for (;;)
    {
      this.mProgress = f;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      this.mProgress = f;
      invalidate();
      return;
      f = paramFloat;
    }
  }
  
  public void setDeleteColor(int paramInt)
  {
    this.eJn = paramInt;
    invalidate();
  }
  
  public void setStatus(boolean paramBoolean)
  {
    this.bbV = paramBoolean;
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.mStrokeWidth = ((int)(this.mDensity * paramFloat + 0.5D));
    this.mStrokeWidth += this.mStrokeWidth % 2;
    this.Q.setStrokeWidth(this.mStrokeWidth);
    this.mProgressPaint.setStrokeWidth(this.mStrokeWidth);
    this.dg.setStrokeWidth(this.mStrokeWidth);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightProgress
 * JD-Core Version:    0.7.0.1
 */