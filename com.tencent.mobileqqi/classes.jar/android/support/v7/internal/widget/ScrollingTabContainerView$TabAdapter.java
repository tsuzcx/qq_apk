package android.support.v7.internal.widget;

import android.support.v7.app.ActionBar.Tab;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

class ScrollingTabContainerView$TabAdapter
  extends BaseAdapter
{
  private ScrollingTabContainerView$TabAdapter(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public int getCount()
  {
    return ScrollingTabContainerView.access$200(this.this$0).getChildCount();
  }
  
  public Object getItem(int paramInt)
  {
    return ((ScrollingTabContainerView.TabView)ScrollingTabContainerView.access$200(this.this$0).getChildAt(paramInt)).getTab();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      return ScrollingTabContainerView.access$300(this.this$0, (ActionBar.Tab)getItem(paramInt), true);
    }
    ((ScrollingTabContainerView.TabView)paramView).bindTab((ActionBar.Tab)getItem(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.TabAdapter
 * JD-Core Version:    0.7.0.1
 */