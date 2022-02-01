package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

public class CircleView
  extends View
{
  private Paint mPaint;
  private boolean mSizeChanged;
  
  public CircleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CircleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mSizeChanged)
    {
      int i = getWidth();
      int j = getHeight();
      if (this.mPaint == null)
      {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-65536);
      }
      int k = paramCanvas.saveLayer(0.0F, 0.0F, i, j, null, 31);
      paramCanvas.drawRect(0.0F, 0.0F, i, j, this.mPaint);
      this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      this.mPaint.setColor(0);
      paramCanvas.drawCircle(i / 2.0F, j / 2.0F, i / 2.0F, this.mPaint);
      this.mPaint.setXfermode(null);
      this.mSizeChanged = false;
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSizeChanged = true;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CircleView
 * JD-Core Version:    0.7.0.1
 */