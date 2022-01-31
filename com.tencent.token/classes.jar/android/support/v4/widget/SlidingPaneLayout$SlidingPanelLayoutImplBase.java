package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class SlidingPaneLayout$SlidingPanelLayoutImplBase
  implements SlidingPaneLayout.SlidingPanelLayoutImpl
{
  public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    ViewCompat.postInvalidateOnAnimation(paramSlidingPaneLayout, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase
 * JD-Core Version:    0.7.0.1
 */