package android.support.v4.widget;

import android.view.View;
import java.util.ArrayList;

class SlidingPaneLayout$DisableLayerRunnable
  implements Runnable
{
  final View mChildView;
  
  SlidingPaneLayout$DisableLayerRunnable(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    this.mChildView = paramView;
  }
  
  public void run()
  {
    if (this.mChildView.getParent() == this.this$0)
    {
      this.mChildView.setLayerType(0, null);
      this.this$0.invalidateChildRegion(this.mChildView);
    }
    this.this$0.mPostedRunnables.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout.DisableLayerRunnable
 * JD-Core Version:    0.7.0.1
 */