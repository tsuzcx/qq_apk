package com.tencent.mobileqq.emosm.view;

class DragSortListView$LiftAnimator
  extends DragSortListView.SmoothAnimator
{
  private float mFinalDragDeltaY;
  private float mInitDragDeltaY;
  
  public DragSortListView$LiftAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }
  
  public void onStart()
  {
    this.mInitDragDeltaY = this.this$0.mDragDeltaY;
    this.mFinalDragDeltaY = this.this$0.mFloatViewHeightHalf;
  }
  
  public void onUpdate(float paramFloat1, float paramFloat2)
  {
    if (this.this$0.mDragState != 4)
    {
      cancel();
      return;
    }
    this.this$0.mDragDeltaY = ((int)(this.mFinalDragDeltaY * paramFloat2 + (1.0F - paramFloat2) * this.mInitDragDeltaY));
    this.this$0.mFloatLoc.y = (this.this$0.mY - this.this$0.mDragDeltaY);
    this.this$0.doDragFloatView(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.LiftAnimator
 * JD-Core Version:    0.7.0.1
 */