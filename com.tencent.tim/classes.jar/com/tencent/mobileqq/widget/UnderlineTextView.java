package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;
import atau.a;
import cooperation.qzone.util.QZLog;

public class UnderlineTextView
  extends TextView
{
  private Paint mPaint;
  private Rect mRect;
  private float mStrokeWidth;
  
  public UnderlineTextView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public UnderlineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UnderlineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sC, paramInt, 0);
    paramInt = paramContext.getColor(0, -65536);
    this.mStrokeWidth = paramContext.getDimension(1, f * 2.0F);
    paramContext.recycle();
    this.mRect = new Rect();
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(paramInt);
    this.mPaint.setStrokeWidth(this.mStrokeWidth);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getLineCount();
    Layout localLayout = getLayout();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          int k = getLineBounds(i, this.mRect);
          int m = localLayout.getLineStart(i);
          int n = localLayout.getLineEnd(i);
          float f1 = localLayout.getPrimaryHorizontal(m);
          float f2 = localLayout.getPrimaryHorizontal(m + 1);
          float f3 = localLayout.getPrimaryHorizontal(n - 1);
          paramCanvas.drawLine(getPaddingLeft() + f1, k + this.mStrokeWidth + 15.0F, getPaddingLeft() + (f3 + (f2 - f1)), k + this.mStrokeWidth + 15.0F, this.mPaint);
          i += 1;
        }
        catch (Exception paramCanvas)
        {
          QZLog.e("UnderlineTextView", "" + paramCanvas);
        }
      }
    }
  }
  
  public void setUnderLineColor(int paramInt)
  {
    this.mPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setUnderlineWidth(float paramFloat)
  {
    this.mStrokeWidth = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UnderlineTextView
 * JD-Core Version:    0.7.0.1
 */