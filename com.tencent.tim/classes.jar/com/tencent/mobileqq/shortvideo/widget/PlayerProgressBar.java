package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class PlayerProgressBar
  extends View
{
  public int aAE = 1;
  public int cqg = 1;
  private int dJu = -15550475;
  private int dJv = -10066330;
  private int mColorBackground = -14342358;
  private int mCurrentCount;
  private Paint mPaint = new Paint();
  private Rect mRect = new Rect();
  public int mTotalTime = 1;
  
  public PlayerProgressBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public PlayerProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int aM(int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.mTotalTime) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / this.mTotalTime;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  private int js(int paramInt)
  {
    if (this.mCurrentCount == this.aAE) {
      return paramInt;
    }
    int i = this.mCurrentCount * paramInt / this.aAE;
    paramInt = i;
    if (i <= 0) {
      paramInt = 1;
    }
    return paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {}
    int j;
    int i;
    do
    {
      return;
      if (this.cqg > this.mTotalTime) {
        this.cqg = this.mTotalTime;
      }
      j = super.getWidth();
      int k = super.getHeight();
      i = aM(this.cqg, j);
      this.mRect.top = 0;
      this.mRect.bottom = k;
      this.mRect.left = i;
      this.mRect.right = j;
      this.mPaint.setColor(this.mColorBackground);
      paramCanvas.drawRect(this.mRect, this.mPaint);
      j = js(i);
      this.mRect.left = 0;
      this.mRect.right = j;
      this.mPaint.setColor(this.dJu);
      paramCanvas.drawRect(this.mRect, this.mPaint);
    } while (j >= i);
    this.mRect.left = j;
    this.mRect.right = i;
    this.mPaint.setColor(this.dJv);
    paramCanvas.drawRect(this.mRect, this.mPaint);
  }
  
  public void setCurrentProgress(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.mCurrentCount = this.aAE;; this.mCurrentCount = paramInt)
    {
      super.postInvalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.PlayerProgressBar
 * JD-Core Version:    0.7.0.1
 */