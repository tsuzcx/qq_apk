package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import aqcx;
import com.tencent.widget.HorizontalListView;
import wja;

public class OverScrollCallbackHorizontalListView
  extends HorizontalListView
{
  private a a;
  private boolean aGk;
  private boolean akU;
  private int egP;
  private float iq;
  private float is;
  
  public OverScrollCallbackHorizontalListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public OverScrollCallbackHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.egP = wja.dp2px(50.0F, getResources());
    setOverScrollMode(0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    if (i == 0)
    {
      this.is = f1;
      this.iq = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.akU = true;
      this.aGk = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      float f2 = this.is;
      f3 -= this.iq;
      if ((this.akU) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > aqcx.dip2px(getContext(), 5.0F))) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      if ((i == 3) || (i == 1)) {
        this.akU = false;
      }
    }
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if ((this.aGk) && (paramInt3 > this.egP))
    {
      this.aGk = false;
      if ((this.a != null) && (this.akU)) {
        this.a.a(this);
      }
    }
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public void setListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(OverScrollCallbackHorizontalListView paramOverScrollCallbackHorizontalListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView
 * JD-Core Version:    0.7.0.1
 */