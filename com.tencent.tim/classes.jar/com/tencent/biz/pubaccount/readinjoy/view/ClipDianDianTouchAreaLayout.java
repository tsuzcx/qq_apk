package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class ClipDianDianTouchAreaLayout
  extends FrameLayout
{
  private Rect Q = new Rect();
  private int aXL;
  int aXM;
  boolean arl = false;
  VelocityTracker b;
  private View mi;
  int mode = 1;
  
  public ClipDianDianTouchAreaLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClipDianDianTouchAreaLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aXM = ViewConfiguration.get(paramContext).getScaledMinimumFlingVelocity();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.mi == null)
    {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if (k == 0)
    {
      this.mi.getHitRect(this.Q);
      this.Q.inset(this.aXL, this.aXL);
      this.arl = false;
      this.mode = 1;
      if (this.b == null)
      {
        this.b = VelocityTracker.obtain();
        label93:
        this.b.addMovement(paramMotionEvent);
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (!this.Q.contains(i, j)) {
        break;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.b.clear();
      break label93;
      if (k == 2)
      {
        bool1 = bool2;
        if (this.arl) {
          break;
        }
        if (this.b != null)
        {
          this.b.addMovement(paramMotionEvent);
          this.b.computeCurrentVelocity(1000);
          if (Math.abs((int)this.b.getYVelocity()) >= this.aXM) {
            this.mode = 2;
          }
        }
        if (this.mode != 2) {
          continue;
        }
        return true;
      }
      if ((k == 1) || (k == 3))
      {
        this.b.clear();
        this.b = null;
        this.arl = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.mi == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if ((k == 1) || (k == 3)) {
      this.arl = false;
    }
    if (this.mi != null)
    {
      if (k != 0) {
        break label104;
      }
      this.mi.getHitRect(this.Q);
      this.Q.inset(this.aXL, this.aXL);
      this.arl = false;
    }
    label104:
    do
    {
      do
      {
        return super.onTouchEvent(paramMotionEvent);
      } while (k != 2);
      if (this.mode == 2)
      {
        if (this.b == null) {
          break;
        }
        this.b.clear();
        this.b = null;
        return false;
      }
      if (this.arl)
      {
        if (this.b == null) {
          break;
        }
        this.b.clear();
        this.b = null;
        return false;
      }
    } while (this.Q.contains(i, j));
    this.arl = true;
    super.onTouchEvent(paramMotionEvent);
    setPressed(false);
    return false;
  }
  
  public void setTouchWidget(View paramView, int paramInt)
  {
    this.mi = paramView;
    this.aXL = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ClipDianDianTouchAreaLayout
 * JD-Core Version:    0.7.0.1
 */