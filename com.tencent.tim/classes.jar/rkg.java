import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rkg
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, rkh.a
{
  private int bsM;
  private List<rkh> oZ = new ArrayList();
  
  public rkg(@NonNull List<rkh> paramList)
  {
    if (paramList.isEmpty()) {
      ram.w("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.oZ.addAll(paramList);
    bvj();
    paramList = this.oZ.iterator();
    while (paramList.hasNext()) {
      ((rkh)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private rkg.a a(int paramInt)
  {
    Iterator localIterator = this.oZ.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      rkh localrkh = (rkh)localIterator.next();
      j = localrkh.tz() + i;
      if (paramInt <= j - 1) {
        return new rkg.a(localrkh, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void bvj()
  {
    Iterator localIterator = this.oZ.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((rkh)localIterator.next()).tz() + i) {}
    this.bsM = i;
  }
  
  @Nullable
  public rkh a()
  {
    Iterator localIterator = this.oZ.iterator();
    while (localIterator.hasNext())
    {
      rkh localrkh = (rkh)localIterator.next();
      if (localrkh.aHE) {
        return localrkh;
      }
    }
    return null;
  }
  
  public void a(rkh paramrkh)
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.bsM;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    rkg.a locala = a(paramInt);
    return locala.a.J(locala.bsN);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    rkg.a locala = a(paramInt);
    rkh localrkh = locala.a;
    int i = locala.bsN;
    if (paramView == null) {
      paramView = localrkh.d(i, paramViewGroup);
    }
    for (;;)
    {
      localrkh.m(i, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void notifyDataSetChanged()
  {
    bvj();
    super.notifyDataSetChanged();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = a(paramInt);
    rkh localrkh1 = ((rkg.a)localObject).a;
    localrkh1.onClick(((rkg.a)localObject).bsN);
    if ((localrkh1 instanceof rkf)) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localrkh1.setSelect(true);
      localObject = this.oZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        rkh localrkh2 = (rkh)((Iterator)localObject).next();
        if (localrkh2 != localrkh1)
        {
          localrkh2.setSelect(false);
          localrkh2.setOpen(false);
        }
      }
      notifyDataSetChanged();
    }
  }
  
  static class a
  {
    final rkh a;
    final int bsN;
    
    public a(rkh paramrkh, int paramInt)
    {
      this.a = paramrkh;
      this.bsN = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkg
 * JD-Core Version:    0.7.0.1
 */