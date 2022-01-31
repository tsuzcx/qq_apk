package com.tencent.mobileqq.emosm.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;

class DragSortListView$AdapterWrapper
  extends BaseAdapter
{
  private ListAdapter mAdapter;
  
  public DragSortListView$AdapterWrapper(DragSortListView paramDragSortListView, ListAdapter paramListAdapter)
  {
    this.mAdapter = paramListAdapter;
    this.mAdapter.registerDataSetObserver(new DragSortListView.AdapterWrapper.1(this, paramDragSortListView));
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.mAdapter.areAllItemsEnabled();
  }
  
  public ListAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public int getCount()
  {
    return this.mAdapter.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mAdapter.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.mAdapter.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.mAdapter.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = (DragSortItemView)paramView;
      View localView1 = paramViewGroup.getChildAt(0);
      View localView2 = this.mAdapter.getView(paramInt, localView1, this.this$0);
      paramView = paramViewGroup;
      if (localView2 != localView1)
      {
        if (localView1 != null) {
          paramViewGroup.removeViewAt(0);
        }
        paramViewGroup.addView(localView2);
        paramView = paramViewGroup;
      }
      DragSortListView.access$000(this.this$0, this.this$0.getHeaderViewsCount() + paramInt, paramView, true);
      return paramView;
    }
    paramViewGroup = this.mAdapter.getView(paramInt, null, this.this$0);
    if ((paramViewGroup instanceof Checkable)) {}
    for (paramView = new DragSortItemViewCheckable(this.this$0.getContext());; paramView = new DragSortItemView(this.this$0.getContext()))
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramView.addView(paramViewGroup);
      break;
    }
  }
  
  public int getViewTypeCount()
  {
    return this.mAdapter.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.mAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.mAdapter.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.mAdapter.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.AdapterWrapper
 * JD-Core Version:    0.7.0.1
 */