package com.tencent.widget;

import android.view.View;

public abstract interface OverScrollViewListener
{
  public static final int h_ = 0;
  public static final int i_ = 1;
  
  public abstract void a(int paramInt, View paramView, ListView paramListView);
  
  public abstract boolean a(int paramInt, View paramView, ListView paramListView);
  
  public abstract void b(int paramInt, View paramView, ListView paramListView);
  
  public abstract void c(int paramInt, View paramView, ListView paramListView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.OverScrollViewListener
 * JD-Core Version:    0.7.0.1
 */