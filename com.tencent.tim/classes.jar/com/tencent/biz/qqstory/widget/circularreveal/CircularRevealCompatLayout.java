package com.tencent.biz.qqstory.widget.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CircularRevealCompatLayout
  extends FrameLayout
{
  private RectF Y = new RectF();
  private boolean aJI;
  private float mCenterX;
  private float mCenterY;
  private final Path mClipPath = new Path();
  private boolean mEnableClip;
  private float mRadius;
  private float oc;
  private final Path w = new Path();
  
  public CircularRevealCompatLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularRevealCompatLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircularRevealCompatLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.mEnableClip)
    {
      if (!this.mClipPath.isEmpty())
      {
        paramCanvas.save();
        paramCanvas.clipPath(this.mClipPath);
        super.dispatchDraw(paramCanvas);
        paramCanvas.restore();
        return;
      }
      super.dispatchDraw(paramCanvas);
      return;
    }
    if (this.aJI)
    {
      if (!this.w.isEmpty())
      {
        paramCanvas.save();
        paramCanvas.clipPath(this.w);
        super.dispatchDraw(paramCanvas);
        paramCanvas.restore();
        return;
      }
      super.dispatchDraw(paramCanvas);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void setClipRect(RectF paramRectF, float paramFloat)
  {
    if ((paramRectF.width() >= getWidth()) && (paramRectF.height() >= getHeight()))
    {
      this.aJI = false;
      invalidate();
      return;
    }
    this.aJI = true;
    this.Y.set(paramRectF);
    this.oc = paramFloat;
    this.w.reset();
    this.w.addRoundRect(this.Y, this.oc, this.oc, Path.Direction.CW);
    this.w.close();
  }
  
  public void setEnableClip(boolean paramBoolean)
  {
    this.mEnableClip = paramBoolean;
  }
  
  public void setRevealClip(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mCenterX = paramFloat1;
    this.mCenterY = paramFloat2;
    this.mRadius = paramFloat3;
    float f1 = getWidth() - paramFloat1;
    float f2 = getWidth() - paramFloat2;
    if (Math.max(paramFloat1 * paramFloat1, f1 * f1) + Math.max(paramFloat2 * paramFloat2, f2 * f2) > paramFloat3 * paramFloat3) {}
    for (boolean bool = true;; bool = false)
    {
      this.mEnableClip = bool;
      this.mClipPath.reset();
      this.mClipPath.addCircle(this.mCenterX, this.mCenterY, this.mRadius, Path.Direction.CW);
      this.mClipPath.close();
      invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout
 * JD-Core Version:    0.7.0.1
 */