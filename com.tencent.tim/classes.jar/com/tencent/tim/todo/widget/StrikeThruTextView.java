package com.tencent.tim.todo.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import aqnm;
import aupy;
import com.tencent.qphone.base.util.QLog;

public class StrikeThruTextView
  extends TextView
{
  private float Cy;
  private long duration = 530L;
  private boolean isAnimating;
  private ValueAnimator mAnimator;
  private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
  private Paint mPaint;
  private Rect mRect = new Rect();
  private float mStrokeWidth;
  private long playTime;
  
  public StrikeThruTextView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public StrikeThruTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public StrikeThruTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private float a(Layout paramLayout, int paramInt)
  {
    if (paramLayout.getSecondaryHorizontal(paramLayout.getLineEnd(paramInt)) == 0.0F) {
      return paramLayout.getPrimaryHorizontal(paramLayout.getLineEnd(paramInt) - 1) + getTextSize();
    }
    return paramLayout.getSecondaryHorizontal(paramLayout.getLineEnd(paramInt));
  }
  
  private float bP()
  {
    return aqnm.dpToPx(10.0F);
  }
  
  private float c(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      paramInt1 = 0;
    }
    for (;;)
    {
      return this.mInterpolator.getInterpolation(paramInt1 / (paramInt3 - paramInt2));
      if (paramInt1 > paramInt3) {
        paramInt1 = paramInt3 - paramInt2;
      } else {
        paramInt1 -= paramInt2;
      }
    }
  }
  
  private void init(Context paramContext)
  {
    this.mStrokeWidth = getResources().getDisplayMetrics().density;
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mPaint.setColor(-6905943);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStrokeWidth(this.mStrokeWidth * 1.0F);
  }
  
  public void c(Animator.AnimatorListener paramAnimatorListener)
  {
    if (!this.isAnimating)
    {
      if (this.mAnimator == null)
      {
        this.mAnimator = ValueAnimator.ofInt(new int[] { 0, (int)this.duration });
        this.mAnimator.setDuration(this.duration);
        this.mAnimator.addUpdateListener(new aupy(this));
      }
      this.mAnimator.removeAllListeners();
      if (paramAnimatorListener != null) {
        this.mAnimator.addListener(paramAnimatorListener);
      }
      this.mAnimator.start();
      setTextColor(getResources().getColor(2131165582));
      this.isAnimating = true;
    }
  }
  
  public void clearAnimation()
  {
    if (this.isAnimating)
    {
      this.isAnimating = false;
      if (this.mAnimator != null) {
        this.mAnimator.cancel();
      }
      setTextColor(getResources().getColor(2131165625));
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    QLog.d("StrikeThruTextView", 4, " onDraw getMeasuredHeight() " + getMeasuredHeight() + " y= " + getY());
    if (this.isAnimating)
    {
      Layout localLayout = getLayout();
      int i = 0;
      if (i < getLineCount())
      {
        getLineBounds(i, this.mRect);
        float f3 = (this.mRect.bottom - this.mRect.top) / 2 + this.mRect.top + this.mStrokeWidth / 2.0F;
        float f1;
        long l;
        label147:
        float f4;
        if (i == 0)
        {
          f1 = bP();
          if (this.playTime > 400L)
          {
            l = this.playTime - 400L;
            f1 = (float)l * f1 / (float)(this.duration - 400L);
            f2 = a(localLayout, i);
            f4 = c((int)this.playTime, 0, 266);
          }
        }
        for (float f2 = bP() + f2 * f4;; f2 = bP() + f2 * f4)
        {
          paramCanvas.drawLine(f1, f3, f2, f3, this.mPaint);
          i += 1;
          break;
          l = 0L;
          break label147;
          f1 = bP();
          f2 = a(localLayout, i);
          f4 = c((int)this.playTime, 200, 466);
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    getLineBounds(0, this.mRect);
    this.Cy = ((this.mRect.bottom - this.mRect.top) / 2 + this.mRect.top - this.mStrokeWidth / 2.0F);
    QLog.d("StrikeThruTextView", 4, " onMeasure getMeasuredHeight() " + getMeasuredHeight() + " firstLineYPosition " + this.Cy);
  }
  
  public void setItDone(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.isAnimating = true;
      this.playTime = this.duration;
      setTextColor(getResources().getColor(2131165582));
    }
    for (;;)
    {
      invalidate();
      return;
      this.isAnimating = false;
      this.playTime = 0L;
      setTextColor(getResources().getColor(2131165625));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.todo.widget.StrikeThruTextView
 * JD-Core Version:    0.7.0.1
 */