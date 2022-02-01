package com.tencent.av.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import atau.a;

public class RotateLayout
  extends ViewGroup
{
  private final RectF A = new RectF();
  private boolean aap = true;
  private final float[] ah = new float[2];
  private final float[] ai = new float[2];
  private int angle;
  private final Rect at = new Rect();
  private final Matrix q = new Matrix();
  private final RectF y = new RectF();
  
  public RotateLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RotateLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(-this.angle, getWidth() / 2.0F, getHeight() / 2.0F);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.ah[0] = paramMotionEvent.getX();
    this.ah[1] = paramMotionEvent.getY();
    this.q.mapPoints(this.ai, this.ah);
    paramMotionEvent.setLocation(this.ai[0], this.ai[1]);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    invalidate();
    return super.invalidateChildInParent(paramArrayOfInt, paramRect);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.aap)
    {
      localObject = this.y;
      RectF localRectF = this.A;
      ((RectF)localObject).set(0.0F, 0.0F, paramInt3 - paramInt1, paramInt4 - paramInt2);
      this.q.setRotate(this.angle, ((RectF)localObject).centerX(), ((RectF)localObject).centerY());
      this.q.mapRect(localRectF, (RectF)localObject);
      localRectF.round(this.at);
      this.aap = false;
    }
    Object localObject = getChildAt(0);
    if (localObject != null) {
      ((View)localObject).layout(this.at.left, this.at.top, this.at.right, this.at.bottom);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(0);
    if (localView != null)
    {
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (this.angle != localLayoutParams.angle)
      {
        this.angle = localLayoutParams.angle;
        this.aap = true;
      }
      if (Math.abs(this.angle % 180) == 90)
      {
        measureChild(localView, paramInt2, paramInt1);
        setMeasuredDimension(resolveSize(localView.getMeasuredHeight(), paramInt1), resolveSize(localView.getMeasuredWidth(), paramInt2));
        return;
      }
      measureChild(localView, paramInt1, paramInt2);
      setMeasuredDimension(resolveSize(localView.getMeasuredWidth(), paramInt1), resolveSize(localView.getMeasuredHeight(), paramInt2));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    this.aap = true;
    super.setLayoutParams(paramLayoutParams);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public int angle;
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rO);
      this.angle = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.widget.RotateLayout
 * JD-Core Version:    0.7.0.1
 */