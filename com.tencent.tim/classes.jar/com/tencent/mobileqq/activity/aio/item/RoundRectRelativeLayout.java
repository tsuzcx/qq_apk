package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.widget.RelativeLayout;

public class RoundRectRelativeLayout
  extends RelativeLayout
{
  private int aiF;
  private int mBgColor = 0;
  private Path mClipPath;
  private int mHeight;
  private int mWidth;
  
  public RoundRectRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  private void ajW()
  {
    this.mClipPath = new Path();
    if (this.aiF == 0)
    {
      this.mClipPath.addRect(0.0F, 0.0F, this.mWidth, this.mHeight, Path.Direction.CCW);
      return;
    }
    int i = Math.min(this.aiF * 2, Math.min(this.mWidth, this.mHeight)) / 2;
    this.mClipPath.addRoundRect(new RectF(0.0F, 0.0F, this.mWidth, this.mHeight), i, i, Path.Direction.CCW);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Integer localInteger = null;
    if (this.mClipPath != null)
    {
      localInteger = Integer.valueOf(paramCanvas.save());
      paramCanvas.clipPath(this.mClipPath);
    }
    paramCanvas.drawColor(this.mBgColor);
    super.dispatchDraw(paramCanvas);
    if (localInteger != null) {
      paramCanvas.restoreToCount(localInteger.intValue());
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    if ((paramInt1 == this.mWidth) && (paramInt2 == this.mHeight)) {
      return;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    ajW();
  }
  
  public void setAllRadius(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (this.aiF == i) {
      return;
    }
    this.aiF = i;
    ajW();
    invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    if (this.mBgColor == paramInt) {
      return;
    }
    this.mBgColor = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RoundRectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */