package android.support.v4.widget;

import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.view.View;

@RequiresApi(17)
class SlidingPaneLayout$SlidingPanelLayoutImplJBMR1
  extends SlidingPaneLayout.SlidingPanelLayoutImplBase
{
  public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    ViewCompat.setLayerPaint(paramView, ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).dimPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplJBMR1
 * JD-Core Version:    0.7.0.1
 */