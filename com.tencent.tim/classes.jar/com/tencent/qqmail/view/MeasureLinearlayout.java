package com.tencent.qqmail.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MeasureLinearlayout
  extends LinearLayout
{
  public MeasureLinearlayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private float computTextWidth(TextView paramTextView)
  {
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramTextView.getTextSize());
    return localPaint.measureText(paramTextView.getText().toString());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = 0;
    float f = 0.0F;
    while (i < getChildCount())
    {
      f += computTextWidth((TextView)getChildAt(i));
      i += 1;
    }
    if (j > f) {
      setOrientation(0);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      setOrientation(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.MeasureLinearlayout
 * JD-Core Version:    0.7.0.1
 */