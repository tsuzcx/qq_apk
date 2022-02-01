package com.tencent.qqmail.scroller;

public abstract interface ScrollerListener
{
  public abstract int getScrollX();
  
  public abstract int getScrollY();
  
  public abstract void invalidate();
  
  public abstract void onFlingIntercepted();
  
  public abstract void onFlingStart();
  
  public abstract void onScrollChanged(int paramInt1, int paramInt2);
  
  public abstract void onScrollFinish(int paramInt);
  
  public abstract void onScrollStart();
  
  public abstract void scrollBy(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.ScrollerListener
 * JD-Core Version:    0.7.0.1
 */