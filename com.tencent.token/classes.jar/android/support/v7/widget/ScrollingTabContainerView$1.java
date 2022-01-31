package android.support.v7.widget;

import android.view.View;

class ScrollingTabContainerView$1
  implements Runnable
{
  ScrollingTabContainerView$1(ScrollingTabContainerView paramScrollingTabContainerView, View paramView) {}
  
  public void run()
  {
    int i = this.val$tabView.getLeft();
    int j = (this.this$0.getWidth() - this.val$tabView.getWidth()) / 2;
    this.this$0.smoothScrollTo(i - j, 0);
    this.this$0.mTabSelector = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ScrollingTabContainerView.1
 * JD-Core Version:    0.7.0.1
 */