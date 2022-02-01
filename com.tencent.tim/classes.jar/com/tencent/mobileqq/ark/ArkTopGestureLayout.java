package com.tencent.mobileqq.ark;

import android.content.Context;
import android.view.MotionEvent;
import aqgz;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.StickerDismissGestureDetector;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector;

public class ArkTopGestureLayout
  extends TopGestureLayout
{
  private int cJK = 10;
  
  public ArkTopGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void init(Context paramContext)
  {
    this.c = new a(paramContext);
    this.mTopGestureDetector = new TopGestureLayout.StickerDismissGestureDetector(this, paramContext, this.c);
    this.defaultGestureDetector = this.mTopGestureDetector;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (paramMotionEvent.getX() <= this.cJK / 100.0F * (float)aqgz.hK()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = super.onInterceptTouchEvent(paramMotionEvent);
      }
      return bool;
    }
  }
  
  public class a
    extends TopGestureLayout.TopGestureDetector
  {
    public a(Context paramContext)
    {
      super(paramContext);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((ArkTopGestureLayout.this.isGestureIdle()) || (ArkTopGestureLayout.this.isGestureEnd())) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
              paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
              if (!ArkTopGestureLayout.this.hasGestureFlag(1)) {
                break;
              }
            } while ((paramFloat1 >= 0.0F) || (paramFloat2 >= 0.5F) || (ArkTopGestureLayout.this.mOnFlingGesture == null));
            ArkTopGestureLayout.this.setGestureFlag(-1);
          } while (ArkTopGestureLayout.a(ArkTopGestureLayout.this));
          ArkTopGestureLayout.this.mOnFlingGesture.flingLToR();
          return false;
        } while ((!ArkTopGestureLayout.this.hasGestureFlag(2)) || (paramFloat1 <= 0.0F) || (paramFloat2 >= 0.5F) || (ArkTopGestureLayout.this.mOnFlingGesture == null));
        ArkTopGestureLayout.this.setGestureFlag(-1);
      } while (ArkTopGestureLayout.b(ArkTopGestureLayout.this));
      ArkTopGestureLayout.this.mOnFlingGesture.flingRToL();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */