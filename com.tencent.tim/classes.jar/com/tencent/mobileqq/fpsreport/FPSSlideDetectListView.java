package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import aqjc;
import com.tencent.mobileqq.widget.SlideDetectListView;
import txo;

public class FPSSlideDetectListView
  extends SlideDetectListView
{
  private String aBW;
  private txo b;
  private boolean isFirstDraw;
  private long mStartTime;
  
  public FPSSlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.b != null) {
      this.b.bEQ();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.isFirstDraw)
    {
      this.isFirstDraw = false;
      aqjc.bm(this.aBW, SystemClock.uptimeMillis());
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.b != null) {
      this.b.zD(paramInt);
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.aBW = paramString;
    this.b = new txo();
    this.b.setActTAG(paramString);
    setStartTime(SystemClock.uptimeMillis());
  }
  
  public void setStartTime(long paramLong)
  {
    this.isFirstDraw = true;
    this.mStartTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSSlideDetectListView
 * JD-Core Version:    0.7.0.1
 */