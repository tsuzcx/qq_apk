package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class BaseHornListActivity$BaseHornAdapter
  extends BaseAdapter
{
  public boolean a;
  public boolean b = false;
  
  public BaseHornListActivity$BaseHornAdapter(BaseHornListActivity paramBaseHornListActivity) {}
  
  public int getCount()
  {
    int j = this.a.a.size();
    if (this.b) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (getItemViewType(paramInt) == 1) {
      return null;
    }
    return this.a.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.a.a.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseHornListActivity.BaseHornAdapter
 * JD-Core Version:    0.7.0.1
 */