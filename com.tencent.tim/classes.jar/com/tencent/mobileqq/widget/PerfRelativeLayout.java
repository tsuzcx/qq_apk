package com.tencent.mobileqq.widget;

import ahmm;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class PerfRelativeLayout
  extends RelativeLayout
{
  private ahmm b;
  
  public PerfRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public PerfRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PerfRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.b != null) {
      this.b.bMp();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("PerfRelativeLayout", 4, "dispatchDraw, " + this.b);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.b != null) {
      this.b.bMp();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("PerfRelativeLayout", 4, "draw, " + this.b);
    }
  }
  
  public void setOnDrawCompleteListener(ahmm paramahmm)
  {
    this.b = paramahmm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PerfRelativeLayout
 * JD-Core Version:    0.7.0.1
 */