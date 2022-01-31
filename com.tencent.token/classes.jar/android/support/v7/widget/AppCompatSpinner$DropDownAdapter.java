package android.support.v7.widget;

import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

class AppCompatSpinner$DropDownAdapter
  implements ListAdapter, SpinnerAdapter
{
  private SpinnerAdapter mAdapter;
  private ListAdapter mListAdapter;
  
  public AppCompatSpinner$DropDownAdapter(@Nullable SpinnerAdapter paramSpinnerAdapter, @Nullable Resources.Theme paramTheme)
  {
    this.mAdapter = paramSpinnerAdapter;
    if ((paramSpinnerAdapter instanceof ListAdapter)) {
      this.mListAdapter = ((ListAdapter)paramSpinnerAdapter);
    }
    if (paramTheme != null)
    {
      if ((Build.VERSION.SDK_INT < 23) || (!(paramSpinnerAdapter instanceof android.widget.ThemedSpinnerAdapter))) {
        break label66;
      }
      paramSpinnerAdapter = (android.widget.ThemedSpinnerAdapter)paramSpinnerAdapter;
      if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
        paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
      }
    }
    label66:
    do
    {
      do
      {
        return;
      } while (!(paramSpinnerAdapter instanceof ThemedSpinnerAdapter));
      paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
    } while (paramSpinnerAdapter.getDropDownViewTheme() != null);
    paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner.DropDownAdapter
 * JD-Core Version:    0.7.0.1
 */