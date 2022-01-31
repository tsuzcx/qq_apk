package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

class SpinnerICS$DropDownAdapter
  implements ListAdapter, SpinnerAdapter
{
  private SpinnerAdapter mAdapter;
  private ListAdapter mListAdapter;
  
  public SpinnerICS$DropDownAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    this.mAdapter = paramSpinnerAdapter;
    if ((paramSpinnerAdapter instanceof ListAdapter)) {
      this.mListAdapter = ((ListAdapter)paramSpinnerAdapter);
    }
  }
  
  public boolean areAllItemsEnabled()
  {
    ListAdapter localListAdapter = this.mListAdapter;
    if (localListAdapter != null) {
      return localListAdapter.areAllItemsEnabled();
    }
    return true;
  }
  
  public int getCount()
  {
    if (this.mAdapter == null) {
      return 0;
    }
    return this.mAdapter.getCount();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mAdapter == null) {
      return null;
    }
    return this.mAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    if (this.mAdapter == null) {
      return null;
    }
    return this.mAdapter.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (this.mAdapter == null) {
      return -1L;
    }
    return this.mAdapter.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean hasStableIds()
  {
    return (this.mAdapter != null) && (this.mAdapter.hasStableIds());
  }
  
  public boolean isEmpty()
  {
    return getCount() == 0;
  }
  
  public boolean isEnabled(int paramInt)
  {
    ListAdapter localListAdapter = this.mListAdapter;
    if (localListAdapter != null) {
      return localListAdapter.isEnabled(paramInt);
    }
    return true;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.mAdapter != null) {
      this.mAdapter.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.mAdapter != null) {
      this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerICS.DropDownAdapter
 * JD-Core Version:    0.7.0.1
 */