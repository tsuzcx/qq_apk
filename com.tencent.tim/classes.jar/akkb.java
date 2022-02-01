import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akkb
  extends BaseAdapter
{
  final akkd a;
  final BaseAdapter h;
  
  akkb(akkd paramakkd, BaseAdapter paramBaseAdapter)
  {
    this.a = paramakkd;
    this.h = paramBaseAdapter;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.h.areAllItemsEnabled();
  }
  
  public int getCount()
  {
    return this.h.getCount();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.h.getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    return this.h.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.h.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.h.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.h.getView(paramInt, paramView, paramViewGroup);
    this.a.a(paramViewGroup, localView, paramInt);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return this.h.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.h.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.h.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.h.isEnabled(paramInt);
  }
  
  public void notifyDataSetChanged()
  {
    this.h.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    this.h.notifyDataSetInvalidated();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.h.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.h.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkb
 * JD-Core Version:    0.7.0.1
 */