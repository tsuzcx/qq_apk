package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import ankt;
import com.tencent.qphone.base.util.QLog;

public class SimpleProgressBar
  extends View
{
  public static int dJA = -2083835;
  public static int dlY = -16737062;
  public int dJw = 2;
  public int dJx;
  private final int dJy = -1;
  private final int dJz = ankt.dip2px(3.0F);
  private Paint mPaint = new Paint();
  private int mProgress;
  private int mProgressColor = dlY;
  private Rect rect = new Rect();
  
  public SimpleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int aM(int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.dJx) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / this.dJx;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  private void bi(Canvas paramCanvas)
  {
    int i = super.getWidth();
    int j = super.getHeight();
    int k = aM(this.mProgress, i);
    int m = k / 2;
    this.rect.top = 0;
    this.rect.bottom = j;
    this.rect.left = 0;
    this.rect.right = m;
    this.mPaint.setColor(0);
    paramCanvas.drawRect(this.rect, this.mPaint);
    if (k < i)
    {
      this.rect.left = m;
      this.rect.right = (i - m);
      this.mPaint.setColor(this.mProgressColor);
      paramCanvas.drawRect(this.rect, this.mPaint);
    }
    this.rect.left = (i - m);
    this.rect.right = i;
    this.mPaint.setColor(0);
    paramCanvas.drawRect(this.rect, this.mPaint);
  }
  
  private void bj(Canvas paramCanvas)
  {
    int i = super.getWidth();
    int j = super.getHeight();
    int k = aM(this.mProgress, i);
    this.rect.top = 0;
    this.rect.bottom = j;
    this.rect.left = 0;
    this.rect.right = k;
    this.mPaint.setColor(Color.rgb(0, 156, 218));
    paramCanvas.drawRect(this.rect, this.mPaint);
    if (k < i)
    {
      this.rect.left = k;
      this.rect.right = (this.dJz + k);
      this.mPaint.setColor(-1);
      paramCanvas.drawRect(this.rect, this.mPaint);
    }
    if (this.dJz + k < i)
    {
      this.rect.left = (k + this.dJz);
      this.rect.right = i;
      this.mPaint.setColor(Color.rgb(36, 36, 45));
      paramCanvas.drawRect(this.rect, this.mPaint);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {
      return;
    }
    if (this.dJw == 2)
    {
      bi(paramCanvas);
      return;
    }
    bj(paramCanvas);
  }
  
  public void setCurrentProgress(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleProgressBar", 2, "setProgress, progress = " + paramInt + ",isOver = " + paramBoolean);
    }
    if (paramBoolean) {}
    for (this.mProgress = this.dJx;; this.mProgress = paramInt)
    {
      postInvalidate();
      return;
    }
  }
  
  public void setProgressColor(int paramInt)
  {
    if (this.mProgressColor != paramInt)
    {
      this.mProgressColor = paramInt;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.SimpleProgressBar
 * JD-Core Version:    0.7.0.1
 */