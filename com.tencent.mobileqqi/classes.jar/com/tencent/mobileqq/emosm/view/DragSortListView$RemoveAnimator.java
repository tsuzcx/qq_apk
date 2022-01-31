package com.tencent.mobileqq.emosm.view;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class DragSortListView$RemoveAnimator
  extends DragSortListView.SmoothAnimator
{
  private int mFirstChildHeight = -1;
  private int mFirstPos;
  private float mFirstStartBlank;
  private float mFloatLocX;
  private int mSecondChildHeight = -1;
  private int mSecondPos;
  private float mSecondStartBlank;
  private int srcPos;
  
  public DragSortListView$RemoveAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }
  
  public void onStart()
  {
    int i = -1;
    this.mFirstChildHeight = -1;
    this.mSecondChildHeight = -1;
    this.mFirstPos = this.this$0.mFirstExpPos;
    this.mSecondPos = this.this$0.mSecondExpPos;
    this.srcPos = this.this$0.mSrcPos;
    this.this$0.mDragState = 1;
    this.mFloatLocX = this.this$0.mFloatLoc.x;
    if (this.this$0.mUseRemoveVelocity)
    {
      float f = this.this$0.getWidth() * 2.0F;
      if (this.this$0.mRemoveVelocityX == 0.0F)
      {
        DragSortListView localDragSortListView = this.this$0;
        if (this.mFloatLocX < 0.0F) {
          localDragSortListView.mRemoveVelocityX = (i * f);
        }
      }
      do
      {
        return;
        i = 1;
        break;
        f *= 2.0F;
        if ((this.this$0.mRemoveVelocityX < 0.0F) && (this.this$0.mRemoveVelocityX > -f))
        {
          this.this$0.mRemoveVelocityX = (-f);
          return;
        }
      } while ((this.this$0.mRemoveVelocityX <= 0.0F) || (this.this$0.mRemoveVelocityX >= f));
      this.this$0.mRemoveVelocityX = f;
      return;
    }
    DragSortListView.access$300(this.this$0);
  }
  
  public void onStop()
  {
    DragSortListView.access$500(this.this$0);
  }
  
  public void onUpdate(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 1.0F - paramFloat2;
    int j = this.this$0.getFirstVisiblePosition();
    View localView = this.this$0.getChildAt(this.mFirstPos - j);
    if (this.this$0.mUseRemoveVelocity)
    {
      paramFloat2 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / 1000.0F;
      if (paramFloat2 != 0.0F) {}
    }
    do
    {
      do
      {
        return;
        float f1 = this.this$0.mRemoveVelocityX;
        int k = this.this$0.getWidth();
        localObject = this.this$0;
        float f2 = ((DragSortListView)localObject).mRemoveVelocityX;
        if (this.this$0.mRemoveVelocityX > 0.0F) {}
        for (i = 1;; i = -1)
        {
          ((DragSortListView)localObject).mRemoveVelocityX = (i * paramFloat2 * k + f2);
          this.mFloatLocX += f1 * paramFloat2;
          this.this$0.mFloatLoc.x = ((int)this.mFloatLocX);
          if ((this.mFloatLocX >= k) || (this.mFloatLocX <= -k)) {
            break;
          }
          this.mStartTime = SystemClock.uptimeMillis();
          DragSortListView.access$100(this.this$0, true);
          return;
        }
        if (localView != null)
        {
          if (this.mFirstChildHeight == -1)
          {
            this.mFirstChildHeight = DragSortListView.access$400(this.this$0, this.mFirstPos, localView, false);
            this.mFirstStartBlank = (localView.getHeight() - this.mFirstChildHeight);
          }
          i = Math.max((int)(this.mFirstStartBlank * paramFloat1), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.mFirstChildHeight);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      } while (this.mSecondPos == this.mFirstPos);
      localView = this.this$0.getChildAt(this.mSecondPos - j);
    } while (localView == null);
    if (this.mSecondChildHeight == -1)
    {
      this.mSecondChildHeight = DragSortListView.access$400(this.this$0, this.mSecondPos, localView, false);
      this.mSecondStartBlank = (localView.getHeight() - this.mSecondChildHeight);
    }
    int i = Math.max((int)(this.mSecondStartBlank * paramFloat1), 1);
    Object localObject = localView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (i + this.mSecondChildHeight);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.RemoveAnimator
 * JD-Core Version:    0.7.0.1
 */