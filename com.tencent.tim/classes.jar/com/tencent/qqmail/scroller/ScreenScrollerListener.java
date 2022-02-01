package com.tencent.qqmail.scroller;

public abstract interface ScreenScrollerListener
  extends ScrollerListener
{
  public abstract int getFirstVisiableScreenIndex(int paramInt);
  
  public abstract ScreenScroller getScreenScroller();
  
  public abstract int getScreenSizeByIndex(int paramInt);
  
  public abstract int getScreenTopByIndex(int paramInt);
  
  public abstract void onScreenChanged(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.ScreenScrollerListener
 * JD-Core Version:    0.7.0.1
 */