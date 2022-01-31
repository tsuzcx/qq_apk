package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class QQVideoView
  extends VideoView
{
  private int a;
  private int b;
  
  public QQVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.a, this.b);
  }
  
  public void setDimension(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQVideoView
 * JD-Core Version:    0.7.0.1
 */