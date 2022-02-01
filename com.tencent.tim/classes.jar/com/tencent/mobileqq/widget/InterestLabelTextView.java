package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.TextView;

public class InterestLabelTextView
  extends TextView
{
  RoundRectShape a = null;
  ShapeDrawable d = null;
  
  public InterestLabelTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InterestLabelTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InterestLabelTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    RectF localRectF = new RectF(2.0F, 2.0F, 2.0F, 2.0F);
    this.a = new RoundRectShape(new float[] { 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F }, localRectF, new float[] { 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F });
    this.d = new ShapeDrawable(this.a);
    this.d.getPaint().setColor(-16777216);
    setBackgroundDrawable(this.d);
  }
  
  public void setColorFormat(int paramInt)
  {
    this.d.getPaint().setColor(paramInt);
    setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InterestLabelTextView
 * JD-Core Version:    0.7.0.1
 */