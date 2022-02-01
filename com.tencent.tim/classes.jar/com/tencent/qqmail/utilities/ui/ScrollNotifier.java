package com.tencent.qqmail.utilities.ui;

public abstract interface ScrollNotifier
{
  public abstract void addScrollListener(ScrollListener paramScrollListener);
  
  public abstract int computeHorizontalScrollExtent();
  
  public abstract int computeHorizontalScrollOffset();
  
  public abstract int computeHorizontalScrollRange();
  
  public abstract int computeVerticalScrollExtent();
  
  public abstract int computeVerticalScrollOffset();
  
  public abstract int computeVerticalScrollRange();
  
  public static abstract interface ScrollListener
  {
    public abstract void onNotifierScroll(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.ScrollNotifier
 * JD-Core Version:    0.7.0.1
 */