package com.tencent.qqmail.scroller;

public abstract interface RowScrollerListener
  extends ScrollerListener
{
  public abstract int getNextMonthRow();
  
  public abstract int getPreviousMonthRow();
  
  public abstract void onFirstRowChanged(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.RowScrollerListener
 * JD-Core Version:    0.7.0.1
 */