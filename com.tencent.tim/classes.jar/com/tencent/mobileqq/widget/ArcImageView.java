package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class ArcImageView
  extends ImageView
{
  private boolean MX;
  private Drawable bL;
  private int eeT = 3;
  private float ex;
  private Paint mPaint;
  
  public ArcImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ArcImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ArcImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    try
    {
      this.mPaint.setColor(getResources().getColor(2131167654));
      this.eeT = ((int)(getResources().getDisplayMetrics().density * 1.5F));
      this.mPaint.setStrokeWidth(this.eeT);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF = new RectF();
    localRectF.left = this.eeT;
    localRectF.top = this.eeT;
    localRectF.right = (getWidth() - this.eeT);
    localRectF.bottom = (getHeight() - this.eeT);
    paramCanvas.drawArc(localRectF, 270.0F, this.ex, false, this.mPaint);
    if ((this.MX) && (this.bL != null))
    {
      this.bL.setState(getDrawableState());
      int i = getWidth();
      int j = this.bL.getIntrinsicWidth();
      int k = this.bL.getIntrinsicHeight();
      this.bL.setBounds(i - j, 0, getWidth(), k);
      this.bL.draw(paramCanvas);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      paramFloat = 360.0F * f;
      if (this.ex != paramFloat)
      {
        this.ex = paramFloat;
        postInvalidate();
      }
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  public void showRedDot(boolean paramBoolean)
  {
    if (this.MX != paramBoolean)
    {
      this.MX = paramBoolean;
      if ((this.MX) && (this.bL == null)) {
        this.bL = getResources().getDrawable(2130851400);
      }
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ArcImageView
 * JD-Core Version:    0.7.0.1
 */