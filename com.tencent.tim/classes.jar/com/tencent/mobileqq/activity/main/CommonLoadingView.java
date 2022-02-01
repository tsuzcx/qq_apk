package com.tencent.mobileqq.activity.main;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CommonLoadingView
  extends FrameLayout
{
  private a a;
  private boolean mFirstDraw = true;
  
  public CommonLoadingView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mFirstDraw)
    {
      this.mFirstDraw = false;
      if (this.a != null) {
        this.a.onFirstDraw();
      }
    }
  }
  
  public void setOnFirstDrawListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onFirstDraw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.CommonLoadingView
 * JD-Core Version:    0.7.0.1
 */