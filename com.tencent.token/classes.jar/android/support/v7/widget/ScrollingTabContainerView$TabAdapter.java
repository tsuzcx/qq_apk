package android.support.v7.widget;

import android.support.v7.app.ActionBar.Tab;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class ScrollingTabContainerView$TabAdapter
  extends BaseAdapter
{
  ScrollingTabContainerView$TabAdapter(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public int getCount()
  {
    return this.this$0.mTabLayout.getChildCount();
  }
  
  public Object getItem(int paramInt)
  {
    return ((ScrollingTabContainerView.TabView)this.this$0.mTabLayout.getChildAt(paramInt)).getTab();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      return this.this$0.createTabView((ActionBar.Tab)getItem(paramInt), true);
    }
    ((ScrollingTabContainerView.TabView)paramView).bindTab((ActionBar.Tab)getItem(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ScrollingTabContainerView.TabAdapter
 * JD-Core Version:    0.7.0.1
 */