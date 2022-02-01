import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView.b;
import java.util.ArrayList;
import java.util.Iterator;

public class auts
  implements Filterable, WrapperListAdapter
{
  static final ArrayList<ListView.b> Et = new ArrayList();
  boolean dkt;
  private final boolean dku;
  private final ListAdapter mAdapter;
  ArrayList<ListView.b> mFooterViewInfos;
  ArrayList<ListView.b> mHeaderViewInfos;
  
  public auts(ArrayList<ListView.b> paramArrayList1, ArrayList<ListView.b> paramArrayList2, ListAdapter paramListAdapter)
  {
    this.mAdapter = paramListAdapter;
    this.dku = (paramListAdapter instanceof Filterable);
    if (paramArrayList1 == null)
    {
      this.mHeaderViewInfos = Et;
      if (paramArrayList2 != null) {
        break label79;
      }
      this.mFooterViewInfos = Et;
      label39:
      if ((!X(this.mHeaderViewInfos)) || (!X(this.mFooterViewInfos))) {
        break label87;
      }
    }
    label79:
    label87:
    for (boolean bool = true;; bool = false)
    {
      this.dkt = bool;
      return;
      this.mHeaderViewInfos = paramArrayList1;
      break;
      this.mFooterViewInfos = paramArrayList2;
      break label39;
    }
  }
  
  private boolean X(ArrayList<ListView.b> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (!((ListView.b)paramArrayList.next()).isSelectable) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean areAllItemsEnabled()
  {
    return (this.mAdapter == null) || ((this.dkt) && (this.mAdapter.areAllItemsEnabled()));
  }
  
  public int getCount()
  {
    if (this.mAdapter != null) {
      return getFootersCount() + getHeadersCount() + this.mAdapter.getCount();
    }
    return getFootersCount() + getHeadersCount();
  }
  
  public Filter getFilter()
  {
    if (this.dku) {
      return ((Filterable)this.mAdapter).getFilter();
    }
    return null;
  }
  
  public int getFootersCount()
  {
    return this.mFooterViewInfos.size();
  }
  
  public int getHeadersCount()
  {
    return this.mHeaderViewInfos.size();
  }
  
  public Object getItem(int paramInt)
  {
    int i = getHeadersCount();
    if (paramInt < i) {
      return ((ListView.b)this.mHeaderViewInfos.get(paramInt)).data;
    }
    int j = paramInt - i;
    paramInt = 0;
    if (this.mAdapter != null)
    {
      i = this.mAdapter.getCount();
      paramInt = i;
      if (j < i) {
        return this.mAdapter.getItem(j);
      }
    }
    return ((ListView.b)this.mFooterViewInfos.get(j - paramInt)).data;
  }
  
  public long getItemId(int paramInt)
  {
    int i = getHeadersCount();
    if ((this.mAdapter != null) && (paramInt >= i))
    {
      paramInt -= i;
      if (paramInt < this.mAdapter.getCount()) {
        return this.mAdapter.getItemId(paramInt);
      }
    }
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = getHeadersCount();
    if ((this.mAdapter != null) && (paramInt >= i))
    {
      paramInt -= i;
      if (paramInt < this.mAdapter.getCount()) {
        return this.mAdapter.getItemViewType(paramInt);
      }
    }
    return -2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = getHeadersCount();
    View localView;
    if (paramInt < k) {
      localView = ((ListView.b)this.mHeaderViewInfos.get(paramInt)).view;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      int m = paramInt - k;
      int i = 0;
      if (this.mAdapter != null)
      {
        int j = this.mAdapter.getCount();
        i = j;
        if (m < j)
        {
          localView = this.mAdapter.getView(m, paramView, paramViewGroup);
          continue;
        }
      }
      try
      {
        localView = ((ListView.b)this.mFooterViewInfos.get(m - i)).view;
      }
      catch (Exception paramView)
      {
        throw new RuntimeException("adapter index out of bound. adapter count: " + i + ", footCount: " + this.mFooterViewInfos.size() + ", numHeaders:" + k + " , position: " + m + ", Adapter: " + this.mAdapter);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    if (this.mAdapter != null) {
      return this.mAdapter.getViewTypeCount();
    }
    return 1;
  }
  
  public ListAdapter getWrappedAdapter()
  {
    return this.mAdapter;
  }
  
  public boolean hasStableIds()
  {
    if (this.mAdapter != null) {
      return this.mAdapter.hasStableIds();
    }
    return false;
  }
  
  public boolean isEmpty()
  {
    return (this.mAdapter == null) || (this.mAdapter.isEmpty());
  }
  
  public boolean isEnabled(int paramInt)
  {
    int k = getHeadersCount();
    if (paramInt < k) {
      return ((ListView.b)this.mHeaderViewInfos.get(paramInt)).isSelectable;
    }
    int m = paramInt - k;
    int i;
    if (this.mAdapter != null)
    {
      int j = this.mAdapter.getCount();
      i = j;
      if (m < j) {
        return this.mAdapter.isEnabled(m);
      }
    }
    else
    {
      i = 0;
    }
    try
    {
      if (this.mFooterViewInfos.size() <= m - i)
      {
        QLog.e("HeaderViewListAdapter", 1, "adapter index out of bound. adapter count: " + i + ", footCount: " + this.mFooterViewInfos.size() + " , adjPosition: " + m + ", Adapter: " + this.mAdapter + "position=" + paramInt + "numHeaders=" + k);
        return false;
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException("adapter index out of bound. adapter count: " + i + ", footCount: " + this.mFooterViewInfos.size() + " , position: " + m + ", Adapter: " + this.mAdapter);
    }
    boolean bool = ((ListView.b)this.mFooterViewInfos.get(m - i)).isSelectable;
    return bool;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if ((this.mAdapter != null) && (paramDataSetObserver != null)) {
      this.mAdapter.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public boolean removeFooter(View paramView)
  {
    boolean bool2 = false;
    int i = 0;
    while (i < this.mFooterViewInfos.size())
    {
      if (((ListView.b)this.mFooterViewInfos.get(i)).view == paramView)
      {
        this.mFooterViewInfos.remove(i);
        boolean bool1 = bool2;
        if (X(this.mHeaderViewInfos))
        {
          bool1 = bool2;
          if (X(this.mFooterViewInfos)) {
            bool1 = true;
          }
        }
        this.dkt = bool1;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean removeHeader(View paramView)
  {
    boolean bool2 = false;
    int i = 0;
    while (i < this.mHeaderViewInfos.size())
    {
      if (((ListView.b)this.mHeaderViewInfos.get(i)).view == paramView)
      {
        this.mHeaderViewInfos.remove(i);
        boolean bool1 = bool2;
        if (X(this.mHeaderViewInfos))
        {
          bool1 = bool2;
          if (X(this.mFooterViewInfos)) {
            bool1 = true;
          }
        }
        this.dkt = bool1;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if ((this.mAdapter != null) && (paramDataSetObserver != null)) {
      this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auts
 * JD-Core Version:    0.7.0.1
 */