package com.tencent.qqmail.scroller;

import android.graphics.Canvas;

public abstract interface ScreenScrollerEffector
{
  public abstract int getMaxOvershootPercent();
  
  public abstract void onAttach(ScreenScrollerListener paramScreenScrollerListener);
  
  public abstract void onDetach();
  
  public abstract boolean onDraw(Canvas paramCanvas);
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void recycle();
  
  public abstract void setDrawQuality(int paramInt);
  
  public abstract void setScreenGap(int paramInt);
  
  public abstract void setTopPadding(int paramInt);
  
  public abstract void setType(int paramInt);
  
  public abstract void updateRandomEffect();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.ScreenScrollerEffector
 * JD-Core Version:    0.7.0.1
 */