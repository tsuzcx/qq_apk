package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import ram;
import roo;

public class CustomViewPager
  extends ViewPager
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  public roo a = new roo(paramContext, this);
  public boolean aCW = true;
  public GestureDetector.SimpleOnGestureListener b;
  public float mLastX;
  public float mLastY;
  public float mf;
  public float mg;
  
  public CustomViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a.setOnDoubleTapListener(this);
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      Object localObject = ViewPager.class.getDeclaredField("mDrawingOrderedChildren");
      ((Field)localObject).setAccessible(true);
      localObject = (ArrayList)((Field)localObject).get(this);
      if ((localObject == null) || (((ArrayList)localObject).size() != getChildCount()))
      {
        ram.w("Q.qqstory.player.ViewPager", "getChildDrawingOrder invoke sortChildDrawingOrder() by ourselves !");
        localObject = ViewPager.class.getDeclaredMethod("sortChildDrawingOrder", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(this, new Object[0]);
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        ram.e("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localNoSuchMethodException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        ram.e("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        ram.e("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localInvocationTargetException);
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        ram.e("Q.qqstory.player.ViewPager", "getChildDrawingOrder", localNoSuchFieldException);
      }
    }
    return super.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.b != null) {
      return this.b.onDoubleTap(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    if (this.b != null) {
      return this.b.onDoubleTapEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (this.b != null) {
      return this.b.onDown(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.b != null) {
      return this.b.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.aCW) {
      return false;
    }
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = SystemClock.uptimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ram.b("Q.qqstory.player.ViewPager", "onLayout, cost=%d", Long.valueOf(SystemClock.uptimeMillis() - l));
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.b != null) {
      this.b.onLongPress(paramMotionEvent);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.b != null) {
      return this.b.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (this.b != null) {
      this.b.onShowPress(paramMotionEvent);
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.b != null) {
      return this.b.onSingleTapConfirmed(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.b != null) {
      return this.b.onSingleTapUp(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.a.onTouchEvent(paramMotionEvent);
    if (!this.aCW) {
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      try
      {
        bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException paramMotionEvent) {}
      this.mg = 0.0F;
      this.mf = 0.0F;
      this.mLastX = paramMotionEvent.getX();
      this.mLastY = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mf += Math.abs(f1 - this.mLastX);
      this.mg += Math.abs(f2 - this.mLastY);
      this.mLastX = f1;
      this.mLastY = f2;
      if (this.mf <= this.mg)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        return false;
      }
    }
    return false;
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    long l = SystemClock.uptimeMillis();
    super.setAdapter(paramPagerAdapter);
    ram.b("Q.qqstory.player.ViewPager", "setAdapter, cost=%d", Long.valueOf(SystemClock.uptimeMillis() - l));
  }
  
  public void setGestureListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    this.b = paramSimpleOnGestureListener;
  }
  
  public static abstract class CustomViewPagerAdapter
    extends PagerAdapter
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */