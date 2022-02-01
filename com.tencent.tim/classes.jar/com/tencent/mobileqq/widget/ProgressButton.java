package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.widget.Button;
import aqnm;

public class ProgressButton
  extends Button
{
  protected ClipDrawable d;
  protected int mMaxProgress = 100;
  protected Paint mPaint;
  protected float mProgress;
  private int mProgressColor = -1;
  protected float mUnitlength;
  
  public ProgressButton(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ProgressButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    int i = getResources().getColorStateList(2131167337).getDefaultColor();
    if (this.mProgressColor == -1)
    {
      this.mPaint.setColor(i);
      return;
    }
    this.mPaint.setColor(this.mProgressColor);
  }
  
  public ClipDrawable a(@ColorInt int paramInt)
  {
    if (this.d != null) {
      return this.d;
    }
    float f = aqnm.dip2px(50.0F);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt);
    return new ClipDrawable(localShapeDrawable, 8388611, 1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.d != null)
    {
      this.d.setBounds(0, 0, getWidth(), getHeight());
      this.d.setLevel((int)(10000 / this.mMaxProgress * this.mProgress));
      this.d.draw(paramCanvas);
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      return;
      if (this.mUnitlength == 0.0F) {
        this.mUnitlength = (getWidth() / this.mMaxProgress);
      }
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.mUnitlength * this.mProgress, getHeight()), 5.0F, 5.0F, this.mPaint);
    }
  }
  
  public void setMacProgress(int paramInt)
  {
    this.mMaxProgress = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.mProgress = paramInt;
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    this.mProgressColor = paramInt;
    this.mPaint.setColor(this.mProgressColor);
  }
  
  public void setProgressDrawable(ClipDrawable paramClipDrawable)
  {
    this.d = paramClipDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressButton
 * JD-Core Version:    0.7.0.1
 */