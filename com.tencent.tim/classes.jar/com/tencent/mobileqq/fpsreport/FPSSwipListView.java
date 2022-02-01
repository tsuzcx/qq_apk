package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.widget.SwipListView;
import txo;

public class FPSSwipListView
  extends SwipListView
{
  private txo b;
  private boolean chx = true;
  
  public FPSSwipListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FPSSwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public FPSSwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.chx) && (this.b != null)) {
      this.b.bEQ();
    }
  }
  
  public void pause()
  {
    if (this.b != null) {
      this.b.printLog();
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
    this.b = new txo();
    this.b.setActTAG(paramString);
  }
  
  public void xE(boolean paramBoolean)
  {
    this.chx = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSSwipListView
 * JD-Core Version:    0.7.0.1
 */