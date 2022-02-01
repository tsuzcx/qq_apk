package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;

public class DuplicateEventLayout
  extends FrameLayout
{
  ClipDianDianTouchAreaLayout a;
  int aXP;
  boolean arm = false;
  boolean arn;
  ViewGroup bY;
  Rect mImageRect = new Rect();
  
  public DuplicateEventLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DuplicateEventLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aXP = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void A(MotionEvent paramMotionEvent)
  {
    int i = getScrollX() - this.bY.getLeft();
    int j = getScrollY() - this.bY.getTop();
    paramMotionEvent.offsetLocation(i, j);
    this.bY.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-i, -j);
  }
  
  private void B(MotionEvent paramMotionEvent)
  {
    int i = getScrollX() - this.a.getLeft();
    int j = getScrollY() - this.a.getTop();
    paramMotionEvent.offsetLocation(i, j);
    this.a.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-i, -j);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if ((this.bY == null) || (this.a == null)) {
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
    }
    int i;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        i = paramMotionEvent.getAction();
        if (i == 0)
        {
          this.a.getHitRect(this.mImageRect);
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          if (this.mImageRect.contains(i, j)) {
            bool1 = super.dispatchTouchEvent(paramMotionEvent);
          }
          for (this.arn = bool1;; this.arn = false)
          {
            this.arm = false;
            return bool1;
            bool1 = super.dispatchTouchEvent(paramMotionEvent);
          }
        }
        MotionEvent localMotionEvent1 = MotionEvent.obtain(paramMotionEvent);
        bool2 = super.dispatchTouchEvent(paramMotionEvent);
        if ((this.arn) && ((!bool2) || ((bool2) && (this.a.arl))))
        {
          if (!this.arm)
          {
            MotionEvent localMotionEvent2 = MotionEvent.obtain(paramMotionEvent);
            localMotionEvent2.setAction(0);
            A(localMotionEvent2);
            this.arm = true;
            localMotionEvent2.recycle();
            paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
            paramMotionEvent.setAction(3);
            B(paramMotionEvent);
          }
          A(localMotionEvent1);
        }
        localMotionEvent1.recycle();
        if (i == 1) {
          break;
        }
        bool1 = bool2;
      } while (i != 3);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("DuplicateEventLayout", 0, "action = " + i);
    return bool2;
  }
  
  public void setViews(ViewGroup paramViewGroup, ClipDianDianTouchAreaLayout paramClipDianDianTouchAreaLayout)
  {
    this.bY = paramViewGroup;
    this.a = paramClipDianDianTouchAreaLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.DuplicateEventLayout
 * JD-Core Version:    0.7.0.1
 */