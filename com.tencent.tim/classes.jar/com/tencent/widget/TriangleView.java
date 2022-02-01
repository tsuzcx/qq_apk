package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class TriangleView
  extends View
{
  boolean firstDraw = true;
  Paint mPaint = new Paint();
  Path mPath = new Path();
  
  public TriangleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TriangleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TriangleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setColor(-1);
    this.mPaint.setPathEffect(new CornerPathEffect(convertDpToPixel(paramContext, 2.0F)));
  }
  
  public static float convertDpToPixel(Context paramContext, float paramFloat)
  {
    return paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F * paramFloat;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.firstDraw)
    {
      int i = getWidth();
      int j = getHeight();
      float f = i * 0.55F;
      this.mPath.moveTo(i / 2.0F - f / 2.0F, j / 2.0F - f * 1.73205F / 6.0F);
      this.mPath.lineTo(i / 2.0F + f / 2.0F, j / 2.0F - f * 1.73205F / 6.0F);
      this.mPath.lineTo(i / 2.0F, j / 2.0F + f * 1.73205F / 3.0F);
      this.mPath.close();
      this.firstDraw = false;
    }
    paramCanvas.drawPath(this.mPath, this.mPaint);
  }
  
  public void setColor(int paramInt)
  {
    this.mPaint.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.TriangleView
 * JD-Core Version:    0.7.0.1
 */