package com.tencent.qqmail.scroller.effector;

import android.graphics.Canvas;

public abstract interface GridScreenContainer
{
  public abstract void drawGridCell(Canvas paramCanvas, int paramInt);
  
  public abstract void drawGridCell(Canvas paramCanvas, int paramInt1, int paramInt2);
  
  public abstract int getCellCol();
  
  public abstract int getCellCount();
  
  public abstract int getCellHeight();
  
  public abstract int getCellRow();
  
  public abstract int getCellWidth();
  
  public abstract int getHeight();
  
  public abstract int getPaddingBottom();
  
  public abstract int getPaddingLeft();
  
  public abstract int getPaddingRight();
  
  public abstract int getPaddingTop();
  
  public abstract int getWidth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.effector.GridScreenContainer
 * JD-Core Version:    0.7.0.1
 */