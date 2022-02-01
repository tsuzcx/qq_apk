package com.tencent.mobileqq.magicface.view;

import aiyq;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MagicfaceContainerView
  extends RelativeLayout
{
  public a a;
  boolean cmK = false;
  GestureDetector.SimpleOnGestureListener d = new aiyq(this);
  GestureDetector gestureDetector;
  
  public MagicfaceContainerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MagicfaceContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.gestureDetector = new GestureDetector(this.d);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.cmK) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.cmK)
    {
      this.gestureDetector.onTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMagicfaceGestureListener(a parama)
  {
    this.a = parama;
  }
  
  public void setTouchEffect(boolean paramBoolean)
  {
    this.cmK = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract boolean kl(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceContainerView
 * JD-Core Version:    0.7.0.1
 */