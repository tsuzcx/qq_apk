package android.support.v7.widget;

import android.support.v7.app.ActionBar.Tab;
import android.view.View;
import android.view.View.OnClickListener;

class ScrollingTabContainerView$TabClickListener
  implements View.OnClickListener
{
  ScrollingTabContainerView$TabClickListener(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public void onClick(View paramView)
  {
    ((ScrollingTabContainerView.TabView)paramView).getTab().select();
    int j = this.this$0.mTabLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.this$0.mTabLayout.getChildAt(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ScrollingTabContainerView.TabClickListener
 * JD-Core Version:    0.7.0.1
 */