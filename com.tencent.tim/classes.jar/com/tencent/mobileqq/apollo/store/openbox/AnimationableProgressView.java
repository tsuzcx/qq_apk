package com.tencent.mobileqq.apollo.store.openbox;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class AnimationableProgressView
  extends View
{
  private Path D;
  private long Ou;
  private long Ov;
  private int aXR;
  private RectF ao;
  private String bhJ;
  private int csd;
  private int cse;
  private int csf;
  private int gW;
  private int mCurrentCount = 3;
  private int mHeight;
  private Paint mPaint;
  private float mS;
  private int mTotalCount = 5;
  private int mWidth;
  private float sL;
  
  public AnimationableProgressView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AnimationableProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.gW = -3946292;
    this.csd = -1;
    this.cse = -1972505;
  }
  
  public void f(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.mCurrentCount = paramInt1;
    this.mTotalCount = paramInt2;
    this.Ou = paramLong1;
    this.Ov = paramLong2;
    if ((this.mCurrentCount < 0) || (this.mTotalCount <= 0) || (this.mWidth == 0) || (this.mHeight == 0)) {
      return;
    }
    if (this.Ov > 0L) {
      if (this.Ou > 0L)
      {
        this.bhJ = (acfp.m(2131702411) + this.mCurrentCount + acfp.m(2131702413));
        this.csf = -34816;
      }
    }
    do
    {
      this.mPaint.setTextSize(14.0F * getResources().getDisplayMetrics().density);
      if (TextUtils.isEmpty(this.bhJ)) {
        this.bhJ = (this.mCurrentCount + "/" + this.mTotalCount + acfp.m(2131702412));
      }
      float f = this.mPaint.measureText(this.bhJ);
      this.mS = ((this.mWidth - f) / 2.0F);
      Paint.FontMetrics localFontMetrics = this.mPaint.getFontMetrics();
      this.sL = ((this.mHeight - localFontMetrics.bottom - localFontMetrics.top) / 2.0F);
      super.invalidate();
      return;
      this.bhJ = (acfp.m(2131702408) + this.mCurrentCount + "/" + this.mTotalCount);
      break;
      this.csf = -16777216;
      this.bhJ = (acfp.m(2131702410) + this.mCurrentCount + "/" + this.mTotalCount + acfp.m(2131702409));
    } while (this.mCurrentCount <= 0);
    if (this.D == null) {
      this.D = new Path();
    }
    this.D.reset();
    paramInt1 = this.mWidth * this.mCurrentCount / this.mTotalCount;
    this.D.moveTo(this.aXR, this.mHeight);
    this.D.arcTo(new RectF(0.0F, this.mHeight - this.aXR * 2, this.aXR * 2, this.mHeight), 90.0F, 90.0F);
    this.D.arcTo(new RectF(0.0F, 0.0F, this.aXR * 2, this.aXR * 2), 180.0F, 90.0F);
    if (this.mCurrentCount >= this.mTotalCount)
    {
      this.D.arcTo(new RectF(this.mWidth - this.aXR * 2, 0.0F, this.mWidth, this.aXR * 2), -90.0F, 90.0F);
      this.D.arcTo(new RectF(this.mWidth - this.aXR * 2, this.mHeight - this.aXR * 2, this.mWidth, this.mHeight), 0.0F, 90.0F);
    }
    for (;;)
    {
      this.D.close();
      break;
      this.D.lineTo(paramInt1, 0.0F);
      this.D.lineTo(paramInt1, this.mHeight);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    if ((this.Ov <= 0L) && (this.Ou <= 0L) && (this.ao != null))
    {
      this.mPaint.setColor(this.csd);
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.ao, this.aXR, this.aXR, this.mPaint);
      if (this.D != null)
      {
        this.mPaint.setColor(this.cse);
        this.mPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawPath(this.D, this.mPaint);
      }
      this.mPaint.setColor(this.gW);
      this.mPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawRoundRect(this.ao, this.aXR, this.aXR, this.mPaint);
    }
    if (!TextUtils.isEmpty(this.bhJ))
    {
      this.mPaint.setColor(this.csf);
      paramCanvas.drawText(this.bhJ, this.mS, this.sL, this.mPaint);
    }
    paramCanvas.restore();
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
      this.aXR = ((int)(this.mHeight * 0.16F));
      f(this.mCurrentCount, this.mTotalCount, this.Ou, this.Ov);
      if (this.ao == null) {
        this.ao = new RectF();
      }
      this.ao.left = 0.0F;
      this.ao.right = this.mWidth;
      this.ao.top = 0.0F;
      this.ao.bottom = this.mHeight;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.AnimationableProgressView
 * JD-Core Version:    0.7.0.1
 */