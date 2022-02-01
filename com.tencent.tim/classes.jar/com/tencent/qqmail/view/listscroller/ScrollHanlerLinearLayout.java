package com.tencent.qqmail.view.listscroller;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ScrollHanlerLinearLayout
  extends LinearLayout
  implements ContactScrollListView.IScrollListViewHandler
{
  private ScrollDialHandler mScrollDialHandler = null;
  
  public ScrollHanlerLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.mScrollDialHandler.IsEnableScroll()) {
      this.mScrollDialHandler.dispatchDraw(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.mScrollDialHandler.IsEnableScroll()) {
      return;
    }
    this.mScrollDialHandler.draw(paramCanvas);
  }
  
  public ScrollDialHandler getScrollLayoutHandler()
  {
    return this.mScrollDialHandler;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.mScrollDialHandler.setEnableScroll(paramBoolean);
  }
  
  public void startScroll()
  {
    if (!this.mScrollDialHandler.IsEnableScroll()) {
      return;
    }
    this.mScrollDialHandler.startScroll(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.listscroller.ScrollHanlerLinearLayout
 * JD-Core Version:    0.7.0.1
 */