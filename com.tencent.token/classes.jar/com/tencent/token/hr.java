package com.tencent.token;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

abstract class hr
  implements AdapterView.OnItemClickListener, ht, hx
{
  Rect e;
  
  protected static int a(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt)
  {
    int j = 0;
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i3 = paramListAdapter.getCount();
    Object localObject1 = paramViewGroup;
    paramViewGroup = null;
    int i = 0;
    int m = 0;
    while (j < i3)
    {
      int n = paramListAdapter.getItemViewType(j);
      int k = m;
      if (n != m)
      {
        paramViewGroup = null;
        k = n;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new FrameLayout(paramContext);
      }
      paramViewGroup = paramListAdapter.getView(j, paramViewGroup, (ViewGroup)localObject2);
      paramViewGroup.measure(i1, i2);
      m = paramViewGroup.getMeasuredWidth();
      if (m >= paramInt) {
        return paramInt;
      }
      n = i;
      if (m > i) {
        n = m;
      }
      j += 1;
      m = k;
      localObject1 = localObject2;
      i = n;
    }
    return i;
  }
  
  protected static hl a(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof HeaderViewListAdapter)) {
      return (hl)((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter();
    }
    return (hl)paramListAdapter;
  }
  
  protected static boolean b(hm paramhm)
  {
    int j = paramhm.size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = paramhm.getItem(i);
      if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public abstract void a(int paramInt);
  
  public final void a(Context paramContext, hm paramhm) {}
  
  public abstract void a(View paramView);
  
  public abstract void a(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void a(hm paramhm);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(int paramInt);
  
  public final boolean b(ho paramho)
  {
    return false;
  }
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  public final boolean c(ho paramho)
  {
    return false;
  }
  
  protected boolean f()
  {
    return true;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (ListAdapter)paramAdapterView.getAdapter();
    paramAdapterView = a(paramView).b;
    paramView = (MenuItem)paramView.getItem(paramInt);
    if (f()) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    paramAdapterView.a(paramView, this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hr
 * JD-Core Version:    0.7.0.1
 */