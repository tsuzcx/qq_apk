package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TabWidget;
import com.tencent.qphone.base.util.QLog;

public class QQTabWidget
  extends TabWidget
{
  private a b;
  private boolean dbk;
  private float pd;
  private float pe;
  
  public QQTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQTabWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      int i = paramMotionEvent.getAction();
      if ((i == 0) || (i == 1) || (i == 3)) {
        try
        {
          throw new RuntimeException();
        }
        catch (Exception localException)
        {
          QLog.d("QQTabWidget", 2, "QQTabWidget onInterceptTouchEvent. action=" + i + ",x=" + paramMotionEvent.getRawX() + ",y=" + paramMotionEvent.getRawY(), localException);
        }
      }
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.dbk = false;
      this.pd = paramMotionEvent.getX();
      this.pe = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((f2 < this.pe) && (this.pe - f2 > 50.0F) && (this.pe - f2 > Math.abs(this.pd - f1)) && (this.b != null) && (!this.dbk))
      {
        this.dbk = true;
        this.b.bRJ();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setTabWidgetMoveListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bRJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabWidget
 * JD-Core Version:    0.7.0.1
 */