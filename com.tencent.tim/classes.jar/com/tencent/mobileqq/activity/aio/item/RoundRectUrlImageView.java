package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import arko;
import com.tencent.image.URLImageView;

public class RoundRectUrlImageView
  extends URLImageView
{
  private int aiF;
  private boolean bhK;
  private Path mClipPath;
  private int mHeight;
  private int mPicHeight;
  private int mPicWidth;
  private int mWidth;
  
  public RoundRectUrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundRectUrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundRectUrlImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
  
  private void resetMatrix()
  {
    Object localObject = getDrawable();
    if (localObject == null) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        i = ((Drawable)localObject).getIntrinsicWidth();
        j = ((Drawable)localObject).getIntrinsicHeight();
      } while ((i == this.mPicWidth) && (j == this.mPicHeight));
      this.mPicWidth = i;
      this.mPicHeight = j;
    } while ((this.mPicWidth == 0) && (this.mPicHeight == 0));
    if (this.mPicWidth * this.mHeight > this.mWidth * this.mPicHeight) {}
    for (float f = this.mHeight / this.mPicHeight;; f = this.mWidth / this.mPicWidth)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f, f);
      setImageMatrix((Matrix)localObject);
      return;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Integer localInteger = null;
    if (this.mClipPath != null)
    {
      localInteger = Integer.valueOf(paramCanvas.save());
      paramCanvas.clipPath(this.mClipPath);
    }
    super.dispatchDraw(paramCanvas);
    if (localInteger != null) {
      paramCanvas.restoreToCount(localInteger.intValue());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    resetMatrix();
    Integer localInteger = null;
    if (this.mClipPath != null)
    {
      localInteger = Integer.valueOf(paramCanvas.save());
      paramCanvas.clipPath(this.mClipPath);
    }
    super.onDraw(paramCanvas);
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
    resetMatrix();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isClickable()) || (!isEnabled()) || (!this.bhK)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      arko.iH(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
      arko.iI(this);
    }
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
  
  public void setEnableEffect(boolean paramBoolean)
  {
    this.bhK = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView
 * JD-Core Version:    0.7.0.1
 */