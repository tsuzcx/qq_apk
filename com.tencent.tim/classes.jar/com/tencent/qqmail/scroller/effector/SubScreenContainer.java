package com.tencent.qqmail.scroller.effector;

import android.graphics.Canvas;

public abstract interface SubScreenContainer
{
  public abstract void drawScreen(Canvas paramCanvas, int paramInt);
  
  public abstract void drawScreen(Canvas paramCanvas, int paramInt1, int paramInt2);
  
  public abstract int getHeight();
  
  public abstract int getWidth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.effector.SubScreenContainer
 * JD-Core Version:    0.7.0.1
 */