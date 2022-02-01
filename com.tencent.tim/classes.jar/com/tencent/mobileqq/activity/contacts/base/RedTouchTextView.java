package com.tencent.mobileqq.activity.contacts.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import aqnm;

public class RedTouchTextView
  extends TextView
{
  Paint paint;
  
  public RedTouchTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RedTouchTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RedTouchTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @SuppressLint({"NewApi"})
  public RedTouchTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  private void init()
  {
    if (this.paint == null)
    {
      this.paint = new Paint();
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.paint.setColor(-65536);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    setMeasuredDimension(paramInt1 + aqnm.dip2px(10.0F), paramInt2 + aqnm.dip2px(10.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.RedTouchTextView
 * JD-Core Version:    0.7.0.1
 */