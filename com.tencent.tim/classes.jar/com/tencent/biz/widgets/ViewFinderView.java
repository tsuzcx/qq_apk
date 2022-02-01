package com.tencent.biz.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

class ViewFinderView
  extends View
{
  boolean SD = false;
  protected double bu;
  protected int bzI;
  Drawable ds = getResources().getDrawable(2130844082);
  Drawable dt = getResources().getDrawable(2130844099);
  int mHeight = 0;
  protected int mLineHeight = this.dt.getIntrinsicHeight();
  Paint mPaint = new Paint(1);
  Rect mRect;
  long mStartTime;
  int mWidth = 0;
  
  public ViewFinderView(Context paramContext)
  {
    super(paramContext);
    this.mPaint.setColor(1275068416);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Rect localRect = this.mRect;
    if ((localRect == null) || (localRect.width() == 0) || (localRect.height() == 0)) {
      paramCanvas.drawRect(0.0F, 0.0F, this.mWidth, this.mHeight, this.mPaint);
    }
    do
    {
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.mWidth, localRect.top, this.mPaint);
      paramCanvas.drawRect(0.0F, localRect.top, localRect.left, localRect.bottom, this.mPaint);
      paramCanvas.drawRect(localRect.right, localRect.top, this.mWidth, localRect.bottom, this.mPaint);
      paramCanvas.drawRect(0.0F, localRect.bottom, this.mWidth, this.mHeight, this.mPaint);
      this.ds.draw(paramCanvas);
    } while (!this.SD);
    int i = (int)((System.currentTimeMillis() - this.mStartTime) * this.bu) % this.bzI;
    this.dt.setBounds(localRect.left, localRect.top + i, localRect.right, i + localRect.top + this.mLineHeight);
    this.dt.draw(paramCanvas);
    postInvalidateDelayed(20L, localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    invalidate();
  }
  
  public void postInvalidateDelayed(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.postInvalidateDelayed(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    postDelayed(new ViewFinderView.1(this, paramInt1, paramInt2, paramInt3, paramInt4), paramLong);
  }
  
  protected void setRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.ds.setBounds(localRect);
    this.bzI = (paramInt4 - paramInt2 - this.mLineHeight);
    this.bu = (this.bzI / 5000.0D);
    this.mRect = localRect;
    invalidate();
  }
  
  protected void start()
  {
    if (!this.SD)
    {
      this.mStartTime = System.currentTimeMillis();
      this.SD = true;
      invalidate();
    }
  }
  
  protected void stop()
  {
    this.SD = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.ViewFinderView
 * JD-Core Version:    0.7.0.1
 */