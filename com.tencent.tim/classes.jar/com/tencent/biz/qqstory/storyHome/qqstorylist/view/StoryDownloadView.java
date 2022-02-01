package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.animation.AnimatorSet;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

@TargetApi(11)
public class StoryDownloadView
  extends View
{
  public static final int COLOR_GRAY = Color.parseColor("#7f8393");
  public static final int boK = Color.parseColor("#FFFFFF");
  public static final int boL = Color.parseColor("#BCBFC4");
  public AnimatorSet I;
  public AnimatorSet J;
  public boolean aGc;
  public float mE;
  public float mF = -45.0F;
  public float mHeight;
  public float mLineWidth;
  public float mRoundRadius;
  public float mScale = 0.1F;
  public float mSize = 1.0F;
  public int mStatus = 0;
  public float mWidth;
  public float mm;
  public float mn;
  public float mo;
  public float mp;
  public float mq;
  public float mr;
  public float mt;
  public float mu;
  public float mv;
  public float mw;
  public float mz;
  
  public StoryDownloadView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StoryDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ab(this.mSize);
  }
  
  private void ab(float paramFloat)
  {
    this.mWidth = d(46.0F, paramFloat);
    this.mHeight = d(46.0F, paramFloat);
    this.mm = d(5.0F, paramFloat);
    this.mn = d(5.0F, paramFloat);
    this.mo = d(6.0F, paramFloat);
    this.mp = d(4.0F, paramFloat);
    this.mLineWidth = d(5.0F, paramFloat);
    this.mRoundRadius = d(2.0F, paramFloat);
    this.mq = d(18.0F, paramFloat);
    this.mr = (this.mHeight - d(7.0F, paramFloat));
    this.mt = d(6.0F, paramFloat);
    this.mu = d(28.0F, paramFloat);
    this.mv = (this.mWidth - d(8.0F, paramFloat));
    this.mw = d(20.0F, paramFloat);
    this.mz = this.mo;
    this.mE = (this.mHeight - this.mp - this.mLineWidth / 2.0F);
  }
  
  private float d(float paramFloat1, float paramFloat2)
  {
    return (super.getContext().getResources().getDisplayMetrics().density * paramFloat1 + 0.5F) * paramFloat2;
  }
  
  public void al(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    if (this.aGc) {}
    for (int i = boK;; i = COLOR_GRAY)
    {
      localPaint.setColor(i);
      localPaint.setAntiAlias(true);
      Object localObject = new Path();
      ((Path)localObject).moveTo(this.mWidth / 2.0F - this.mLineWidth / 2.0F, this.mz + this.mRoundRadius);
      ((Path)localObject).lineTo(this.mWidth / 2.0F - this.mLineWidth / 2.0F, this.mz + this.mRoundRadius + this.mHeight * 13.0F / 46.0F);
      ((Path)localObject).lineTo(this.mWidth / 2.0F - this.mLineWidth / 2.0F - this.mWidth * 8.0F / 46.0F, this.mz + this.mRoundRadius + this.mHeight * 13.0F / 46.0F);
      ((Path)localObject).lineTo(this.mWidth / 2.0F, this.mz + this.mRoundRadius + this.mHeight * 25.0F / 46.0F);
      ((Path)localObject).lineTo(this.mWidth / 2.0F + this.mLineWidth / 2.0F + this.mWidth * 8.0F / 46.0F, this.mz + this.mRoundRadius + this.mHeight * 13.0F / 46.0F);
      ((Path)localObject).lineTo(this.mWidth / 2.0F + this.mLineWidth / 2.0F, this.mz + this.mRoundRadius + this.mHeight * 13.0F / 46.0F);
      ((Path)localObject).lineTo(this.mWidth / 2.0F + this.mLineWidth / 2.0F, this.mz + this.mRoundRadius);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath((Path)localObject, localPaint);
      paramCanvas.drawArc(new RectF(this.mWidth / 2.0F - this.mLineWidth / 2.0F, this.mz, this.mWidth / 2.0F + this.mLineWidth / 2.0F, this.mz + this.mRoundRadius * 2.0F), 180.0F, 360.0F, true, localPaint);
      float f1 = this.mWidth - this.mn - this.mRoundRadius;
      float f2 = this.mHeight - this.mp - this.mLineWidth;
      float f3 = this.mHeight - this.mp;
      localObject = new Path();
      ((Path)localObject).moveTo(this.mm + this.mRoundRadius, this.mHeight - this.mp - this.mLineWidth / 2.0F);
      ((Path)localObject).quadTo(this.mWidth / 2.0F, this.mE, f1, this.mHeight - this.mp - this.mLineWidth / 2.0F);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeWidth(this.mLineWidth);
      paramCanvas.drawPath((Path)localObject, localPaint);
      localObject = new RectF(this.mm, f2, this.mm + this.mRoundRadius * 2.0F, f3);
      RectF localRectF = new RectF(f1 - this.mRoundRadius, f2, f1 + this.mRoundRadius, f3);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawArc((RectF)localObject, 90.0F, 360.0F, true, localPaint);
      paramCanvas.drawArc(localRectF, -90.0F, 360.0F, true, localPaint);
      return;
    }
  }
  
  public void am(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    Path localPath = new Path();
    if (this.aGc) {}
    for (int i = boK;; i = COLOR_GRAY)
    {
      localPaint.setColor(i);
      localPaint.setAntiAlias(true);
      localPaint.setStrokeWidth(this.mLineWidth);
      localPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.save();
      paramCanvas.rotate(this.mF, this.mq, this.mr);
      paramCanvas.scale(this.mScale, this.mScale, this.mq, this.mr);
      localPath.moveTo(this.mt, this.mu);
      localPath.lineTo(this.mq, this.mr);
      localPath.moveTo(this.mq, this.mr);
      localPath.lineTo(this.mv, this.mw);
      paramCanvas.drawPath(localPath, localPaint);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawCircle(this.mt, this.mu, this.mLineWidth / 2.0F, localPaint);
      paramCanvas.drawCircle(this.mv, this.mw, this.mLineWidth / 2.0F, localPaint);
      paramCanvas.drawCircle(this.mq, this.mr, this.mLineWidth / 2.0F, localPaint);
      paramCanvas.restore();
      return;
    }
  }
  
  public void brI()
  {
    if (this.I != null)
    {
      this.I.end();
      this.I.cancel();
      this.I = null;
    }
    if (this.J != null)
    {
      this.J.end();
      this.J.cancel();
      this.J = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(super.getPaddingLeft(), super.getPaddingTop());
    if (this.mStatus == 2) {
      am(paramCanvas);
    }
    do
    {
      return;
      if ((this.mStatus == 1) || (this.mStatus == 0))
      {
        al(paramCanvas);
        return;
      }
    } while (this.mStatus != 3);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    float f3 = 1.0F;
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    float f1;
    if (i == 1073741824) {
      f1 = paramInt1 / d(46.0F, 1.0F);
    }
    for (;;)
    {
      float f2;
      if (j == 1073741824) {
        f2 = paramInt2 / d(46.0F, 1.0F);
      }
      for (;;)
      {
        ab(Math.min(f1, f2));
        super.setMeasuredDimension(super.getPaddingLeft() + (int)this.mWidth + super.getPaddingRight(), super.getPaddingTop() + (int)this.mHeight + super.getPaddingBottom());
        return;
        if (i == -2147483648)
        {
          f1 = 1.0F;
          break;
        }
        if (i != 0) {
          break label160;
        }
        f1 = 1.0F;
        break;
        f2 = f3;
        if (j != -2147483648)
        {
          f2 = f3;
          if (j == 0) {
            f2 = f3;
          }
        }
      }
      label160:
      f1 = 1.0F;
    }
  }
  
  public void restore()
  {
    this.mStatus = 0;
    super.setEnabled(true);
    brI();
    super.invalidate();
  }
  
  public void setWhiteMode(boolean paramBoolean)
  {
    this.aGc = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView
 * JD-Core Version:    0.7.0.1
 */