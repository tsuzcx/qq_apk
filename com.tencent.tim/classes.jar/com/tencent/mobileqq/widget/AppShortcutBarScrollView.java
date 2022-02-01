package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class AppShortcutBarScrollView
  extends HorizontalScrollView
{
  protected a a;
  
  public AppShortcutBarScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppShortcutBarScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppShortcutBarScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.onScroll();
    }
  }
  
  public void setOnScrollChangedListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AppShortcutBarScrollView
 * JD-Core Version:    0.7.0.1
 */