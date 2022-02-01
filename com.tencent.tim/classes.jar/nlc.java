import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nlc
  extends BaseAdapter
{
  private nlc.b a;
  private nlc.a b;
  private List<BaseAdapter> ki = new ArrayList();
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }
  
  public void a(nlc.a parama)
  {
    this.b = parama;
  }
  
  public void a(nlc.b paramb)
  {
    this.a = paramb;
  }
  
  public List<BaseAdapter> bh()
  {
    return this.ki;
  }
  
  public void destory() {}
  
  public void f(BaseAdapter paramBaseAdapter)
  {
    if ((this.ki == null) || (paramBaseAdapter == null)) {
      return;
    }
    this.ki.add(paramBaseAdapter);
    paramBaseAdapter.registerDataSetObserver(new nld(this));
  }
  
  public int getCount()
  {
    Iterator localIterator = this.ki.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((BaseAdapter)localIterator.next()).getCount() + i) {}
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    Iterator localIterator = this.ki.iterator();
    while (localIterator.hasNext())
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)localIterator.next();
      int i = localBaseAdapter.getCount();
      if (paramInt < i) {
        return localBaseAdapter.getItem(paramInt);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    Iterator localIterator = this.ki.iterator();
    while (localIterator.hasNext())
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)localIterator.next();
      int i = localBaseAdapter.getCount();
      if (paramInt < i) {
        return localBaseAdapter.getItemId(paramInt);
      }
      paramInt -= i;
    }
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    Iterator localIterator = this.ki.iterator();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    BaseAdapter localBaseAdapter;
    if (localIterator.hasNext())
    {
      localBaseAdapter = (BaseAdapter)localIterator.next();
      j = localBaseAdapter.getCount();
      if (i >= j) {}
    }
    for (i = localBaseAdapter.getItemViewType(i);; i = -1)
    {
      return i + paramInt;
      i -= j;
      paramInt = localBaseAdapter.getViewTypeCount() + paramInt;
      break;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Iterator localIterator = this.ki.iterator();
    int i = paramInt;
    Object localObject;
    int j;
    if (localIterator.hasNext())
    {
      localObject = (BaseAdapter)localIterator.next();
      j = ((BaseAdapter)localObject).getCount();
      if (i < j)
      {
        localObject = ((BaseAdapter)localObject).getView(i, paramView, paramViewGroup);
        if (this.a != null) {
          this.a.i(paramInt, (View)localObject);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(i, paramView, paramViewGroup, getItemId(i));
      return localObject;
      i -= j;
      break;
      localObject = null;
    }
  }
  
  public int getViewTypeCount()
  {
    Iterator localIterator = this.ki.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((BaseAdapter)localIterator.next()).getViewTypeCount() + i) {}
    return Math.max(i, 1);
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (this.b != null) {
      this.b.aZk();
    }
  }
  
  public static abstract interface a
  {
    public abstract void aZk();
  }
  
  public static abstract interface b
  {
    public abstract void i(int paramInt, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlc
 * JD-Core Version:    0.7.0.1
 */