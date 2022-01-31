package android.support.v4.widget;

import android.view.View;

class SlidingPaneLayout$DragHelperCallback
  extends ViewDragHelper.Callback
{
  SlidingPaneLayout$DragHelperCallback(SlidingPaneLayout paramSlidingPaneLayout) {}
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    paramView = (SlidingPaneLayout.LayoutParams)this.this$0.mSlideableView.getLayoutParams();
    if (this.this$0.isLayoutRtlSupport())
    {
      paramInt2 = this.this$0.getWidth();
      i = this.this$0.getPaddingRight();
      paramInt2 -= paramView.rightMargin + i + this.this$0.mSlideableView.getWidth();
      i = this.this$0.mSlideRange;
      return Math.max(Math.min(paramInt1, paramInt2), paramInt2 - i);
    }
    paramInt2 = this.this$0.getPaddingLeft();
    paramInt2 = paramView.leftMargin + paramInt2;
    int i = this.this$0.mSlideRange;
    return Math.min(Math.max(paramInt1, paramInt2), i + paramInt2);
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getTop();
  }
  
  public int getViewHorizontalDragRange(View paramView)
  {
    return this.this$0.mSlideRange;
  }
  
  public void onEdgeDragStarted(int paramInt1, int paramInt2)
  {
    this.this$0.mDragHelper.captureChildView(this.this$0.mSlideableView, paramInt2);
  }
  
  public void onViewCaptured(View paramView, int paramInt)
  {
    this.this$0.setAllChildrenVisible();
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    if (this.this$0.mDragHelper.getViewDragState() == 0)
    {
      if (this.this$0.mSlideOffset == 0.0F)
      {
        this.this$0.updateObscuredViewsVisibility(this.this$0.mSlideableView);
        this.this$0.dispatchOnPanelClosed(this.this$0.mSlideableView);
        this.this$0.mPreservedOpenState = false;
      }
    }
    else {
      return;
    }
    this.this$0.dispatchOnPanelOpened(this.this$0.mSlideableView);
    this.this$0.mPreservedOpenState = true;
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.this$0.onPanelDragged(paramInt1);
    this.this$0.invalidate();
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    int i;
    int j;
    if (this.this$0.isLayoutRtlSupport())
    {
      i = this.this$0.getPaddingRight();
      j = localLayoutParams.rightMargin + i;
      if (paramFloat1 >= 0.0F)
      {
        i = j;
        if (paramFloat1 == 0.0F)
        {
          i = j;
          if (this.this$0.mSlideOffset <= 0.5F) {}
        }
      }
      else
      {
        i = j + this.this$0.mSlideRange;
      }
      j = this.this$0.mSlideableView.getWidth();
      i = this.this$0.getWidth() - i - j;
    }
    for (;;)
    {
      this.this$0.mDragHelper.settleCapturedViewAt(i, paramView.getTop());
      this.this$0.invalidate();
      return;
      i = this.this$0.getPaddingLeft();
      j = localLayoutParams.leftMargin + i;
      if (paramFloat1 <= 0.0F)
      {
        i = j;
        if (paramFloat1 == 0.0F)
        {
          i = j;
          if (this.this$0.mSlideOffset <= 0.5F) {}
        }
      }
      else
      {
        i = j + this.this$0.mSlideRange;
      }
    }
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    if (this.this$0.mIsUnableToDrag) {
      return false;
    }
    return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).slideable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout.DragHelperCallback
 * JD-Core Version:    0.7.0.1
 */