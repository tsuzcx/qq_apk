package com.tencent.biz.qqstory.widget.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RectangleClipLayout
  extends FrameLayout
{
  private RectF Y = new RectF();
  private final Path mClipPath = new Path();
  private boolean mEnableClip = true;
  private float mRadius;
  
  public RectangleClipLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RectangleClipLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RectangleClipLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((!this.mEnableClip) || (this.mClipPath.isEmpty()))
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    paramCanvas.save();
    paramCanvas.clipPath(this.mClipPath);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setClipRect(RectF paramRectF, float paramFloat)
  {
    if ((paramRectF.width() >= getWidth()) && (paramRectF.height() >= getHeight()))
    {
      this.mEnableClip = false;
      invalidate();
      return;
    }
    this.mEnableClip = true;
    this.Y.set(paramRectF);
    this.mRadius = paramFloat;
    this.mClipPath.reset();
    this.mClipPath.addRoundRect(this.Y, this.mRadius, this.mRadius, Path.Direction.CW);
    this.mClipPath.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.RectangleClipLayout
 * JD-Core Version:    0.7.0.1
 */