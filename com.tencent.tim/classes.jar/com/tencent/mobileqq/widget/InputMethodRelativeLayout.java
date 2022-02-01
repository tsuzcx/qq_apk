package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import argb;

public class InputMethodRelativeLayout
  extends RelativeLayout
{
  public a a;
  private int cru;
  private boolean isOpen;
  private ViewTreeObserver.OnGlobalLayoutListener mLayoutListener = new argb(this);
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getViewTreeObserver().addOnGlobalLayoutListener(this.mLayoutListener);
  }
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getViewTreeObserver().addOnGlobalLayoutListener(this.mLayoutListener);
  }
  
  private int zR()
  {
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  public void setOnSizeChangedListenner(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void l(boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InputMethodRelativeLayout
 * JD-Core Version:    0.7.0.1
 */