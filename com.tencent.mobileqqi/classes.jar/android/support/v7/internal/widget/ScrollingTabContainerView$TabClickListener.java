package android.support.v7.internal.widget;

import android.support.v7.app.ActionBar.Tab;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

class ScrollingTabContainerView$TabClickListener
  implements View.OnClickListener
{
  private ScrollingTabContainerView$TabClickListener(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public void onClick(View paramView)
  {
    ((ScrollingTabContainerView.TabView)paramView).getTab().select();
    int j = ScrollingTabContainerView.access$200(this.this$0).getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = ScrollingTabContainerView.access$200(this.this$0).getChildAt(i);
      if (localView == paramView) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        i += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.TabClickListener
 * JD-Core Version:    0.7.0.1
 */